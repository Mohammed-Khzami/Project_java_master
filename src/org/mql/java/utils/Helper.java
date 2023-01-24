package org.mql.java.utils;

import static org.mql.java.utils.StringFormatter.convertpathToRelative;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.logging.Logger;

import org.mql.java.engine.ClassExplorer;

public class Helper {
	private final static Logger logger = Logger.getLogger(Helper.class.getName());

	public static List<String> directoryExplorer(File directory,String absolutePath, List<String> classesNames) {
    	for(File file:directory.listFiles()) {
			if(file.isFile()) {
				if(file.getName().endsWith(".class")) {
					classesNames.add(convertpathToRelative(file.getAbsolutePath(),absolutePath));
				}
			}else if(file.isDirectory()) {
				directoryExplorer(file,absolutePath,classesNames);
			}
		}
    	return classesNames;
    	
    	
    }
	public static List<Class> loadClasses(File directory,String absolutePath,List<Class> classesLoaded,List<String> classesNames ) {
		
		try {
			URL[] classURLs = { new URL("file:///"+absolutePath+"/") };
			  for(String cls:classesNames) {
				  URLClassLoader classLoader = new URLClassLoader(classURLs);
				  
				  classesLoaded.add(classLoader.loadClass(cls));
			  }
		} catch (Exception e) {
			logger.warning("Failed loading class : "+ directory.getName());
			
		}
		
		return classesLoaded;
		
	}
	public static  boolean isValidPackage(File file) {
		int i = 0;
		if (file.listFiles() != null) {
			for (File f : file.listFiles()) {
				if (f.isFile() && f.getName().endsWith(".class"))
					return true;
				else if (f.isDirectory())
					i++;
			}
		}

		return i > 1;

	}
	public static  boolean hasFils(File parent, File fils) {

		String parentFile = parent.getAbsolutePath();
		String filsFile = fils.getAbsolutePath();
		filsFile = filsFile.substring(0, filsFile.lastIndexOf("/"));
		return parentFile.equals(filsFile);
	}

	public static  boolean hasClass(File dir) {

		if (dir.listFiles() != null) {
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					if (file.getName().endsWith(".class")) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean isPrimitifObject(List<?> objects) {
		
		return isPrimitif(objects.get(0));
	}
	
	public static boolean isPrimitif(Object o) {
		if(o.getClass().getCanonicalName().contains("java.lang")) return true;
		return false;
	}
	public static boolean isString(Object o) {
		return o instanceof String;
		}
    
	public static Object getValue(Field f, Object o) {
		try {
			return f.get(o);
			
		} catch (Exception e) {	
			logger.warning("la valeur de l'atrribut est null"+e.getMessage());
		}
		return null;}
}


