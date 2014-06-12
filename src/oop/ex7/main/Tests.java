package oop.ex7.main;

import java.io.File;

public class Tests {
	public static void main(String[] args){
		
		File file = new File(args[0]);
		Parser.parseFile(file);
	}

	
}
