package Main;

import java.util.*;

public class decode_ways {

	public static void main(String[] args) {
		/*
		A message containing letters from A-Z can be encoded into numbers using the following mapping:
		
		'A' -> "1"
		'B' -> "2"
		...
		'Z' -> "26"
		
		To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
		
	    "AAJF" with the grouping (1 1 10 6)
	    "KJF" with the grouping (11 10 6)
		
		Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
		Given a string s containing only digits, return the number of ways to decode it.		
		The test cases are generated so that the answer fits in a 32-bit integer.
		
		Example 1:
		Input: s = "12"
		Output: 2
		Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
		
		Example 2:
		Input: s = "226"
		Output: 3
		Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
		
		Example 3:
		Input: s = "06"
		Output: 0
		Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
		*/

		String input = "226";

		//imprimimos la nueva matriz
		int output = decodeWays(input);
		System.out.println("- RESOLUCION -");
		System.out.println("Output " + output);
	}

	public static int decodeWays(String input){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "A");	map.put("2", "B");	map.put("3", "C");
		map.put("4", "D");	map.put("5", "E");	map.put("6", "F");
		map.put("7", "G");	map.put("8", "H");	map.put("9", "I");
		map.put("10", "J");	map.put("11", "K");	map.put("12", "L");
		map.put("13", "M");	map.put("14", "N");	map.put("15", "Ñ");
		map.put("16", "O");	map.put("17", "P");	map.put("18", "Q");
		map.put("19", "R");	map.put("20", "S");	map.put("21", "T");
		map.put("22", "U");	map.put("23", "V");	map.put("24", "W");
		map.put("25", "X");	map.put("26", "Y");	map.put("27", "Z");

		int contador = 0;
		
		List<String> parDosDos = new ArrayList<String>();
		for (int i=0; i<input.length(); i=i+2){
			if(i<=input.length()-2){
				parDosDos.add( String.valueOf(input.charAt(i))+String.valueOf(input.charAt(i+1)) );
			}
			else{
				parDosDos.add( String.valueOf(input.charAt(i)) );
			}
		}
		System.out.println("Par 2|2|2 - " + parDosDos.toString() );

		List<String> parUnoDos = new ArrayList<String>();
		parUnoDos.add( String.valueOf(input.charAt(0)));
		for (int i=1; i<input.length(); i=i+2){
			if(i<=input.length()-2){
				parUnoDos.add( String.valueOf(input.charAt(i))+String.valueOf(input.charAt(i+1)) );
			}
			else{
				parUnoDos.add( String.valueOf(input.charAt(i)) );
			}
		}
		System.out.println("Par 1|2|2 - " + parUnoDos.toString() );
		
		//par de un caracter 1|1|1|..
		for (int i=0; i<input.length();i++){
			//termina la ejecucion
			if(map.get(String.valueOf(input.charAt(i))) ==  null){	
				System.out.println("No se encontro en el mapa");
				break;
			}
			//Puedo codificar todos los pares de a un caracter
			if( i==input.length()-1 ){
				contador++;
			}
		}
		
		//par de dos caracteres 2|2|2|..
		for (int i=0; i<=parDosDos.size()-1; i++){
			//termina la ejecucion
			if( map.get(parDosDos.get(i)) == null ){
				break;	
			}
			//Puedo codificar todos los pares de a un caracter
			if( i==parDosDos.size()-1 ){	
				contador++;
			}
		}
		
		//par de dos caracteres 1|2|2|..
		if(input.length()>2){
			for (int i=0; i<=parUnoDos.size()-1; i++){
				//termina la ejecucion
				if( map.get(parUnoDos.get(i)) == null ){
					break;	
				}
				//Puedo codificar todos los pares de a un caracter
				if( i==parUnoDos.size()-1 ){	
					contador++;
				}
			}			
		}

		return contador;
	}
	
}