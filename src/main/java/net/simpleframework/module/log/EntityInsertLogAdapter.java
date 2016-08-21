package net.simpleframework.module.log;

import java.util.Date;

import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;
import net.simpleframework.module.common.log.LdescVal;
import net.simpleframework.module.common.log.LogEntity;
import net.simpleframework.module.log.bean.EntityInsertLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityInsertLogAdapter extends AbstractEntityLogAdapter<Object> {

	@Override
	public void onAfterInsert(final IDbEntityManager<Object> manager, final Object[] beans)
			throws Exception {
		super.onAfterInsert(manager, beans);
		final LoginWrapper wrapper = LoginUser.get();
		if (wrapper == null || wrapper.getUserId() == null) {
			return;
		}

		final Date now = new Date();
		for (final Object o : beans) {
			if (LogEntity.isDisable(o)) {
				LogEntity.enable(o);
				continue;
			}

			final EntityInsertLog log = _logInsertService.createBean();
			initLog(log, wrapper);
			log.setTblName(manager.getEntityTable().getName());
			log.setBeanId(getId(o));
			log.setCreateDate(now);
			log.setDescription(LdescVal.get(o));
			_logInsertService.insert(log);
		}
	}
}
