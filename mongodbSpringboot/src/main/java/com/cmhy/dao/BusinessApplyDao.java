package com.cmhy.dao;

import java.io.Serializable;

import com.cmhy.model.BusinessApply;
public interface BusinessApplyDao {
	void createOrUpdate(BusinessApply ba) throws IllegalArgumentException, IllegalAccessException ;
	BusinessApply findById(Serializable id) ;
}
