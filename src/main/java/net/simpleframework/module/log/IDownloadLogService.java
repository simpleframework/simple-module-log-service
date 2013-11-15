package net.simpleframework.module.log;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IDownloadLogService extends IDbBeanService<DownloadLog> {

	/**
	 * 记录下载日志
	 * 
	 * @param beanId
	 * @param size
	 * @param type
	 * @param desc
	 * @param expirationTime
	 */
	void log(Object beanId, long size, String type, String desc, int expirationTime);

	void log(Object beanId, long size, String type, String desc);

	/**
	 * 查询操作bean的下载日志
	 * 
	 * @param bean
	 * @return
	 */
	IDataQuery<DownloadLog> queryLog(Object bean);

	/**
	 * 指定bean的下载数
	 * 
	 * @param bean
	 * @return
	 */
	int countLog(Object bean);
}
