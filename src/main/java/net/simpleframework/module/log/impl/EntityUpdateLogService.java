package net.simpleframework.module.log.impl;

import net.simpleframework.ado.ColumnData;
import net.simpleframework.ado.FilterItems;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.common.StringUtils;
import net.simpleframework.common.TimePeriod;
import net.simpleframework.module.log.bean.EntityUpdateLog;
import net.simpleframework.module.log.i.IEntityUpdateLogService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityUpdateLogService extends AbstractEntityTblLogBeanService<EntityUpdateLog>
		implements IEntityUpdateLogService {

	@Override
	public EntityUpdateLog getLastLog(final Object bean, final String vname, final String val) {
		return getBean("beanid=? and valname=? and toval=? order by opid desc", getIdParam(bean),
				vname, val);
	}

	@Override
	public IDataQuery<EntityUpdateLog> queryLogs(final Object bean, final String beanProperty,
			final ColumnData... oCols) {
		if (bean == null) {
			return DataQueryUtils.nullQuery();
		}
		final FilterItems params = FilterItems.of("beanid", getIdParam(bean));
		if (StringUtils.hasText(beanProperty)) {
			params.addEqual("valname", beanProperty);
		}
		return queryByParams(params, oCols);
	}

	@Override
	public IDataQuery<EntityUpdateLog> queryLogs(final ID userId, final String tblname,
			final String beanProperty, final TimePeriod period, final ColumnData... oCols) {
		if (userId == null) {
			return DataQueryUtils.nullQuery();
		}
		final FilterItems params = FilterItems.of("userId", userId);
		if (StringUtils.hasText(tblname)) {
			params.addEqual("tblname", tblname);
		}
		if (StringUtils.hasText(beanProperty)) {
			params.addEqual("valname", beanProperty);
		}
		if (period != null) {
			params.addEqual("createdate", period);
		}
		return queryByParams(params, oCols);
	}
}
