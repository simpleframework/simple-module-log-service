package net.simpleframework.module.log.impl;

import net.simpleframework.ado.query.DataQueryUtils;
import net.simpleframework.ado.query.IDataQuery;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractLogBeanService<T> extends AbstractLogService<T> {
	public int countLog(final Object bean) {
		return count("beanId=?", bean);
	}

	public IDataQuery<T> queryLog(final Object bean) {
		if (bean == null) {
			return DataQueryUtils.nullQuery();
		}
		return query("beanId=? order by createDate desc", bean);
	}
}
