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
public interface ILogBeanService<T> extends IDbBeanService<T> {

	/**
	 * 指定bean的日志数
	 * 
	 * @param bean
	 * @return
	 */
	int clog(Object bean);

	/**
	 * 查询操作bean的下载日志
	 * 
	 * @param bean
	 * @param oCols
	 * @return
	 */
	IDataQuery<T> queryLogs(Object bean, ColumnData... oCols);
}
