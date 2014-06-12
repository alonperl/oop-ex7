package oop.ex7.main;

import oop.ex7.main.Member.Member;
import oop.ex7.main.Member.MemberFactory;

public class LineProcessor {



	public static Object processLine(int counter, String line){

		if(line.startsWith("//")){
			System.out.println("coment");
			return null;
		}
		else if(line.endsWith(";")){
			System.out.println("member");
			Member mem = MemberFactory.creatMember(line);
		}
		else if(line.endsWith("{")){
			System.out.println("function");
			Member mem = MemberFactory.creatMember(line); 
		}
		return null;

	}
}
