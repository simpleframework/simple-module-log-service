package net.simpleframework.module.log;

import java.util.Date;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.bean.IIdBeanAware;
import net.simpleframework.ado.db.IDbDataQuery;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.common.BeanUtils;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class EntityDeleteLogAdapter extends AbstractEntityLogAdapter {

	@Override
	public void onBeforeDelete(final IDbEntityManager<?> manager, final IParamsValue paramsValue) {
		super.onBeforeDelete(manager, paramsValue);
		final LoginWrapper wrapper = LoginUser.get();
		if (wrapper == null) {
			return;
		}

		final IDbDataQuery<?> dq = manager.queryBeans(paramsValue);
		if (dq.getCount() == 0) {
			return;
		}

		final IEntityDeleteLogService service = context.getEntityDeleteLogService();
		Object o;
		while ((o = dq.next()) != null) {
			final EntityDeleteLog log = service.createBean();
			log.setTblName(manager.getEntityTable().getName());
			if (o instanceof IIdBeanAware) {
				log.setBeanId(((IIdBeanAware) o).getId());
			} else {
				final Object id = BeanUtils.getProperty(o, "id");
				if (id != null) {
					log.setBeanId(ID.of(id));
				}
			}
			log.setIp(wrapper.getIp());
			log.setUserId(wrapper.getUser().getId());
			log.setCreateDate(new Date());
			log.setDescription(o.toString());
			service.insert(log);
		}
	}
}
