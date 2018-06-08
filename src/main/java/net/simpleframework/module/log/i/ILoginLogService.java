package net.simpleframework.module.log.i;

import net.simpleframework.module.log.bean.LoginLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface ILoginLogService extends IBaseLogBeanService<LoginLog> {

	/**
	 * 登录日志
	 * 
	 * @param accountId
	 * @param ip
	 * @param desc
	 * @return
	 */
	LoginLog log(Object accountId, String ip, String desc);

	LoginLog log(Object accountId, String ip);
}
