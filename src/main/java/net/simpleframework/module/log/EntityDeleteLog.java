package net.simpleframework.module.log;

import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityDeleteLog extends AbstractLogBean {
	/* 操作的beanid */
	private ID beanId;

	/* 表名 */
	private String tblName;

	public ID getBeanId() {
		return beanId;
	}

	public void setBeanId(final ID beanId) {
		this.beanId = beanId;
	}

	public String getTblName() {
		return tblName != null ? tblName.toUpperCase() : "";
	}

	public void setTblName(final String tblName) {
		this.tblName = tblName;
	}

	public static final DbEntityTable TBL = new DbEntityTable(EntityDeleteLog.class,
			"sf_log_entity_delete");

	private static final long serialVersionUID = -709146688435761514L;
}
