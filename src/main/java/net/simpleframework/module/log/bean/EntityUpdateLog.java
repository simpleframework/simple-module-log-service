package net.simpleframework.module.log.bean;

import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityUpdateLog extends AbstractEntityTblLogBean {
	/* 操作的beanid */
	private ID beanId;

	/* 操作id */
	private int opId;

	/* 操作字段的显示名称 */
	private String valName;

	/* 操作字段更改前值 */
	private String fromVal;

	/* 操作字段更改后值 */
	private String toVal;

	public int getOpId() {
		return opId;
	}

	public void setOpId(final int opId) {
		this.opId = opId;
	}

	@Override
	public ID getBeanId() {
		return beanId;
	}

	@Override
	public void setBeanId(final ID beanId) {
		this.beanId = beanId;
	}

	public String getValName() {
		return valName;
	}

	public void setValName(final String valName) {
		this.valName = valName;
	}

	public String getFromVal() {
		return fromVal;
	}

	public void setFromVal(final String fromVal) {
		this.fromVal = fromVal;
	}

	public String getToVal() {
		return toVal;
	}

	public void setToVal(final String toVal) {
		this.toVal = toVal;
	}

	private static final long serialVersionUID = 4230418335331639147L;
}
