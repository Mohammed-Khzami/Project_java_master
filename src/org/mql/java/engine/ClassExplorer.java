package org.mql.java.engine;

import java.io.File;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.mql.java.utils.Helper;


import static org.mql.java.utils.StringFormatter.converpathToOldPath;

public class ClassExplorer {
	private final static Logger logger = Logger.getLogger(ClassExplorer.class.getName());
	private String absolutePath;
	private List<String> classesNames;
	@SuppressWarnings("rawtypes")
	private List<Class> classesLoaded;
	
    public ClassExplorer(File directory) {
    	this.absolutePath = converpathToOldPath(directory);
		classesNames=new LinkedList<>();
		classesLoaded=new LinkedList<>();
	}
    
    
  

	public void explore(File directory) {
		classesNames=Helper.directoryExplorer(directory, absolutePath, classesNames);
		if(classesNames!=null) {
			classesLoaded=Helper.loadClasses(directory, absolutePath, classesLoaded, classesNames);
		}
		else {
			logger.info("no class found  to load");
		}
		
	}



		public String getAbsolutePath() {
			return absolutePath;
		}




		public void setAbsolutePath(String absolutePath) {
			this.absolutePath = absolutePath;
		}




		public List<String> getClassesNames() {
			return classesNames;
		}




		public void setClassesNames(List<String> classesNames) {
			this.classesNames = classesNames;
		}




		public List<Class> getClassesLoaded() {
			return classesLoaded;
		}




		public void setClassesLoaded(List<Class> classesLoaded) {
			this.classesLoaded = classesLoaded;
		}
		
		
		
		
	
}
