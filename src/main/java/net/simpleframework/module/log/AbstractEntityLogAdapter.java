package net.simpleframework.module.log;

import java.util.Date;

import net.simpleframework.ado.bean.IIdBeanAware;
import net.simpleframework.ado.db.event.DbEntityAdapter;
import net.simpleframework.common.BeanUtils;
import net.simpleframework.common.Convert;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.InjectCtx;
import net.simpleframework.ctx.permission.LoginUser.LoginWrapper;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractEntityLogAdapter<T> extends DbEntityAdapter<T> {

	@InjectCtx
	protected ILogContext context;

	protected ID getId(final Object bean) {
		if (bean instanceof IIdBeanAware) {
			return ((IIdBeanAware) bean).getId();
		} else {
			final Object id = BeanUtils.getProperty(bean, "id");
			return id != null ? ID.of(id) : null;
		}
	}

	protected String covertToString(final Object val) {
		if (val instanceof Enum) {
			return ((Enum<?>) val).name();
		} else if (val instanceof Date) {
			return Convert.toDateString((Date) val);
		}
		return Convert.toString(val);
	}

	protected void initLog(final AbstractLogBean log, final LoginWrapper wrapper) {
		log.setUserId(wrapper.getUserId());
		log.setUserText(wrapper.getUser().getText());
		log.setIp(wrapper.getIp());
	}
}
