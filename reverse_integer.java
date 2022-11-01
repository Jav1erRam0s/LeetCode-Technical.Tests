package Main;

public class reverse_integer {

	public static void main(String[] args) {
		/*
		Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
		the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
		Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

		Example 1:
		Input: x = 123
		Output: 321
		
		Example 2:
		Input: x = -123
		Output: -321
		
		Example 3:
		Input: x = 120
		Output: 21

		Constraints:
		-231 <= x <= 231 - 1
		*/

		int input = Integer.MAX_VALUE * -1;
		long output = reverseInteger(input);

		//imprimimos la solucion
		System.out.println("- RESOLUCION -");
		System.out.print(output);
	}
	
	public static long reverseInteger(int input){
		int limiteSup = Integer.MAX_VALUE;
		int limiteInf = Integer.MIN_VALUE;
		if( (limiteInf < input && input < limiteSup) == false ){
			return 0;
		}
		boolean positive= true;
		if(input<0){ 
			positive = false;
			input = input * -1;
		}
		String cadenaNum = String.valueOf(input);
		String cadenaNumReverse = "";
		
		for(char letra : cadenaNum.toCharArray()){
			cadenaNumReverse = letra + cadenaNumReverse;
		}
		long sol = Long.parseLong(cadenaNumReverse);
		if(!positive){ sol = sol * -1; }
		
		return sol;
	}
		
}