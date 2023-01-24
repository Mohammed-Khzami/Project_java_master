package org.mql.java.models;


import java.util.List;
import java.util.Vector;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;





public  class UMLClass {
	
	
	private String name;
	private Visibility visibility;
	private Modifiers modificator;
	private List<UMLField> fields;
	private List<UMLMethod> methods;
	private List<UMLConstructor> constructors;
	private String supperClass;
	private List<UMLInterface> implemented;
	
	
	public UMLClass(String name, Visibility visibility, Modifiers modificator, List<UMLField> fields,
			List<UMLMethod> methods, List<UMLConstructor> constructors, String supperClass,List<UMLInterface> implemented) {
		super();
		this.name = name;
		this.visibility = visibility;
		this.modificator = modificator;
		this.fields = fields;
		this.methods = methods;
		this.constructors = constructors;
		this.supperClass = supperClass;
		this.implemented=implemented;
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

	
	
	public UMLClass() {
		fields = new Vector<UMLField>();
		methods = new Vector<UMLMethod>();
		constructors = new Vector<UMLConstructor>();
	}
	public UMLClass(String className) {
		this.name=className;
	}
	
	public void addField(UMLField fieldModel) {
    	fields.add(fieldModel);
    }
	public void addMethod(UMLMethod methodModel) {
    	methods.add(methodModel);
    }
	public void addConstructor(UMLConstructor constructorModel) {
		constructors.add(constructorModel);
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


	@Override
	public String toString() {
		return "UMLClass [name=" + name + ", visibility=" + visibility + ", modificator=" + modificator + ", fields="
				+ fields + ", methods=" + methods + ", constructors=" + constructors + ", supperClass=" + supperClass
				+ ", implemented=" + implemented + "]";
	}

	

}
