package net.simpleframework.module.log.bean;

import net.simpleframework.ado.bean.AbstractUserAwareBean;
import net.simpleframework.ado.bean.IDescriptionBeanAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@SuppressWarnings("serial")
public abstract class AbstractBaseLogBean extends AbstractUserAwareBean implements
		IDescriptionBeanAware {
	/* 操作人显示名称 */
	private String userText;

	/* 操作人ip */
	private String ip;

	/* 描述 */
	private String description;

	public String getUserText() {
		return userText;
	}

	public void setUserText(final String userText) {
		this.userText = userText;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(final String ip) {
		this.ip = ip;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		this.description = description;
	}
}
