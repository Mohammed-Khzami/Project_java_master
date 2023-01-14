package org.mql.java.models;

import java.util.List;

public class UMLConstructor {
	 private String name;
	 private String modifier;
	 private List<String> params;
	public UMLConstructor(String name, String modifier, List<String> params) {
		super();
		this.name = name;
		this.modifier = modifier;
		this.params = params;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public List<String> getParams() {
		return params;
	}
	public void setParams(List<String> params) {
		this.params = params;
	}
}
