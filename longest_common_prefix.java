package Main;

public class longest_common_prefix {

	public static void main(String[] args) {
		/*
		Write a function to find the longest common prefix string amongst an array of strings.
		If there is no common prefix, return an empty string "".

		Example 1:
		Input: strs = ["flower","flow","flight"]
		Output: "fl"
		
		Example 2:
		Input: strs = ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.

		Constraints:
	    1 <= strs.length <= 200
	    0 <= strs[i].length <= 200
	    strs[i] consists of only lowercase English letters.
		*/

		String[] input = new String[] {"prime", "prisma", "proa"};

		System.out.println("- RESOLUCION -");
		System.out.print("Output : " + longestCommonPrefix(input));
	}
	
	public static String longestCommonPrefix(String[] input)	{
		String output = "";
		
		//Obtenemos la palabra mas corta.
		int size = input[0].length();
		for (String in : input){
			if(in.length()<=size){
				size = in.length();
			}
		}
		//Recorremos cobre cada palabra el puntero si coinciden, lo agregamos a output.	
		for (int puntero = 0; puntero < size; puntero++){
			for (int word = 0; word <= input.length-2; word++){
				if(input[word].charAt(puntero) != input[word+1].charAt(puntero)){
					return output;
				}
				if(word==input.length-2){
					output = output + input[word].charAt(puntero);
				}
			}
		}
		
		return output;
	}
	
}