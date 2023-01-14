package org.mql.java.models;

import java.util.List;



public class UMLPackage {
	private String name;
	private List<ClassModel> classes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ClassModel> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassModel> classes) {
		this.classes = classes;
	}
	public UMLPackage(String name, List<ClassModel> classes) {
		super();
		this.name = name;
		this.classes = classes;
	}
	
}
