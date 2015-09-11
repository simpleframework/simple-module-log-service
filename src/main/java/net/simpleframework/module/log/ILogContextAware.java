package net.simpleframework.module.log;

import net.simpleframework.ctx.IModuleContextAware;
import net.simpleframework.ctx.ModuleContextFactory;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface ILogContextAware extends IModuleContextAware {

	static ILogContext logContext = ModuleContextFactory.get(ILogContext.class);

	/* 实体bean日志服务 */
	static final IEntityUpdateLogService _logUpdateService = logContext.getEntityUpdateLogService();
	static final IEntityInsertLogService _logInsertService = logContext.getEntityInsertLogService();
	static final IEntityDeleteLogService _logDeleteService = logContext.getEntityDeleteLogService();

	/* 登录日志服务 */
	static final ILoginLogService _logLoginService = logContext.getLoginLogService();

	/* 下载日志服务 */
	static final IDownloadLogService _logDownloadService = logContext.getDownloadLogService();

	/* pv日志服务 */
	static final IPVLogService _logPVService = logContext.getPVLogService();
}
