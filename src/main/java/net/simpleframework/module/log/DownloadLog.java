package net.simpleframework.module.log;

import java.util.Date;

import net.simpleframework.common.ID;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class DownloadLog extends AbstractLogBean {
	/* 操作的beanid */
	private ID beanId;

	/* 文件大小 */
	private long filesize;

	/* 类型 */
	private String filetype;

	/* 最后一次下载日期 */
	private Date lastUpdate;

	public ID getBeanId() {
		return beanId;
	}

	public void setBeanId(final ID beanId) {
		this.beanId = beanId;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(final long filesize) {
		this.filesize = filesize;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(final String filetype) {
		this.filetype = filetype;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(final Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	private static final long serialVersionUID = -6142167948018751623L;
}
