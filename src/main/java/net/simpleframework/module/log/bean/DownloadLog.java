package net.simpleframework.module.log.bean;

import java.util.Date;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class DownloadLog extends AbstractEntityLogBean {

	/* 文件大小 */
	private long filesize;

	/* 类型 */
	private String filetype;

	/* 最后一次下载日期 */
	private Date lastUpdate;

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
		if (lastUpdate == null) {
			lastUpdate = new Date();
		}
		return lastUpdate;
	}

	public void setLastUpdate(final Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	private static final long serialVersionUID = -6142167948018751623L;
}
