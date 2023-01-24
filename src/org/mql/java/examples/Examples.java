package org.mql.java.examples;

import java.io.File;

import org.mql.java.engine.ClassExplorer;
import org.mql.java.engine.ClassParser;
import org.mql.java.engine.PackageExplorer;

import org.mql.java.models.UMLPackage;
import org.mql.java.persistence.XMLFileGenerator;
import org.mql.java.utils.Filler;



public class Examples {
	public static File ProjectUrl=new File("/Users/mac/eclipse-workspace/p05-multithreading/bin");
	public static File XMLFileUrl=new File("resources/racine.xml");
     public void exp01() {

    	 ClassExplorer p=new ClassExplorer(ProjectUrl);
    	 ClassParser cp=new ClassParser(p.getClassesLoaded());
     }
     public void exp02() {
    	 PackageExplorer p=new PackageExplorer(ProjectUrl);
    	 XMLFileGenerator generator = new XMLFileGenerator(XMLFileUrl,Filler.exportPackages(p.getPackageFounded()));
    	 generator.persist();
	 	 
   
     }
     
     public Examples(){
    	 exp02();
     }
     public static void main(String[] args) {
		new Examples();
	}
}
