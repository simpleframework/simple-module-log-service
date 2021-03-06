package net.simpleframework.module.log;

import net.simpleframework.ctx.IModuleContext;
import net.simpleframework.module.log.i.IDownloadLogService;
import net.simpleframework.module.log.i.IEntityDeleteLogService;
import net.simpleframework.module.log.i.IEntityInsertLogService;
import net.simpleframework.module.log.i.IEntityUpdateLogService;
import net.simpleframework.module.log.i.ILoginLogService;
import net.simpleframework.module.log.i.IPVLogService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface ILogContext extends IModuleContext {

	static final String MODULE_NAME = "simple-module-log";

	/**
	 * 获取字段更新日志服务
	 * 
	 * @return
	 */
	IEntityUpdateLogService getEntityUpdateLogService();

	/**
	 * 获取记录删除日志服务
	 * 
	 * @return
	 */
	IEntityDeleteLogService getEntityDeleteLogService();

	IEntityInsertLogService getEntityInsertLogService();

	/**
	 * 获取登录log服务
	 * 
	 * @return
	 */
	ILoginLogService getLoginLogService();

	/**
	 * 获取下载的log服务
	 * 
	 * @return
	 */
	IDownloadLogService getDownloadLogService();

	/**
	 * 获取页面统计日志服务
	 * 
	 * @return
	 */
	IPVLogService getPVLogService();
}