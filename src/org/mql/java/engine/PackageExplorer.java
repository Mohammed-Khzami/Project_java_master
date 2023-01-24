package org.mql.java.engine;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.mql.java.utils.Helper;


public class PackageExplorer {
	private final static Logger logger = Logger.getLogger(PackageExplorer.class.getName());
	private String packageName;
	private List<PackageExplorer> packageFounded;
	@SuppressWarnings("rawtypes")
	private List<Class> classesFoundedInPackage;
	@SuppressWarnings("rawtypes")
	public PackageExplorer(File directory) {
		File f=directory;
		packageFounded = new LinkedList<PackageExplorer>();
		this.classesFoundedInPackage = new LinkedList<Class>();
		parse(f);
	}

	public void parse(File directory) {
       if(directory!=null) {
		for (File file : directory.listFiles()) {
			if (file.isDirectory()) {
				if (Helper.isValidPackage(file)) {
					if (Helper.hasFils(directory, file)) packageFounded.add(new PackageExplorer(file, file.getAbsolutePath()));
				} else {
					directory = new File("" + file.getAbsoluteFile());
					parse(directory);
				}
			}
		}
       } else logger.warning("invalid Directory");

	}
	public PackageExplorer(File directory, String name) {

		this(directory);
		this.packageName = name;
		if (Helper.hasClass(directory)) {
			ClassExplorer cx=new ClassExplorer(directory);
			cx.explore(directory);
			classesFoundedInPackage.addAll(cx.getClassesLoaded());
		}
	}
	
	


	public List<PackageExplorer> getPackageFounded() {
		return packageFounded;
	}

	public List<Class> getClasses() {
		return classesFoundedInPackage;
	}

	public String getName() {
		return  packageName;
	}
	
	


	
	
	
}
