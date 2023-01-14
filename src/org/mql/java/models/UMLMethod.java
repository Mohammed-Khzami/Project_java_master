package org.mql.java.models;

import java.util.List;

public class UMLMethod {
	private String name;
	private String returnType;
	private String modifier;
	private List<String> params;
	
	public UMLMethod(String name, String returnType, List<String> params, String modifier) {
		this.name = name;
		this.returnType = returnType;
		this.modifier = modifier;
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
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
