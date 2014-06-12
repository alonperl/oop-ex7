package oop.ex7.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static String regexParser(String regexStr, String strToCheck){
		Pattern checkRegex = Pattern.compile(regexStr);
		Matcher matcher = checkRegex.matcher(strToCheck);
		while(matcher.find()){
			if(matcher.group().length() != 0){
				System.out.println("Start index: " + matcher.start());
				System.out.println("End index: " + matcher.end());
//				System.out.println(matcher.group());
				return matcher.group().trim();
			}
		}
		return null;
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
	public static boolean isFuncCall(String value){
		return false;
	}
	
}
