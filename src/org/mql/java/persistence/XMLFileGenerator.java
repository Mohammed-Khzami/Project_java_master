package org.mql.java.persistence;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mql.java.utils.Helper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLFileGenerator {
	private final static Logger logger = Logger.getLogger(XMLFileGenerator.class.getName());
	private Document document;
	private Element racine;
	private File file;
	private String projectName;
	
	
	public XMLFileGenerator(File fileTarget,List<?> object) {
		this.file = fileTarget;
		createDocument();
		appendModel(object);
	}
	
	private void createDocument() {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder =  factory.newDocumentBuilder();
			document =builder.newDocument();
			racine = document.createElement("Project");
		} catch (Exception e) {
			logger.warning("failed to create document");
		}
	
	}
	public void persist() {
		try {
			document.appendChild(racine);
			Result res = new StreamResult(file);
			DOMSource source = new DOMSource(document);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(source, res);
		} catch (Exception e) {
			logger.warning("erreur  lors de creation de fichier"+e.getMessage());
		}
	}
	
	public void appendModel(List<?> o) {
		racine.appendChild(createModelObject(o,"UMLDiagram"));
	}
	private Element createModelObject(List<?> objects,String name) {
		Element elementRac = document.createElement(name);
		for(Object o : objects) {	
					Element elm = createObject(o,o.getClass().getSimpleName());
					if(elm != null)
						elementRac.appendChild(elm);
			}
			return elementRac;
	}
	private Element createPrimitifObject(List<?> objects, String name) {
		Element elementRac = document.createElement(name);
			for(Object o : objects) {	
				Text elementValue = document.createTextNode(o.toString());
				Element elm = document.createElement(o.getClass().getSimpleName());
				elm.appendChild(elementValue);
				elementRac.appendChild(elm);
			}	
	return elementRac;
}
	private Element createModelObjects(List<?> objects,String name) {
		Element e = document.createElement(name);
		for(Object o : objects) {	
					Element elm = createObject(o,o.getClass().getSimpleName());
					if(elm != null)
						e.appendChild(elm);
					
			}
			return e;
	}

	private Element createObject(Object o,String name) {
		Element e = document.createElement(name);
		for(Field f : o.getClass().getDeclaredFields()) {
			if(Modifier.isPrivate(f.getModifiers())) {
				f.setAccessible(true);
				
			}
			Object newObj = Helper.getValue(f, o);
			
		
			if(newObj != null) {
				 if(List.class.isAssignableFrom(f.getType())){
					
					List<?> objects = (List<?>) newObj;
					if(objects != null) {
						Element elm = null;
						if(!objects.isEmpty()) {
							if(Helper.isPrimitifObject(objects)) {
								elm = createPrimitifObject(objects,f.getName());
							}
							else elm = createModelObjects(objects,f.getName());
									}
						if(elm != null) {
							e.appendChild(elm);
						}							
					}		
				}
				else if(f.getType().isPrimitive() || Helper.isString(newObj)) {
					e.setAttribute(f.getName(), Helper.getValue(f,o).toString());
				}
				else if(!newObj.getClass().isEnum()) {
					e.appendChild(createObject(newObj,f.getName()));
				}
				else {
						Text elementValue = document.createTextNode(newObj.toString());
						Element elm = document.createElement(f.getName());
						elm.appendChild(elementValue);
						e.appendChild(elm);		
				}
			
			}			
		}
		return e;
		}
		
		
		
	}
