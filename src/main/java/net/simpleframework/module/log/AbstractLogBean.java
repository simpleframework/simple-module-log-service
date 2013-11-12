package net.simpleframework.module.log;

import net.simpleframework.ado.bean.AbstractUserAwareBean;
import net.simpleframework.ado.bean.IDescriptionBeanAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
@SuppressWarnings("serial")
public abstract class AbstractLogBean extends AbstractUserAwareBean implements
		IDescriptionBeanAware {

	/* 操作人ip */
	private String ip;

	/* 描述 */
	private String description;

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
