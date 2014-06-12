package oop.ex7.main.Member;

public class IntMember {
	
	private String name;
	private String val1;
	private String val2;
	private String operator;
	
	public IntMember(String name){
		this.name = name;
	}
	
	public IntMember(String name, String val){
		this.name = name;
		this.val1 = val;
	}
	
	public IntMember(String name, String val1, String val2, String operator){
		this.name = name;
		this.val1 = val1;
		this.val2 = val2;
		this.operator = operator;
	}
	
	
}
