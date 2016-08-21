package net.simpleframework.module.log.impl;

import java.util.HashMap;
import java.util.Map;

import net.simpleframework.ado.db.common.SQLValue;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.module.log.IPVLogService;
import net.simpleframework.module.log.PVLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class PVLogService extends AbstractLogBeanService<PVLog> implements IPVLogService {

	@Override
	public PVLog getPVLog(final int lyear, final int lmonth, final int lday, final int lhour) {
		PVLog log = getBean("lyear=? and lmonth=? and lday=? and lhour=?", lyear, lmonth, lday,
				lhour);
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

	@Override
	public Map<Integer, PVLog> getHourStat(final int lyear, final int lmonth, final int lday) {
		final Map<Integer, PVLog> r = new HashMap<Integer, PVLog>();
		final IDataQuery<PVLog> dq = query("lyear=? and lmonth=? and lday=?", lyear, lmonth, lday);
		PVLog log;
		while ((log = dq.next()) != null) {
			r.put(log.getLhour(), log);
		}
		return r;
	}

	private final static String STAT_COLUMS = "sum(pv) as pv, sum(ip) as ip, sum(uv) as uv, "
			+ "avg(averageTime) as averageTime, min(minTime) as minTime, max(maxTime) as maxTime";

	@Override
	public Map<Integer, PVLog> getDayStat(final int lyear, final int lmonth) {
		final Map<Integer, PVLog> r = new HashMap<Integer, PVLog>();
		final StringBuilder sql = new StringBuilder();
		sql.append("select lday, ").append(STAT_COLUMS).append(" from ")
				.append(getTablename(PVLog.class));
		sql.append(" where lyear=? and lmonth=? group by lday");
		final IDataQuery<PVLog> dq = query(new SQLValue(sql, lyear, lmonth));
		PVLog log;
		while ((log = dq.next()) != null) {
			r.put(log.getLday(), log);
		}
		return r;
	}

	@Override
	public Map<Integer, PVLog> getMonthStat(final int lyear) {
		final Map<Integer, PVLog> r = new HashMap<Integer, PVLog>();
		final StringBuilder sql = new StringBuilder();
		sql.append("select lmonth, ").append(STAT_COLUMS).append(" from ")
				.append(getTablename(PVLog.class));
		sql.append(" where lyear=? group by lmonth");
		final IDataQuery<PVLog> dq = query(new SQLValue(sql, lyear));
		PVLog log;
		while ((log = dq.next()) != null) {
			r.put(log.getLmonth(), log);
		}
		return r;
	}
}
