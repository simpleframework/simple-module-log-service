package net.simpleframework.module.log;

import java.util.Date;

import net.simpleframework.common.ID;
import net.simpleframework.ctx.AbstractModuleRef;
import net.simpleframework.ctx.ModuleContextFactory;
import net.simpleframework.module.log.bean.LoginLog;
import net.simpleframework.module.log.i.IDownloadLogService;
import net.simpleframework.module.log.i.ILoginLogService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class LogRef extends AbstractModuleRef {

	@Override
	public ILogContext getModuleContext() {
		return ModuleContextFactory.get(ILogContext.class);
	}

	public void logDownload(final Object beanId, final long length, final String filetype,
			final String topic) {
		getDownloadLogService().log(beanId, length, filetype, topic);
	}

	public ID logLogin(final Object accountId, final String ip, final String desc) {
		return getLoginLogService().log(accountId, ip, desc).getId();
	}

	public void logLogout(final Object logId) {
		final ILoginLogService service = getLoginLogService();
		final LoginLog log = service.getBean(logId);
		if (log != null) {
			log.setLogoutDate(new Date());
			service.update(new String[] { "logoutDate" }, log);
		}
	}

	public ILoginLogService getLoginLogService() {
		return getModuleContext().getLoginLogService();
	}

	public IDownloadLogService getDownloadLogService() {
		return getModuleContext().getDownloadLogService();
	}
}