package org.mql.java.models;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;



public class UMLField {
	private String name;
	private Modifiers modifier;
	private Visibility visibility;
	private String type;
	public UMLField(String name, Modifiers modifiers, Visibility visibility, String type) {
		this.name=name;
		this.modifier=modifiers;
		this.visibility=visibility;
		this.type=type;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Modifiers getModifier() {
		return modifier;
	}

	public void setModifier(Modifiers modifier) {
		this.modifier = modifier;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
