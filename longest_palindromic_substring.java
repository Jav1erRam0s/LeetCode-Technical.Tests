package Main;

import java.util.*;

public class longest_palindromic_substring {

	public static void main(String[] args) {
		/*
		Given a string s, return the longest palindromic substring in s.
		A string is called a palindrome string if the reverse of that string is the same as the original string.
		
		Example 1:
		Input: s = "babad"
		Output: "bab"
		Explanation: "aba" is also a valid answer.
		
		Example 2:
		Input: s = "cbbd"
		Output: "bb"
		*/

		String input = "javigiverggghhhggguuuhottohuuuggg";
		String output = longestPalindromicSubstring(input);

		//imprimimos la solucion
		System.out.println("- RESOLUCION -");
		System.out.print(output);
	}

	
	public static String longestPalindromicSubstring(String cadena){
		String capicuaLongest = "";
		String palabra = "";
		List<String> palabras = new ArrayList<String>();
		for (int i=0; i<cadena.length(); i++){
			palabra = "";
			palabra = palabra + cadena.charAt(i);
			for (int j=i+1; j<cadena.length(); j++){
				palabra = palabra + cadena.charAt(j);
				palabras.add(palabra);
			}
			
		}
		for(String combinacion : palabras){
			if(isPolidromo(combinacion) && combinacion.length()>capicuaLongest.length()){
				capicuaLongest = combinacion;				
			}
		}

		return capicuaLongest;
	}
	
	public static boolean isPolidromo(String cadena){
		String cadenaRevert = "";
		for(int i=0; i<cadena.length(); i++){
			cadenaRevert = cadena.charAt(i) + cadenaRevert;
		}
		return cadena.equals(cadenaRevert);
	}
	
}