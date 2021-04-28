package com.pb.demo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="producto")
public class Product {
	
	@Id
	String id;
	@Field("name")
	String namep;
	@Field("price")
	float  priceF;
	
	public Product(String id, String namep, float priceF) {
		this.id = id;
		this.namep = namep;
		this.priceF = priceF;
	}
	
	public Product() {
	}
	
	
	public String getId() {
		return id;
	}
	public String getNameP() {
		return namep;
	}
	public float getPriceF() {
		return priceF;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @param name the name to set
	 */
	public void setNameP(String namep) {
		this.namep = namep;
	}


	/**
	 * @param price the price to set
	 */
	public void setPriceF(float priceF) {
		this.priceF = priceF;
	}
	
	

}
