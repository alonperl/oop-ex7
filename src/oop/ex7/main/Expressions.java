package oop.ex7.main;

import java.io.IOException;

import oop.ex7.main.Member.Member;

public class Expressions {
	
	public static final String[] types = {"int","String","double","boolean","char"};
	
	public static void lineAnalyzer(String line,
			int lineNumber, Method currentMethod) throws IOException{
		String type = Regex.regexParser("[a-zS]{3,}(\\[)?[\\w]?(\\])?",line);
		if(Regex.regexChecker("(\\)\\s*\\{)$", line)){
			
//			String type = Regex.regexParser("[a-zS]{3,}(\\[)?[\\w]?(\\])?",line);
			
			System.out.println(type);
			
			String name = Regex.regexParser("\\s[a-zA-Z]+",line);
			
			System.out.println(name);
			
			String variables = Regex.regexParser("\\([\\s\\w_,]*\\)",line);
			if(!variables.equals("()")){
				String[] vari = variables.substring(1,
						variables.length()-1).split("(\\s)?,(\\s)?");
				for (int i = 0; i < vari.length; i++) {
					String[] splitted = vari[i].split("\\s");
					currentMethod.variables.add(new Member(splitted[0], splitted[1]));
				}
			}
			
		}
		else if(Regex.regexChecker("[;]$", line)){
			line = line.replaceAll("(\\s)*;","");
			// check if "return" line
			if(Regex.regexChecker("return", line)){
				String[] vari = line.split("(\\s){1,}",2);
				if(vari.length > 1){
					currentMethod.returnValue = vari[1];
					System.out.println(currentMethod.returnValue);
				}
				else if(vari.length == 1){
					currentMethod.returnValue = "void";
					System.out.println(currentMethod.returnValue);
				}
				
				//check if return array
//				String array = Regex.regexParser("\\{[\\s\\w_,]*\\}",line);
				System.out.println(vari.length);
			}
			// new member
			else if(isType(type)){
				String name = Regex.regexParser("\\s[a-zA-Z]+",line);
				String value = Regex.regexParser("=\\s[\\w\\s\\-\\+\\*/]*[(]?[\\w\\s\\-\\+\\*/,]*[)]?\\s*", line).replaceAll("=(\\s)*","");
				System.out.println(name + "*/*/*" + value);
				//TODO to split the value and check also for more than one operator;
				String val1 = Regex.regexParser("[\\-\\w_]*[^\\-\\+\\*/]", value);
				System.out.println(val1);
				String oper = Regex.regexParser("[^\\w\\s\\-][\\s\\-\\+\\*/]*", value);
				System.out.println(oper);
				if(oper.length() > 1 ){
					throw new IOException();
				}
				else if(oper.length() == 1){
					String val2 = Regex.regexParser("[^\\w\\-\\+\\*/]*+[\\w_\\-\\+\\*/]*", value);
					System.out.println(val2);
					//val2 = Regex.regexParser("[\\w_]*", val2);
					System.out.println(val2);
				}
				
				
			}
		}
	}
	private static boolean isType(String type){
		for(int i=0; i<types.length; i++){
			if(type.equals(type))
				return true;
		}
		return false;
	}
}
