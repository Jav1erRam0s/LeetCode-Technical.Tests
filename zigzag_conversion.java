package Main;

public class zigzag_conversion {

	public static void main(String[] args) {
		/*
		The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

		P   A   H   N
		A P L S I I G
		Y   I   R

		And then read line by line: "PAHNAPLSIIGYIR"

		Write the code that will take a string and make this conversion given a number of rows:
		string convert(string s, int numRows);

		Example 1:
		Input: s = "PAYPALISHIRING", numRows = 3
		Output: "PAHNAPLSIIGYIR"
		
		Example 2:
		Input: s = "PAYPALISHIRING", numRows = 4
		Output: "PINALSIGYAHRPI"
		Explanation:
		P     I    N
		A   L S  I G
		Y A   H R
		P     I
		
		Example 3:
		Input: s = "A", numRows = 1
		Output: "A"
		*/

		String input = "PAYPALISHIRING";
		int row = 3;
		String output = zigzagConversion(input, row);

		//imprimimos la solucion
		System.out.println("- RESOLUCION -");
		System.out.print(output);
	}

	
	public static String zigzagConversion(String input, int row){

		if(row==1){ return input; }
		
		String output = "";
		int [] arregloPosicion = new int[input.length()];
		//Creamos las posiciones a recorrer. 
		int limiteSup = 1;
		int limiteInf = row;
		boolean baja = true;
		int posicionFila = 1;
		for (int i=0; i<input.length(); i++){
			if (baja){
				arregloPosicion[i]=posicionFila;
				posicionFila++;
			}else{
				arregloPosicion[i]=posicionFila;
				posicionFila--;
			}
			if(posicionFila>=limiteInf){ baja=false; }
			if(posicionFila<=limiteSup){ baja=true; }
		}
		//Formamos la palabra zigzag.
		for(int f=1; f<=row; f++){
			for (int indice=0; indice<arregloPosicion.length; indice++){
				if(f == arregloPosicion[indice]){
					output = output + input.charAt(indice);
				}
			}			
		}

		return output;
	}
		
}