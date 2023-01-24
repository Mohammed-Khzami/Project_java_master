package org.mql.java.utils;

import java.io.File;

public  class StringFormatter {
  public static final String convertpathToRelative(String filePath,String absolutePath) {
	  return filePath.replace(absolutePath+"/","").replace(".class", "").replace("/", ".");
  }
  public static final String converpathToOldPath(File directory) {
	  return directory.getAbsolutePath().split("bin")[0]+"bin";
  }
}
