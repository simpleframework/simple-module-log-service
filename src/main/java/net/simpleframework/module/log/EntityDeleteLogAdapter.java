package net.simpleframework.module.log;

import java.util.Date;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.StringUtils;
import net.simpleframework.common.web.html.HtmlUtils;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityDeleteLogAdapter extends AbstractEntityLogAdapter<Object> {

	@Override
	public void onBeforeDelete(final IDbEntityManager<Object> manager, final IParamsValue paramsValue)
			throws Exception {
		super.onBeforeDelete(manager, paramsValue);
		final LoginWrapper wrapper = LoginUser.get();
		if (wrapper == null || wrapper.getUserId() == null) {
			return;
		}

		final IDataQuery<?> dq = manager.queryBeans(paramsValue);
		if (dq.getCount() == 0) {
			return;
		}

		final Date now = new Date();
		Object o;
		while ((o = dq.next()) != null) {
			final EntityDeleteLog log = _logDeleteService.createBean();
			initLog(log, wrapper);
			log.setTblName(manager.getEntityTable().getName());
			log.setBeanId(getId(o));
			log.setCreateDate(now);
			log.setDescription(StringUtils.substring(HtmlUtils.htmlToText(o.toString()), 128, true));
			_logDeleteService.insert(log);
		}
	}
}
