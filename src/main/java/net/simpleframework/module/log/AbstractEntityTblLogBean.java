package net.simpleframework.module.log;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@SuppressWarnings("serial")
public abstract class AbstractEntityTblLogBean extends AbstractEntityLogBean {
	/* 表名 */
	private String tblName;

	public String getTblName() {
		return tblName;
	}

	public void setTblName(final String tblName) {
		this.tblName = tblName;
	}
}
