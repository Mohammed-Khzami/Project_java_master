package orq.mql.java.examples;

import java.io.File;

import org.mql.java.engine.ClassParser;

public class Examples {
     public void exp01() {
    	 File f=new File("/Users/mac/eclipse-workspace/p05-multithreading/bin");
    	 ClassParser p=new ClassParser(f);
     }
     public Examples(){
    	 exp01();
     }
     public static void main(String[] args) {
		new Examples();
	}
}
