package net.simpleframework.module.log.impl;

import static net.simpleframework.common.I18n.$m;

import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.AbstractADOModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.module.log.ILogContext;
import net.simpleframework.module.log.bean.DownloadLog;
import net.simpleframework.module.log.bean.EntityDeleteLog;
import net.simpleframework.module.log.bean.EntityInsertLog;
import net.simpleframework.module.log.bean.EntityUpdateLog;
import net.simpleframework.module.log.bean.LoginLog;
import net.simpleframework.module.log.bean.PVLog;
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
public class LogContext extends AbstractADOModuleContext implements ILogContext {

	@Override
	protected DbEntityTable[] createEntityTables() {
		return new DbEntityTable[] { new DbEntityTable(EntityUpdateLog.class, "sf_log_entity_update"),
				new DbEntityTable(EntityInsertLog.class, "sf_log_entity_insert"),
				new DbEntityTable(EntityDeleteLog.class, "sf_log_entity_delete"),

				new DbEntityTable(LoginLog.class, "sf_log_login"),

				new DbEntityTable(DownloadLog.class, "sf_log_download"),

				new DbEntityTable(PVLog.class, "sf_log_pv_stat") };
	}

	@Override
	public IEntityUpdateLogService getEntityUpdateLogService() {
		return singleton(EntityUpdateLogService.class);
	}

	@Override
	public IEntityInsertLogService getEntityInsertLogService() {
		return singleton(EntityInsertLogService.class);
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
	public IPVLogService getPVLogService() {
		return singleton(PVLogService.class);
	}

	@Override
	protected Module createModule() {
		return super.createModule().setName(MODULE_NAME).setText($m("LogContext.0")).setOrder(1);
	}
}
