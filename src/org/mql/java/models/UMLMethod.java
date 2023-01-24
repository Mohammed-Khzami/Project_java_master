package org.mql.java.models;

import java.util.List;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;



public class UMLMethod {
	

	private String name;
	private String returnType;
	private Visibility visibility;
	private Modifiers modifier;
	private List<String> parameters;
	public UMLMethod(String name, String returnType, Visibility visibility, Modifiers modifier,
			List<String> parameters) {
		super();
		this.name = name;
		this.returnType = returnType;
		this.visibility = visibility;
		this.modifier = modifier;
		this.parameters = parameters;
	}



	public Visibility getVisibility() {
		return visibility;
	}



	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}



	public List<String> getParameters() {
		return parameters;
	}



	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}



	public UMLMethod() {
		// TODO Auto-generated constructor stub
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

	public Modifiers getModifier() {
		return modifier;
	}

	
	public void setModifier(Modifiers modifier) {
		this.modifier = modifier;
	}

	public List<String> getParams() {
		return parameters;
	}

	public void setParams(List<String> params) {
		this.parameters = params;
	}

	
	
	
}
