package oop.ex7.main;
import oop.ex7.main.Member.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class MethodValidator {
	public boolean isMethodValid(Method methodToCheck) throws Exception{
		Iterator<Method> iterMethod = methodToCheck.subMethods.iterator();
		while(iterMethod.hasNext()){
			return isMethodValid(iterMethod.next());
		}
		checkMethodTerm(methodToCheck);
		checkMethodReturn(methodToCheck);
		checkMethodMembers(methodToCheck);
		checkMethodOperations(methodToCheck);
		return true;
	}
	public boolean checkMethodTerm(Method methodToCheck) throws VariableNotBooleanException, UnknownMemberException{
		if (methodToCheck.name.equals("if") || methodToCheck.name.equals("while")){
			Iterator<Member> iterVars = methodToCheck.variables.iterator();
			if(iterVars.hasNext()){
				String term = iterVars.next().name;
				if(term.equals("true") || term.equals("false"))
					return true;
				else if(serachValueToTheRoot(term, methodToCheck).equals("boolean"))
					return true;
				else
					throw new VariableNotBooleanException();
			}
		}
		return true;
	}
	public boolean checkMethodReturn(Method methodToCheck) throws 
					WrongReturnTypeException, UnknownMemberException{
		//
		if(!methodToCheck.returnType.equals(serachValueToTheRoot
				(methodToCheck.returnValue,methodToCheck)))
			throw new WrongReturnTypeException();
		return true;
	}
	public boolean checkMethodOperations(Method methodToCheck) throws UnknownMemberException, WrongTypeException{
		for(Operation o : methodToCheck.operations){
			checkOperation(o,methodToCheck);
		}
		return true;
	}
	public boolean checkOperation(Operation operation,Method methodToCheck) throws UnknownMemberException, WrongTypeException{
		String typeOperName = serachValueToTheRoot(operation.name, methodToCheck);
		if(typeOperName!= null){
			String typeVal1 = serachValueToTheRoot(operation.val1, methodToCheck);
			if(typeOperName.equals(typeVal1)){
				if(operation.val2 != null){
					String typeVal2 = serachValueToTheRoot(operation.val2, methodToCheck);
					if(!typeOperName.equals(typeVal2))
						throw new WrongTypeException();
				}
			}
		}
		return true;
	}
	public boolean checkMethodMembers(Method methodToCheck) throws WrongTypeException, UnknownMemberException{
		for(Member m : methodToCheck.members){
			checkMember(m, methodToCheck);
		}
		return true;
	}
	public void checkMember(Member member, Method methodToCheck) throws WrongTypeException, UnknownMemberException{
    //check if val1 and val2 are local;
		if(member.val1 != null){
			String typeVal1 = serachValueToTheRoot(member.val1, methodToCheck);
			if(typeVal1 != null){
				if(!typeVal1.equals(member.type))
					throw new WrongTypeException();
			}
		}
		if(member.val2 != null){
			String typeVal2 = serachValueToTheRoot(member.val2, methodToCheck);
			if(typeVal2 != null){
				if(!typeVal2.equals(member.type))
					throw new WrongTypeException();
			}
		}		
	}
	public String searchLocalMembers(String memberName,LinkedList<Member> members){
		for (Member m : members) {
			if(memberName.equals(m.name))
				return m.type;	
		}
		return null;
	}
	public String searchLocalMethods(String methodName,LinkedList<Method> methods){
		for (Method m : methods) {
			if(methodName.equals(m.name))
				return m.returnType;	
		}
		return null;
	}
	public String serachValueToTheRoot(String value, Method methodToCheck) throws UnknownMemberException{
		Method currentMethod = methodToCheck;
		String searchedType;
		searchedType = typeOfValue(value);
		while(searchedType == null && currentMethod != null){
			if(Regex.isFuncCall(value))
				searchedType = searchLocalMethods(value, currentMethod.subMethods);
			else
				searchedType = searchLocalMembers(value, currentMethod.members);
			currentMethod = methodToCheck.ParentMethod;
		}
		if(searchedType == null)
			throw new UnknownMemberException();
		else
			return searchedType;
			
	}
	public String typeOfValue(String value){
		try{
			int val =Integer.parseInt(value);
		}
		catch(NumberFormatException nfe1){
			try{
				double d = Double.parseDouble(value);
			}
			catch(NumberFormatException nfe2){
				return null;
			}
			return "double";
			
		}
		return "int";
	}
}
