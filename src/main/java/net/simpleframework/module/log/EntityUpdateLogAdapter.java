package net.simpleframework.module.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.DbTableColumn;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.db.common.EntityInterceptor;
import net.simpleframework.common.BeanUtils;
import net.simpleframework.common.Convert;
import net.simpleframework.common.ID;
import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.common.object.ObjectUtils;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;
import net.simpleframework.module.common.log.LdescVal;
import net.simpleframework.module.common.log.LogEntity;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityUpdateLogAdapter extends AbstractEntityLogAdapter<Object> {

	@Override
	public void onBeforeUpdate(final IDbEntityManager<Object> manager, final String[] columns,
			final Object[] beans) throws Exception {
		super.onBeforeUpdate(manager, columns, beans);
		if (LogEntity.isDisable()) {
			LogEntity.enable();
			return;
		}

		final LoginWrapper wrapper = LoginUser.get();
		if (wrapper == null || wrapper.getUserId() == null) {
			return;
		}

		final Class<?> beanClass = manager.getEntityTable().getBeanClass();
		final Map<String, DbTableColumn> map = DbTableColumn.getTableColumns(beanClass);
		final List<DbTableColumn> columnList = new ArrayList<DbTableColumn>();
		final String[] columnArr = beanClass.getAnnotation(EntityInterceptor.class).columns();
		String[] _columns = null;
		if (columnArr != null && columnArr.length > 0) {
			_columns = columnArr;
		} else if (columns != null && columns.length > 0) {
			_columns = columns;
		}
		if (_columns != null) {
			for (final String s : _columns) {
				if (columns != null && !ArrayUtils.contains(columns, s, true)) {
					continue;
				}
				final DbTableColumn col = map.get(s);
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

		final Date now = new Date();
		for (final Object bean : beans) {
			final ID beanId = getId(bean);
			final int opId = _logUpdateService.max("opId", "beanId=?", beanId).intValue();
			final Map<String, Object> original = getOriginal(manager, beanId, _columns);
			for (final DbTableColumn col : columnList) {
				final String key = col.getName();
				final Object fromVal = toObject(Convert.convert(original.get(key),
						BeanUtils.getPropertyType(bean, key)));
				// if (opId == 0 && fromVal == null) {
				// // 第一次，且fromVal为空，不记录
				// continue;
				// }
				final Object toVal = toObject(BeanUtils.getProperty(bean, key));
				if (ObjectUtils.objectEquals(fromVal, toVal)) {
					continue;
				}
				final EntityUpdateLog log = _logUpdateService.createBean();
				initLog(log, wrapper);
				log.setBeanId(beanId);
				log.setTblName(manager.getEntityTable().getName());
				log.setOpId(opId + 1);
				log.setValName(key);
				log.setFromVal(covertToString(fromVal));
				log.setToVal(covertToString(toVal));
				log.setCreateDate(now);
				log.setDescription(LdescVal.get(bean));
				_logUpdateService.insert(log);
			}
		}
	}

	protected Object toObject(final Object o) {
		if ("".equals(o)) {
			return null;
		}
		if (o instanceof Date && !Date.class.equals(o.getClass())) {
			return new Date(((Date) o).getTime());
		}
		return o;
	}

	@Override
	public void onBeforeDelete(final IDbEntityManager<Object> manager, final IParamsValue paramsValue)
			throws Exception {
		super.onBeforeDelete(manager, paramsValue);
		// 当被删除后,删除日志??
	}
}
