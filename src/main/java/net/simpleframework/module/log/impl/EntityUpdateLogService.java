package net.simpleframework.module.log.impl;

import net.simpleframework.module.log.EntityUpdateLog;
import net.simpleframework.module.log.IEntityUpdateLogService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityUpdateLogService extends AbstractLogBeanService<EntityUpdateLog> implements
		IEntityUpdateLogService {

	@Override
	public EntityUpdateLog getLastLog(final Object bean, final String vname, final String val) {
		return query("beanid=? and valname=? and toval=? order by createdate desc", getIdParam(bean),
				vname, val).next();
	}
}
