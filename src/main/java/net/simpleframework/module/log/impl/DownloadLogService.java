package net.simpleframework.module.log.impl;

import java.util.Calendar;
import java.util.Date;

import net.simpleframework.common.ID;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;
import net.simpleframework.module.log.IDownloadLogService;
import net.simpleframework.module.log.bean.DownloadLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class DownloadLogService extends AbstractEntityLogBeanService<DownloadLog> implements
		IDownloadLogService {

	@Override
	public void log(final Object beanId, final long size, final String type, final String desc) {
		log(beanId, size, type, desc, 1000 * 60 * 30);
	}

	@Override
	public void log(final Object beanId, final long size, final String type, final String desc,
			final int expirationTime) {
		final LoginWrapper wrapper = LoginUser.get();
		final ID loginId = wrapper != null ? wrapper.getUserId() : null;

		DownloadLog dLog = null;
		if (loginId != null && (dLog = getBean("beanId=? and userId=?", beanId, loginId)) != null) {
			dLog.setLastUpdate(new Date());
		}
		if (dLog == null) {
			// 在同一ip上,时间小于指定的时间,认为是1次
			final Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.MILLISECOND, -expirationTime);
			if ((dLog = getBean("beanId=? and ip=? and createDate>?", beanId, wrapper.getIp(),
					cal.getTime())) != null) {
				dLog.setLastUpdate(new Date());
			}
		}

		if (dLog != null) {
			update(new String[] { "lastUpdate" }, dLog);
			return;
		}

		dLog = new DownloadLog();
		dLog.setBeanId(ID.of(beanId));
		dLog.setFilesize(size);
		dLog.setFiletype(type);
		dLog.setCreateDate(new Date());
		dLog.setUserId(loginId);
		if (wrapper != null) {
			dLog.setUserText(wrapper.getUser().getText());
		}
		dLog.setIp(wrapper.getIp());
		dLog.setDescription(desc);
		insert(dLog);
	}
}
