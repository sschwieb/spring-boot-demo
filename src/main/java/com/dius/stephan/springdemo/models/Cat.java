package com.dius.stephan.springdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	private int price;
	
	private String imageUrl;
	
	private String name;

	public Cat(int price, String imageUrl, String name) {
		this.price = price;
		this.imageUrl = imageUrl;
		this.name = name;
	}
	
	public Cat() {}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
