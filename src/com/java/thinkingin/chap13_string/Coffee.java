package com.java.thinkingin.chap13_string;

public class Coffee {
	private String id;
	private String name;

	public Coffee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Coffee");
		result.append(id);
		result.append(name);
		return result.toString(); 
	}
}
