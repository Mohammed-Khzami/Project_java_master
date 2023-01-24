package org.mql.java.utils;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

import org.mql.java.enums.Modifiers;
import org.mql.java.enums.Visibility;

public class EnumsResolver {
	public static Modifiers getModificator(int mod) {
		if(Modifier.isFinal(mod)) return Modifiers.FINAL;
		else if(Modifier.isStatic(mod)) return Modifiers.STATIC;
		else if(Modifier.isAbstract(mod)) return Modifiers.ABSTRACT;
		else return null;
	}
	public static Modifiers getModificator(Class c) {
		return getModificator(c.getModifiers());
	}
	
	public static Modifiers getModificator(Member member) {
		return getModificator(member.getModifiers());
	}
	public static Visibility getVisibility(Class c) {
		return getVisibility(c.getModifiers());
	}
	
	public static Visibility getVisibility(int mod) {
		if(Modifier.isPrivate(mod)) return Visibility.PRIVATE;
		else if(Modifier.isPublic(mod)) return Visibility.PUBLIC;
		else if(Modifier.isProtected(mod)) return Visibility.PROTECTED;
		else return Visibility.DEFAULT;
	}
	
	public static Visibility getVisibility(Member member) {
		return getVisibility(member.getModifiers());
	}
	


}
