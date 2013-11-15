package net.simpleframework.module.log;

import net.simpleframework.ado.db.event.DbEntityAdapter;
import net.simpleframework.ctx.InjectCtx;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractEntityLogAdapter extends DbEntityAdapter {

	@InjectCtx
	protected ILogContext context;
}
