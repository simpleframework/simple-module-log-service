package net.simpleframework.module.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.ado.db.common.TableColumn;
import net.simpleframework.common.BeanUtils;
import net.simpleframework.common.Convert;
import net.simpleframework.common.ID;
import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.common.object.ObjectUtils;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;
import net.simpleframework.module.common.DescriptionLocalUtils;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityUpdateLogAdapter extends AbstractEntityLogAdapter {

	protected String covertToString(final Object val) {
		if (val instanceof Enum) {
			return ((Enum<?>) val).name();
		} else if (val instanceof Date) {
			return Convert.toDateString((Date) val);
		}
		return Convert.toString(val);
	}

	protected ID getId(final Object bean) {
		return (ID) BeanUtils.getProperty(bean, "id");
	}

	@Override
	public void onBeforeUpdate(final IDbEntityManager<?> manager, final String[] columns,
			final Object[] beans) {
		super.onBeforeUpdate(manager, columns, beans);
		final LoginWrapper wrapper = LoginUser.get();
		ID loginId;
		if (wrapper == null || (loginId = wrapper.getUser().getId()) == null) {
			return;
		}

		final Class<?> beanClass = manager.getEntityTable().getBeanClass();
		final Map<String, TableColumn> map = TableColumn.getTableColumns(beanClass);
		final List<TableColumn> columnList = new ArrayList<TableColumn>();
		final String[] columnArr = beanClass.getAnnotation(EntityInterceptor.class).columns();
		String[] _columns = null;
		if (columnArr != null && columnArr.length > 0) {
			_columns = columnArr;
		} else if (columns != null && columns.length > 0) {
			_columns = columns;
		}
		if (_columns != null) {
			for (final String s : _columns) {
				if (columns != null && !ArrayUtils.contains(columns, s)) {
					continue;
				}
				final TableColumn col = map.get(s);
				if (col != null) {
					columnList.add(col);
				}
			}
		} else {
			columnList.addAll(map.values());
		}

		if (columnList.size() == 0) {
			return;
		}

		final IEntityUpdateLogService service = context.getEntityUpdateLogService();
		final int opId = service.max("opId");
		final Date now = new Date();
		for (final Object bean : beans) {
			final ID beanId = getId(bean);
			final Map<String, Object> original = getOriginal(manager, beanId, _columns);
			for (final TableColumn col : columnList) {
				final String key = col.getName();
				final Object toVal = BeanUtils.getProperty(bean, key);
				final Object fromVal = Convert.convert(original.get(key),
						BeanUtils.getPropertyType(bean, key));
				if (ObjectUtils.objectEquals(fromVal, toVal)) {
					continue;
				}
				final EntityUpdateLog field = service.createBean();

				field.setBeanId(beanId);
				field.setOpId(opId + 1);
				field.setValName(key);
				field.setFromVal(covertToString(fromVal));
				field.setToVal(covertToString(toVal));
				field.setUserId(loginId);
				field.setCreateDate(now);
				field.setIp(wrapper.getIp());
				field.setDescription(DescriptionLocalUtils.get(beanId));
				service.insert(field);
			}
		}
	}

	@Override
	public void onBeforeDelete(final IDbEntityManager<?> manager, final IParamsValue paramsValue) {
		super.onBeforeDelete(manager, paramsValue);
		// 当被删除后,删除日志??
	}
}
