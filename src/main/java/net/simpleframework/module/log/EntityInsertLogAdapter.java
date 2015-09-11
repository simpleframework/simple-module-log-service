package net.simpleframework.module.log;

import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ctx.permission.LoginUser;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityInsertLogAdapter extends AbstractEntityLogAdapter<Object> {

	@Override
	public void onAfterInsert(final IDbEntityManager<Object> manager, final Object[] beans)
			throws Exception {
		super.onAfterInsert(manager, beans);
		final LoginWrapper wrapper = LoginUser.get();
		if (wrapper == null || wrapper.getUserId() == null) {
			return;
		}
	}
}
