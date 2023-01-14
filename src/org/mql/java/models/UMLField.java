package org.mql.java.models;

public class UMLField {
	private String name;
	private String modifier;
	private String type;
	
	public UMLField(String modifier, String type, String name) {
		this.modifier = modifier;
		this.type =type;
		this.name = name;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
