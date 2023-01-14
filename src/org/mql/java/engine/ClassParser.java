package org.mql.java.engine;

import java.io.File;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Vector;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassParser {

	private String absolutePath;
	private List<String> classesNames;
	private List<Class> classesLoaded;
	
    public ClassParser(File directory) {
		this.absolutePath=directory.getAbsolutePath();
		classesNames=new Vector<>();
		classesLoaded=new Vector<>();
		ExtractClassesNames(directory);
		loadClasses();
		display();
		
	}
    
    public List<Class> getClassesLoaded() {
		return classesLoaded;
	}

	public void setClassesLoaded(List<Class> classesLoaded) {
		this.classesLoaded = classesLoaded;
	}

	public void ExtractClassesNames(File directory) {
    	for(File file:directory.listFiles()) {
			if(file.isFile()) {
				if(file.getName().endsWith(".class")) {
					String pathName = file.getAbsolutePath().replace(absolutePath+"/","").replace(".class", "").replace("/", ".");
					System.out.println(pathName);

					classesNames.add(pathName);
				}
			}else if(file.isDirectory()) {
				ExtractClassesNames(file);
			}
		}
    }
		private void loadClasses() {
				
				try {
					URL[] classURLs = { new URL("file:///"+absolutePath+"/") };
					  for(String cls:classesNames) {
						  URLClassLoader classLoader = new URLClassLoader(classURLs);
						  classesLoaded.add(classLoader.loadClass(cls));
					  }
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
			}
		
		
		void display() {
			for(int i=0;i<classesLoaded.size();i++) {
				System.out.println(classesLoaded.get(i).getSimpleName());
			}
		}
	
}
