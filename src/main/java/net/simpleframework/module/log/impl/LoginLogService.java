package net.simpleframework.module.log.impl;

import java.util.Date;

import net.simpleframework.common.ID;
import net.simpleframework.module.log.ILoginLogService;
import net.simpleframework.module.log.LoginLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class LoginLogService extends AbstractLogService<LoginLog> implements ILoginLogService {

	@Override
	public LoginLog log(final Object accountId, final String ip, final String desc) {
		final LoginLog log = createBean();
		log.setUserId(ID.of(accountId));
		log.setCreateDate(new Date());
		log.setIp(ip);
		log.setDescription(desc);
		insert(log);
		return log;
	}

	@Override
	public LoginLog log(final Object accountId, final String ip) {
		return log(accountId, ip, null);
	}
}
