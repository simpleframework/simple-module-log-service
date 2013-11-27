package net.simpleframework.module.log.impl;

import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.log.ILogContextAware;
import net.simpleframework.module.log.IPVLogService;
import net.simpleframework.module.log.PVLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class PVLogService extends AbstractDbBeanService<PVLog> implements IPVLogService,
		ILogContextAware {

	@Override
	public PVLog getPVLog(final int lyear, final int lmonth, final int lday, final int lhour) {
		PVLog log = getBean("lyear=? and lmonth=? and lday=? and lhour=?", lyear, lmonth, lday, lhour);
		if (log == null) {
			log = createBean();
			log.setLyear(lyear);
			log.setLmonth(lmonth);
			log.setLday(lday);
			log.setLhour(lhour);
			insert(log);
		}
		return log;
	}
}
