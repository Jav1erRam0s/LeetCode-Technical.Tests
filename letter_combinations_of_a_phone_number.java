package Main;

import java.util.*;

public class letter_combinations_of_a_phone_number {

	public static void main(String[] args) {
		/*
		Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
		Return the answer in any order.
		A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
		
		Example 1:
		Input: digits = "23"
		Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

		Example 2:
		Input: digits = ""
		Output: []

		Example 3:
		Input: digits = "2"
		Output: ["a","b","c"]

		Constraints:
		0 <= digits.length <= 4
		digits[i] is a digit in the range ['2', '9'].
		*/

		int input = 23;
		List<String> output = letterCombinationsOfaPhoneNumber(input);
		for(String out : output){
			System.out.print(out.toString() + ", ");
		}
	}
	
	public static List<String> letterCombinationsOfaPhoneNumber(int input) {
		List<String> output = new ArrayList<String>();
		List<String> bolsaAnterior = new ArrayList<String>();
		
		List<String> numValues = new ArrayList<String>();
		HashMap<String, String> phone = new HashMap<String, String>();
		phone.put("2", "abc");
		phone.put("3", "def");
		phone.put("4", "ghi");
		phone.put("5", "jkl");
		phone.put("6", "mno");
		phone.put("7", "pqrs");
		phone.put("8", "tuv");
		phone.put("9", "wxyz");

		//Guardamos los valores en un arreglos de strings.
		String inputStr = Integer.toString(input);
		for(char caracter : inputStr.toCharArray()){
			numValues.add( phone.get(String.valueOf(caracter)) );			
		}

		//Recorremos conjunto de caracteres
		for(int i = 0; i < numValues.size(); i++){
			String value = numValues.get(i);
			//Recorremos caracter del conjunto
			for(int c = 0; c < value.length() ;c++){
				String caracter = String.valueOf( value.charAt(c) );
				if( i == 0 ){
					output.add(caracter);
				}
				else{
					output = distributiva( bolsaAnterior, output, caracter );
				}
			}
			if(i<numValues.size()-1){
				bolsaAnterior.clear();
				bolsaAnterior.addAll(output);
				output.clear();				
			}

		}
		return output;
	}
	
	public static List<String> distributiva(List<String> bolsaAnterior, List<String> output, String c){
		for(int i = 0; i < bolsaAnterior.size(); i++){
			output.add(bolsaAnterior.get(i) + c);
		}
		return output;
	}
	
}