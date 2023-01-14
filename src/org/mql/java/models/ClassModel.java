package org.mql.java.models;

import java.util.List;

public class ClassModel {
	
	private String name;
	private List<UMLField> fields;
	private List<UMLMethod> methods;
	private List<UMLConstructor> constructors;
	private List<ClassModel> supperClass;
	public ClassModel(String name, List<UMLField> fields, List<UMLMethod> methods, List<UMLConstructor> constructors,
			List<ClassModel> supperClass) {
		super();
		this.name = name;
		this.fields = fields;
		this.methods = methods;
		this.constructors = constructors;
		this.supperClass = supperClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UMLField> getFields() {
		return fields;
	}
	public void setFields(List<UMLField> fields) {
		this.fields = fields;
	}
	public List<UMLMethod> getMethods() {
		return methods;
	}
	public void setMethods(List<UMLMethod> methods) {
		this.methods = methods;
	}
	public List<UMLConstructor> getConstructors() {
		return constructors;
	}
	public void setConstructors(List<UMLConstructor> constructors) {
		this.constructors = constructors;
	}
	public List<ClassModel> getSupperClass() {
		return supperClass;
	}
	public void setSupperClass(List<ClassModel> supperClass) {
		this.supperClass = supperClass;
	}
	

}
