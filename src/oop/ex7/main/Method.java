package oop.ex7.main;

import java.util.LinkedList;

import oop.ex7.main.Member.Member;

public class Method {
	public LinkedList<Member> members;
	public LinkedList<Operation> operations;
	public LinkedList<Function> functions;
	public LinkedList<Method> subMethods;
	public Method ParentMethod;
	
	public String name;
	public LinkedList<Member> variables;
	public String returnType;
	public String returnValue;
	
	public Method(){
		members = new LinkedList<Member>();
		operations = new LinkedList<Operation>();
		functions = new LinkedList<Function>();
		subMethods =  new LinkedList<Method>();
		variables = new LinkedList<Member>();
	}
}
