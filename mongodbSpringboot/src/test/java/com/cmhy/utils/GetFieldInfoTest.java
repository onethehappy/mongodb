package com.cmhy.utils;

import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

import com.cmhy.model.Address;
import com.cmhy.model.BusinessApply;

public class GetFieldInfoTest {
	private String _id;
	@Test
	public void testGetEntityClass() throws Exception {
		GetFieldInfoImpl getFieldInfoImpl = new GetFieldInfoImpl();
		BusinessApply ba = new BusinessApply();
		Address address =  new Address();
		ba.setBusinessNo("123");
		address.setCity("上海");
		ba.setAddress(address);
//		Map<String, Object> map = getFieldInfoImpl.parseEntity(ba);
		Map<String, Object> map = getFieldInfoImpl.getFieldNameAndValue1(ba);
		System.out.println(map);
	}
}
