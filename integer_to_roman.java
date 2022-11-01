package Main;

import java.util.*;

public class integer_to_roman {

	public static void main(String[] args) {
		/*
		Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
		
		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		
		For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.		
		Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
		
		    I can be placed before V (5) and X (10) to make 4 and 9. 
		    X can be placed before L (50) and C (100) to make 40 and 90. 
		    C can be placed before D (500) and M (1000) to make 400 and 900.
		
		Given an integer, convert it to a roman numeral.
		
		Example 1:		
		Input: num = 3
		Output: "III"
		Explanation: 3 is represented as 3 ones.
		
		Example 2:	
		Input: num = 58
		Output: "LVIII"
		Explanation: L = 50, V = 5, III = 3.
		
		Example 3:
		Input: num = 1994
		Output: "MCMXCIV"
		Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

		Constraints:
    	1 <= num <= 3999
		*/

		int input = 1562;

		String output = integerToRoman(input);

		//imprimimos la solucion
		System.out.println("- RESOLUCION -");
		System.out.print("Output : " + output);
	}
	
	public static String integerToRoman(int input)	{
		String output = "";
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1000); nums.add(500); nums.add(100); nums.add(50); nums.add(10); nums.add(5); nums.add(1);
		List<String> roms = new ArrayList<String>();
		roms.add("M"); roms.add("D"); roms.add("C"); roms.add("L"); roms.add("X"); roms.add("V"); roms.add("I");
	
		for (int i=0; i<nums.size(); i++) {
		    int cantRoms = input / nums.get(i);
		    input = input - cantRoms * nums.get(i);
		    for(int j=1; j<=cantRoms; j++){
		    	output = output + roms.get(i);
		    }
		}
		
		return output;
	}
	
}