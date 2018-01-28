package com.cmhy.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import com.cmhy.MongodbSpringbootApplication;
import com.cmhy.model.BusinessApply;
import com.cmhy.service.impl.BusinessApplyServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongodbSpringbootApplication.class)
@EnableCaching
public class BusinessApplyServiceTest {
		@Autowired
		private BusinessApplyServiceImpl baService;
//		@Autowired
//		private MongoTemplate mgt;
		@Test
		public void testFind() {
			BusinessApply ba = new BusinessApply();
			ObjectId _id = new ObjectId("5a6464e48f5f260454dca84e");
			System.out.println("***********************");
			System.out.println(baService.findById(_id));
			List<BusinessApply> list = baService.getBusinessApplyDao().getMgt().findAll(BusinessApply.class);
			System.out.println("***********************");
			System.out.println(list.toString());
		}

}
