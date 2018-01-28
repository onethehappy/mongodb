package com.cmhy.service;

import java.io.Serializable;

import com.cmhy.model.BusinessApply;
public interface BusinessApplyService {
	void createOrUpdate(BusinessApply ba) throws IllegalArgumentException, IllegalAccessException ;
	BusinessApply findById(Serializable id) ;
}
