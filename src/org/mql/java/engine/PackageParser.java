package org.mql.java.engine;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.models.UMLPackage;


public class PackageParser {

	private List<Class> classes;
	private List<UMLPackage> packages;
	
	public PackageParser(File f) {
		classes = new ClassParser(f).getClassesLoaded();
		packages = new Vector<>();
		
	}
	
	
	
	
	
}
