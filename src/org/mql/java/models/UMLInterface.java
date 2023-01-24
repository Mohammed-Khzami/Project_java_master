package org.mql.java.models;

import java.util.LinkedList;
import java.util.List;


import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;

public class UMLInterface {
	private String name;
	private Visibility visibility;
	private Modifiers modificator;
	private List<UMLField> fields;
	private List<UMLMethod> methods;
	public UMLInterface() {
		fields=new LinkedList<>();
		methods=new LinkedList<>();
	}
	public UMLInterface(String name, Visibility visibility, Modifiers modificator, List<UMLField> fields,
			List<UMLMethod> methods) {
		super();
		this.name = name;
		this.visibility = visibility;
		this.modificator = modificator;
		this.fields = fields;
		this.methods = methods;
	}
	
	public void addField(UMLField field) {
		fields.add(field);
	}
	
	public void addMethod(UMLMethod method) {
		methods.add(method);
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
	
	

}
