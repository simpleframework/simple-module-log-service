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
public interface IEntityUpdateLogService extends IEntityTblLogBeanService<EntityUpdateLog> {

	/**
	 * 获取更新日志对象
	 * 
	 * @param bean
	 * @param vname
	 * @param val
	 * @return
	 */
	EntityUpdateLog getLastLog(Object bean, String vname, String val);

	IDataQuery<EntityUpdateLog> queryLogs(Object bean, String beanProperty, ColumnData... oCols);

	IDataQuery<EntityUpdateLog> queryLogs(ID userId, String tblname, String beanProperty,
			TimePeriod period, ColumnData... oCols);
}
