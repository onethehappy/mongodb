package com.cmhy.utils;

import com.cmhy.model.BusinessApply;

public class GetFieldInfoImpl extends GetFieldInfo<BusinessApply> {

	@Override
	protected Class<BusinessApply> getEntityClass() {
		return BusinessApply.class;
	}

}
