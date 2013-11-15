package net.simpleframework.module.log.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.Module;
import net.simpleframework.ctx.permission.IPermissionConst;
import net.simpleframework.ctx.service.ado.db.AbstractDbModuleContext;
import net.simpleframework.module.log.DownloadLog;
import net.simpleframework.module.log.EntityDeleteLog;
import net.simpleframework.module.log.EntityUpdateLog;
import net.simpleframework.module.log.IDownloadLogService;
import net.simpleframework.module.log.IEntityDeleteLogService;
import net.simpleframework.module.log.IEntityUpdateLogService;
import net.simpleframework.module.log.ILogContext;
import net.simpleframework.module.log.ILoginLogService;
import net.simpleframework.module.log.LoginLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class LogContext extends AbstractDbModuleContext implements ILogContext {

	@Override
	protected DbEntityTable[] getEntityTables() {
		return new DbEntityTable[] { EntityUpdateLog.TBL, EntityDeleteLog.TBL, LoginLog.TBL,
				DownloadLog.TBL };
	}

	@Override
	public String getManagerRole() {
		return IPermissionConst.ROLE_MANAGER;
	}

	@Override
	public IEntityUpdateLogService getEntityUpdateLogService() {
		return singleton(EntityUpdateLogService.class);
	}

	@Override
	public IEntityDeleteLogService getEntityDeleteLogService() {
		return singleton(EntityDeleteLogService.class);
	}

	@Override
	public ILoginLogService getLoginLogService() {
		return singleton(LoginLogService.class);
	}

	@Override
	public IDownloadLogService getDownloadLogService() {
		return singleton(DownloadLogService.class);
	}

	@Override
	protected Module createModule() {
		return new Module().setName(MODULE_NAME).setText($m("LogContext.0")).setOrder(1);
	}
}
