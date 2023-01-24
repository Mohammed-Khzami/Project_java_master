package org.mql.java.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


import org.mql.java.engine.ClassParser;
import org.mql.java.engine.PackageExplorer;
import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;
import org.mql.java.models.UMLClass;
import org.mql.java.models.UMLConstructor;
import org.mql.java.models.UMLEnum;
import org.mql.java.models.UMLField;
import org.mql.java.models.UMLInterface;
import org.mql.java.models.UMLMethod;
import org.mql.java.models.UMLPackage;

public class Filler {
	 
	private static List<UMLConstructor> getConstuctors(Constructor[] constuctors){
		List<UMLConstructor> UMLConstructors = new Vector<UMLConstructor>();
		for(Constructor c : constuctors) {
			UMLConstructors.add(fillUMLConstructor(c));
		}		
		return UMLConstructors;
	}
	private static List<UMLField> getFields(Field[] fields){
		List<UMLField> UMLFields = new Vector<UMLField>();
		for(Field f : fields) {
			UMLFields.add(fillUMLField(f));		
		}
		return UMLFields;
	}
	private static List<UMLMethod> getMethods(Method[] methods){
		List<UMLMethod> UMLMethods = new Vector<UMLMethod>();
		for(Method m : methods) {
			UMLMethods.add(fillUMLMethod(m));
		}		
		return UMLMethods;
	}
	
	private static List<String> getParameter(Parameter[] parameterz){
		List<String> parameters = new Vector<String>(); 
		for(Parameter p : parameterz) {
			parameters.add(p.getType().getCanonicalName());
		}
		return parameters;
	}
	
	private static List<UMLInterface> getInterfaces(Class c){
		List<UMLInterface> UMLInterfaces = new Vector<UMLInterface>();
		for(Class intrF  : c.getInterfaces()) {
			UMLInterfaces.add(fillUMLInterface(c));		
		}
		return UMLInterfaces;
	}
	public static List<Object> exportModels(List<Class> classes) {
		ClassParser p1=new ClassParser(classes);
		p1.parse();
		List<Object> modelExported=new LinkedList<Object>();
		modelExported.addAll(p1.getClasses());
		modelExported.addAll(p1.getInterfaces());
		modelExported.addAll(p1.getEnums());
		return modelExported;
	}
	public static List<Object> exportPackagesFormatObject(List<PackageExplorer> packages){
		List<UMLPackage> ensPackages = new LinkedList<UMLPackage>();
		for(PackageExplorer p:packages) {
			ensPackages.add(new UMLPackage(p));
		}
		List<Object> models = new Vector<>();
		models.addAll(ensPackages);
		return models;
	
	}
	public static List<UMLPackage> exportPackages(List<PackageExplorer> packages){
		List<UMLPackage> ensPackages = new LinkedList<UMLPackage>();
		for(PackageExplorer p:packages) {
			ensPackages.add(new UMLPackage(p));
		}
		
		return ensPackages;
	
	}
	
	@SuppressWarnings("unused")
	public static List<UMLPackage> fillUMLPackage(List<PackageExplorer> packgeExplorers) {
		List<UMLPackage> packgeModels = new Vector<>();
		for (PackageExplorer packgeExplorer : packgeExplorers) {
			packgeModels.add(new UMLPackage(packgeExplorer));
		}
		return packgeModels;
	}
	
	public static UMLEnum fillUMLEnum(Class c) {
		return new UMLEnum( c.getCanonicalName(),EnumsResolver.getVisibility(c.getModifiers()) ,  EnumsResolver.getModificator(c.getModifiers()));
	}
	public static UMLInterface fillUMLInterface(Class c){
		return 	new UMLInterface(c.getCanonicalName(),EnumsResolver.getVisibility(c),EnumsResolver.getModificator(c),getFields(c.getDeclaredFields()),getMethods(c.getDeclaredMethods()));
	}
	public static UMLClass fillUMLClass(Class c) {
		return new UMLClass(c.getCanonicalName(),EnumsResolver.getVisibility(c),EnumsResolver.getModificator(c),getFields(c.getDeclaredFields()),getMethods(c.getDeclaredMethods()),getConstuctors(c.getConstructors()),c.getSuperclass().getName(),getInterfaces(c));
	}
	
	private static UMLField fillUMLField(Field f){return new UMLField(f.getName(),EnumsResolver.getModificator(f),EnumsResolver.getVisibility(f),f.getGenericType().getTypeName());		
		
	}
	
	private static UMLMethod fillUMLMethod(Method m){
		return new UMLMethod(m.getName(),m.getReturnType().getCanonicalName(),EnumsResolver.getVisibility(m),EnumsResolver.getModificator(m),getParameter(m.getParameters()));
	}
	
	private static UMLConstructor fillUMLConstructor(Constructor c){
		return new UMLConstructor(c.getName(),EnumsResolver.getVisibility(c.getModifiers()),EnumsResolver.getModificator(c.getModifiers()),getParameter(c.getParameters()));
	}
	
	
	

	
	
	

}
