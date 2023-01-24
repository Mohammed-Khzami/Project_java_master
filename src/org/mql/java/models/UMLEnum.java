package org.mql.java.models;

import java.util.List;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;



public class UMLEnum {
	
	private String name;  
	private Visibility visibility;
	private Modifiers modificator;
	
	public UMLEnum(String name, Visibility visibility, Modifiers modificator) {
		super();
		this.name = name;
		this.visibility = visibility;
		this.modificator = modificator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Visibility getVisibility() {
		return visibility;
	}
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	public Modifiers getModificator() {
		return modificator;
	}
	public void setModificator(Modifiers modificator) {
		this.modificator = modificator;
	}
	
	
	
}
