package org.mql.java.models;

import java.util.List;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;

public class UMLConstructor {
	
	 private String name;
	 private Visibility visibility;
	 private Modifiers modifier;
	 private List<String> parameters;
	
	 
	 
	 public UMLConstructor(String name, Visibility visibility, Modifiers modifier, List<String> parameters) {
			super();
			this.name = name;
			this.visibility = visibility;
			this.modifier = modifier;
			this.parameters = parameters;
		}
	public UMLConstructor() {
		// TODO Auto-generated constructor stub
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
	public Modifiers getModifier() {
		return modifier;
	}
	
	public void setModifier(Modifiers modifier) {
		this.modifier = modifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 @Override
		public String toString() {
			return "UMLConstructor [name=" + name + ", visibility=" + visibility + ", modifier=" + modifier
					+ ", parameters=" + parameters + "]";
		}
	
	

}
