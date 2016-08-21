package net.simpleframework.module.log.impl;

import net.simpleframework.module.log.IEntityDeleteLogService;
import net.simpleframework.module.log.bean.EntityDeleteLog;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class EntityDeleteLogService extends AbstractEntityTblLogBeanService<EntityDeleteLog>
		implements IEntityDeleteLogService {

	@Override
	public void onInit() throws Exception {
		super.onInit();
	}
}
