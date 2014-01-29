package net.simpleframework.module.log;

import java.util.Date;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class LoginLog extends AbstractLogBean {

	private Date logoutDate;

	// private String os;
	//
	// private String browser;

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(final Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	// public String getOs() {
	// return os;
	// }
	//
	// public void setOs(final String os) {
	// this.os = os;
	// }
	//
	// public String getBrowser() {
	// return browser;
	// }
	//
	// public void setBrowser(final String browser) {
	// this.browser = browser;
	// }

	private static final long serialVersionUID = 6273920583368192366L;
}
