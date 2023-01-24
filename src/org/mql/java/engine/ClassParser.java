package org.mql.java.engine;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.mql.java.models.UMLClass;
import org.mql.java.models.UMLConstructor;
import org.mql.java.models.UMLEnum;
import org.mql.java.models.UMLField;
import org.mql.java.models.UMLInterface;
import org.mql.java.models.UMLMethod;
import org.mql.java.utils.Filler;
import org.mql.java.utils.Filler.*;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;



public class ClassParser {
	private final static Logger logger = Logger.getLogger(ClassParser.class.getName());
	private List<UMLClass> classes;
	private List<UMLInterface> interfaces;
	private List<UMLEnum> enums;
	@SuppressWarnings("rawtypes")
	private List<Class> loadedClasses;
		
	public ClassParser(List<Class> loadedClasses) {
		this.loadedClasses=loadedClasses;
		classes=new LinkedList<UMLClass>();
		interfaces=new LinkedList<UMLInterface>();
		enums=new LinkedList<UMLEnum>();	
	}
	
	public void parse() {
		if(loadedClasses!=null) {
		for(Class cls:loadedClasses) {
			if(cls.isEnum()) enums.add(Filler.fillUMLEnum(cls));
			else if(cls.isInterface())interfaces.add(Filler.fillUMLInterface(cls));
			else classes.add(Filler.fillUMLClass(cls));
			
		}
		}
		else {
			logger.info("Empty classes to parse ");
		}
	}

	public List<UMLClass> getClasses() {
		return classes;
	}

	public void setClasses(List<UMLClass> classes) {
		this.classes = classes;
	}

	public List<UMLInterface> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<UMLInterface> interfaces) {
		this.interfaces = interfaces;
	}

	public List<UMLEnum> getEnums() {
		return enums;
	}

	public void setEnums(List<UMLEnum> enums) {
		this.enums = enums;
	}
	
	

	
}
