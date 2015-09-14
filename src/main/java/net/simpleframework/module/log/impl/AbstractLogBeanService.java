package net.simpleframework.module.log.impl;

import net.simpleframework.ado.ColumnData;
import net.simpleframework.ado.FilterItems;
import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.log.ILogContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractLogBeanService<T> extends AbstractDbBeanService<T> implements
		ILogContextAware {

	public int clog(final Object bean) {
		return count("beanid=?", bean);
	}

	public IDataQuery<T> queryLogs(final Object bean, final ColumnData... oCols) {
		if (bean == null) {
			return DataQueryUtils.nullQuery();
		}
		return queryByParams(FilterItems.of("beanid", bean), oCols);
	}
}
