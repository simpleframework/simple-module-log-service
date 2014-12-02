package net.simpleframework.module.log;

import net.simpleframework.ado.ColumnData;
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
	 * @param bean
	 * @param oCols
	 * @return
	 */
	IDataQuery<EntityUpdateLog> queryLog(Object bean, ColumnData... oCols);

	/**
	 * 获取更新日志对象
	 * 
	 * @param bean
	 * @param vname
	 * @param val
	 * @return
	 */
	EntityUpdateLog getLog(Object bean, String vname, String val);
}
