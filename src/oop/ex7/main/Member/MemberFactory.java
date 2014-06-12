package oop.ex7.main.Member;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberFactory {
	public static Member creatMember(String line){
		
		//String[] split = line.split("\\s[]");("[a-zS]{3,}(\\[)?[\\w]?(\\])?",line);
		
//		String type = regexChecker("[a-zS]{3,}(\\[)?[\\w]?(\\])?",line);
//		String name = regexChecker("\\s[a-zA-Z]+",line);
//
//		String value = regexChecker("=\\s[\\w\\s\\-\\+\\*/]*[(]?[\\w\\s\\-\\+\\*/,]*[)]?\\s*", line);
//		System.out.println(value);
//
//
//		System.out.println(type + name + value);
//		System.out.println(line);
//		if((type + name + value).equals(line)){
//			System.out.println("good");
//		}
//		value = value.replaceAll("[=]?[\\s]+", " ");
//		value = value.substring(1);
//		System.out.println(value);
//		String[] spliter = value.split(" ", 3);
//
//		for (int i = 0; i < spliter.length; i++) {
//			System.out.println(i + ": " + spliter[i]);
//		}
//
//		if(spliter.length > 3){
//			//exception.
//		}
//		
//		if(value.length() == 3){
//			return new Member(type ,name, spliter[0], spliter[2], spliter[1]);
//		}
//		if(value.length() == 2){
//			return new Member(name, spliter[1]);
//		}

		return null;


	}
	public static String regexChecker(String regexStr, String strToCheck){
		Pattern checkRegex = Pattern.compile(regexStr);
		Matcher matcher = checkRegex.matcher(strToCheck);
		while(matcher.find()){
			if(matcher.group().length() != 0){
				System.out.println("Start index: " + matcher.regionStart());
				System.out.println("End index: " + matcher.regionEnd());
				return matcher.group();
			}
		}
		return "!!!";
	}
}
