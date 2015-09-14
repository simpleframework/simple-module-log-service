package net.simpleframework.module.log.impl;

import net.simpleframework.ado.ColumnData;
import net.simpleframework.ado.FilterItems;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.common.StringUtils;
import net.simpleframework.common.TimePeriod;
import net.simpleframework.module.log.AbstractEntityTblLogBean;
import net.simpleframework.module.log.IEntityTblLogBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractEntityTblLogBeanService<T extends AbstractEntityTblLogBean> extends
		AbstractEntityLogBeanService<T> implements IEntityTblLogBeanService<T> {

	@Override
	public IDataQuery<T> queryLogs(final ID userId, final String tblname, final TimePeriod period,
			final ColumnData... oCols) {
		if (userId == null) {
			return DataQueryUtils.nullQuery();
		}
		final FilterItems params = FilterItems.of("userId", userId);
		if (StringUtils.hasText(tblname)) {
			params.addEqual("tblname", tblname);
		}
		if (period != null) {
			params.addEqual("createdate", period);
		}
		return queryByParams(params, oCols);
	}
}
