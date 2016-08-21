package net.simpleframework.module.log.bean;

import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@SuppressWarnings("serial")
public abstract class AbstractEntityLogBean extends AbstractBaseLogBean {
	/* 操作的beanid */
	private ID beanId;

	public ID getBeanId() {
		return beanId;
	}

	public void setBeanId(final ID beanId) {
		this.beanId = beanId;
	}
}
