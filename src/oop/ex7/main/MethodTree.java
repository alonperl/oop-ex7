package oop.ex7.main;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oop.ex7.main.Member.*;
public class MethodTree {
	public Method currentMethod;  
	public MethodTree(){
		this.currentMethod = new Method();
		this.currentMethod.ParentMethod = null;
	}
	public void addLine(String line, int lineNumber) throws IOException{
		if(regexChecker("(\\)\\s*\\{)$", line)){
			Method subMethod = new Method();
			currentMethod.subMethods.add(subMethod);
			subMethod.ParentMethod = currentMethod;
			currentMethod = subMethod;
		}
		Expressions.lineAnalyzer(line, lineNumber, currentMethod);
		
		
	}
	
	public static boolean regexChecker(String regexStr, String strToCheck){
		Pattern checkRegex = Pattern.compile(regexStr);
		Matcher matcher = checkRegex.matcher(strToCheck);
		while(matcher.find()){
			if(matcher.group().length() != 0){
				System.out.println("Start index: " + matcher.start());
				System.out.println("End index: " + matcher.end());
				System.out.println(matcher.group());
				return true;
			}
		}
		return false;
	}
}