package com.cmhy.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmhy.dao.impl.BusinessApplyDaoImpl;
import com.cmhy.model.BusinessApply;
import com.cmhy.service.BusinessApplyService;

import lombok.Data;
@Data
@Service
public class BusinessApplyServiceImpl implements BusinessApplyService {
	@Autowired
	private BusinessApplyDaoImpl businessApplyDao;
	public void createOrUpdate(BusinessApply ba) throws IllegalArgumentException, IllegalAccessException {
		businessApplyDao.createOrUpdate(ba);
	}
	public BusinessApply findById(Serializable id) {
		return businessApplyDao.findById(id);
	}
}
