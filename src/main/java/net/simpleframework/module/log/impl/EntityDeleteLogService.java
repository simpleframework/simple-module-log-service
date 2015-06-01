package net.simpleframework.module.log.impl;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.log.EntityDeleteLog;
import net.simpleframework.module.log.IEntityDeleteLogService;
import net.simpleframework.module.log.ILogContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityDeleteLogService extends AbstractDbBeanService<EntityDeleteLog> implements
		IEntityDeleteLogService, ILogContextAware {

	@Override
	public void onInit() throws Exception {
		super.onInit();

		addListener(new DbEntityAdapterEx() {
			@Override
			public void onBeforeDelete(final IDbEntityManager<?> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onBeforeDelete(manager, paramsValue);
				final EntityUpdateLogService uService = (EntityUpdateLogService) logContext
						.getEntityUpdateLogService();
				for (final EntityDeleteLog log : coll(paramsValue)) {
					final ID beanId = log.getBeanId();
					if (beanId != null) {
						// 删除修改日志
						uService.deleteWith("beanId=?", beanId);
					}
				}
			}
		});
	}
}
