package net.simpleframework.module.log.impl;

import java.util.Date;

import net.simpleframework.common.ID;
import net.simpleframework.ctx.permission.PermissionUser;
import net.simpleframework.module.log.ILoginLogService;
import net.simpleframework.module.log.LoginLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class LoginLogService extends AbstractBaseLogBeanService<LoginLog> implements ILoginLogService {

	@Override
	public LoginLog log(final Object accountId, final String ip, final String desc) {
		final LoginLog log = createBean();

		final PermissionUser user = logContext.getPermission().getUser(accountId);
		final ID userId = user.getId();
		if (userId != null) {
			log.setUserId(userId);
			log.setUserText(user.toString());
		}
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
