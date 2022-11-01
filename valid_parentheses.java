package Main;

import java.util.*;

public class Principal {

	public static void valid_parentheses(String[] args) {
		/*
		Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.		
		An input string is valid if:

	    Open brackets must be closed by the same type of brackets.
	    Open brackets must be closed in the correct order.
	    Every close bracket has a corresponding open bracket of the same type.
		*/

		String input = "()[]{}";
		System.out.println("Input es valido : " + validParentheses(input));
	}

	public static boolean validParentheses( String input ){
		List<String> parentesisTipos = new ArrayList<String>();
		parentesisTipos.add("()");
		parentesisTipos.add("[]");
		parentesisTipos.add("{}");
		if( input.length() % 2 != 0 ){
			return false;
		}
		String subcadena = "";
		for (int i=0; i < input.length()-1 ; i=i+2){
			subcadena = String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(i+1));
			if( !parentesisTipos.contains(subcadena) ){
				return false;
			}
		}
		return true;
	}
	
}