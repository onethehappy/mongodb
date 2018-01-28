package com.cmhy.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

public abstract class GetFieldInfo<T> {

	protected abstract Class<T> getEntityClass();

	public Map<String, Object> parseEntity(T t) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * 解析ID
		 */
		String idName = "";
		Field[] declaredFields = getEntityClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(Id.class)) {
				field.setAccessible(true);
				map.put("{" + field.getName() + "}", field.get(t));
				idName = field.getName();
				break;
			}
		}
		/*
		 * 解析其他属性
		 */
		Method[] methods = getEntityClass().getDeclaredMethods();
		if ( methods.length > 0) {
			for (Method method : methods) {
				if (method.getName().startsWith("get") && method.getModifiers() == Modifier.PUBLIC) {
					String fieldName = parse2FieldName(method.getName());
					if (!fieldName.equals(idName)) {
						map.put(fieldName, method.invoke(t));
					}
				}
			}
		}
		return map;
	}

	public String parse2FieldName(String methodName) {
		String name = methodName.replace("get", "");
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		return name;
	}
	public Map<String, Object> getField(T t){
		Field fields[]=getEntityClass().getDeclaredFields();
		String[] keys=new String[fields.length];
		Object[] values=new Object[fields.length];
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field.setAccessible(fields, true);
			for (int i = 0; i < keys.length; i++) {
				keys[i] = fields[i].getName();
				values[i] = fields[i].get(t);
				map.put(keys[i], values[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> getFieldNameAndValue(T record){

		Field[] fields=getEntityClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field.setAccessible(fields, true);
			for (Field field:fields) {
				map.put(field.getName(), field.get(record));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> getFieldNameAndValue1(T record){

		Field[] fields=getEntityClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field.setAccessible(fields, true);
			for (Field field:fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), getEntityClass());
				Method get = pd.getReadMethod();
				map.put(field.getName(), get.invoke(record));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
