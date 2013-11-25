package net.simpleframework.module.log.impl;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.log.ILogContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractLogService<T> extends AbstractDbBeanService<T> implements
		ILogContextAware {
	@Override
	public IDataQuery<T> queryAll() {
		return query("1=1 order by createDate desc");
	}
}
