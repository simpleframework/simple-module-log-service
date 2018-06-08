package net.simpleframework.module.log.impl;

import net.simpleframework.module.log.bean.AbstractBaseLogBean;
import net.simpleframework.module.log.i.IBaseLogBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractBaseLogBeanService<T extends AbstractBaseLogBean>
		extends AbstractLogBeanService<T> implements IBaseLogBeanService<T> {
}