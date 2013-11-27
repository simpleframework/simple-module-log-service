package net.simpleframework.module.log;

import java.util.Map;

import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IPVLogService extends IDbBeanService<PVLog> {

	/**
	 * 按日期获取
	 * 
	 * @param lyear
	 * @param lmonth
	 * @param lday
	 * @param lhour
	 * @return
	 */
	PVLog getPVLog(int lyear, int lmonth, int lday, int lhour);

	Map<Integer, PVLog> getHourStat(int lyear, int lmonth, int lday);
}
