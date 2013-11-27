package net.simpleframework.module.log;

import net.simpleframework.ado.bean.AbstractIdBean;
import net.simpleframework.ado.db.DbEntityTable;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class PVLog extends AbstractIdBean {
	private int lyear;
	private int lmonth;
	private int lday;
	private int lhour;

	/* pv统计 */
	private int pv;

	/* uv统计 */
	private int uv;

	/* 独立ip统计 */
	private int ip;

	public int getLyear() {
		return lyear;
	}

	public void setLyear(final int lyear) {
		this.lyear = lyear;
	}

	public int getLmonth() {
		return lmonth;
	}

	public void setLmonth(final int lmonth) {
		this.lmonth = lmonth;
	}

	public int getLday() {
		return lday;
	}

	public void setLday(final int lday) {
		this.lday = lday;
	}

	public int getLhour() {
		return lhour;
	}

	public void setLhour(final int lhour) {
		this.lhour = lhour;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(final int pv) {
		this.pv = pv;
	}

	public int getUv() {
		return uv;
	}

	public void setUv(final int uv) {
		this.uv = uv;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(final int ip) {
		this.ip = ip;
	}

	public static final DbEntityTable TBL = new DbEntityTable(PVLog.class, "sf_log_pv_stat");

	private static final long serialVersionUID = -4043914032466873444L;
}
