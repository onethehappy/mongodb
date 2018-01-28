package com.cmhy.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cmhy.dao.BusinessApplyDao;
import com.cmhy.model.BusinessApply;

import lombok.Data;
@Data
@Repository
public class BusinessApplyDaoImpl implements BusinessApplyDao {
	@Autowired
	private MongoTemplate mgt;
	public void createOrUpdate(BusinessApply ba) throws IllegalArgumentException, IllegalAccessException {
		Query query = new Query();
		Map<String, Object> map = entityToMap(ba);
		Update update = new Update();
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			update.set(entry.getKey(), entry.getValue());
		}
		mgt.updateFirst(query, update, BusinessApply.class);
	}
	protected Map<String, Object> entityToMap(BusinessApply ba) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = ba.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for(Field field : fields) {
			map.put(field.getName(), field.get(ba));
		}
		return map;
	}
	public BusinessApply findById(Serializable id) {
		return mgt.findById(id, BusinessApply.class);
	}
}
