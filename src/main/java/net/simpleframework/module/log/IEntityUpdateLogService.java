package net.simpleframework.module.log;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IEntityUpdateLogService extends IDbBeanService<EntityUpdateLog> {

	/**
	 * 
	 * @param bean
	 * @return
	 */
	IDataQuery<EntityUpdateLog> queryLog(Object bean);
}
