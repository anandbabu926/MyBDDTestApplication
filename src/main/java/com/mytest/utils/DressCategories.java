package com.mytest.utils;


public enum DressCategories {
	
	WOMEN("WOMEN"),
	DRESSES("DRESSES"),
	TSHIRTS("T-shirts"),
	TOPS("TOPS"),
	BLOUSES("Blouses"),
	CASUAL_DRESSES("Casual Dresses"),
	EVENING_DRESSES("Evening Dresses"),
	SUMMER_DRESSES("Summer Dresses");
	
	private String value;
	
	private DressCategories(String value) {
		this.value = value;
	}
	
	private String getValue() {
		return value;
	}

}
