package net.simpleframework.module.log.impl;

import java.io.Serializable;

import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.log.ILogContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractLogBeanService<T extends Serializable> extends
		AbstractDbBeanService<T> implements ILogContextAware {
}
