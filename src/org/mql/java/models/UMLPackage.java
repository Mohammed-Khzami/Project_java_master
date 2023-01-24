package org.mql.java.models;

import java.util.LinkedList;
import java.util.List;

import org.mql.java.engine.PackageExplorer;
import org.mql.java.utils.Filler;



public class UMLPackage {

	private String name;
	private List<UMLPackage> innerPackages;
	private List<Object> models;
	
	public UMLPackage(PackageExplorer packageFounded){
		this.name=packageFounded.getName();
		innerPackages=new LinkedList<UMLPackage>();
		models=Filler.exportModels(packageFounded.getClasses());
		innerPackages=Filler.fillUMLPackage(packageFounded.getPackageFounded());
	}
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UMLPackage> getInnerPackages() {
		return innerPackages;
	}
	public void setInnerPackages(List<UMLPackage> innerPackages) {
		this.innerPackages = innerPackages;
	}
	public List<Object> getModels() {
		return models;
	}
	public void setModels(List<Object> models) {
		this.models = models;
	}
	
	
}
