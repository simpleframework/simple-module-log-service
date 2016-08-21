package net.simpleframework.module.log;

import net.simpleframework.ctx.service.ado.db.IDbBeanService;
import net.simpleframework.module.log.bean.AbstractBaseLogBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface IBaseLogBeanService<T extends AbstractBaseLogBean> extends IDbBeanService<T> {
}
