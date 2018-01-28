package com.cmhy.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "BusinessApply")
public class BusinessApply {
	private String name;
	private String businessNo;
	private String businessType;
	private Integer businessSum;
	private Address address;
}
