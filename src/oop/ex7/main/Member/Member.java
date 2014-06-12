package oop.ex7.main.Member;

public class Member {
	public String type;
	public String name;
	public String val1;
	public String val2;
	public String operator;
	public int lineNumber;
	
	public Member(String type, String name,int lineNumber){
		this.name = name;
		this.type = type;
		this.lineNumber = lineNumber;
	}
	
	public Member(String type, String name, String val, int lineNumber){
		this.name = name;
		this.val1 = val;
		this.type = type;
		this.lineNumber = lineNumber;
	}
	
	public Member(String type, String name, String val1, String val2, 
						String operator,int lineNumer){
		this.type = type;
		this.name = name;
		this.val1 = val1;
		this.val2 = val2;
		this.operator = operator;
		this.lineNumber = lineNumber;
	}
}
