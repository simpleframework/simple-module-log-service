package net.simpleframework.module.log;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IDownloadLogService extends IEntityLogBeanService<DownloadLog> {

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
}
