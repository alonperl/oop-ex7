package oop.ex7.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oop.ex7.main.Member.*;
/**
 * Parser class - receives the command file from the manager, reads it and
 * creating sections by cases.
 *@author Vladimir Kravtsov
 */
public class Parser {

	/**
	 * parserFile method - gets the command file and reads it.
	 * @param - commandFile - contains sections each got filter and order.
	 * @return - Linked List of Section type contains all created sections.
	 * @throws ParserException.
	 */

	public static void parseFile(File sJava){

		//Master master;

		try {
			FileReader fileReader = new FileReader(sJava);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			
			LinkedList<String> lines = new LinkedList<String>();
			
			int lineCounter = 0;
			MethodTree methTree = new MethodTree();
			while ((line = bufferedReader.readLine()) != null){
				lineCounter++;
				line.replaceAll("\\s+", " ");
				checkValid(line);
				methTree.addLine(line, lineCounter);
			}

			fileReader.close();
			bufferedReader.close();

		}

		catch (IOException e) {
			System.err.println("ERROR");
			//return null;
		}
		//return master;
	}
	private static void checkValid(String line) throws IOException{
//		\\)[^\\w;]\\{"
		if( regexChecker("(^.*\\{){2,}", line)){
			return;
		}
		else if(regexChecker("(\\)\\s*\\{)$", line)){
			return;
		}
		else if(!regexChecker("(.*;){2,}", line) && regexChecker("[;]$", line)){
			return;
		}
		
		throw new IOException();

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
