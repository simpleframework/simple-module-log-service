package net.simpleframework.module.log;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IEntityUpdateLogService extends ILogBeanService<EntityUpdateLog> {

	/**
	 * 获取更新日志对象
	 * 
	 * @param bean
	 * @param vname
	 * @param val
	 * @return
	 */
	EntityUpdateLog getLastLog(Object bean, String vname, String val);
}
