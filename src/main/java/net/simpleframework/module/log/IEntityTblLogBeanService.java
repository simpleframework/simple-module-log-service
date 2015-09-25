package net.simpleframework.module.log;

import net.simpleframework.ado.ColumnData;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.common.TimePeriod;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IEntityTblLogBeanService<T extends AbstractEntityTblLogBean> extends
		IEntityLogBeanService<T> {

	/**
	 * 查询一段时间内某人所做的日志
	 * 
	 * @param userId
	 * @param tblnames
	 * @param period
	 * @param oCols
	 * @return
	 */
	IDataQuery<T> queryLogs(ID userId, String[] tblnames, TimePeriod period, ColumnData... oCols);

	IDataQuery<T> queryLogs(ID userId, String tblname, TimePeriod period, ColumnData... oCols);
}
