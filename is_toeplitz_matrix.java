package Main;

public class Principal {

	public static void main(String[] args) {
		/*
		Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
		A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
		
		Example 1:
		Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
		Output: true
		Explanation:
		In the above grid, the diagonals are:
		"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
		In each diagonal all elements are the same, so the answer is True.

		Example 2:
		Input: matrix = [[1,2],[2,2]]
		Output: false
		Explanation:
		The diagonal "[1, 2]" has different elements.
		*/
		
		int[][] input = new int[][] { {1,2,3,4}, {5,1,2,3}, {9,5,1,2} };
		
		System.out.println(" - SOLUCION - ");
		System.out.print("Es toeplitz : " + isToeplitzMatrix(input));
	}

	public static boolean isToeplitzMatrix( int[][] input ){
		//recorremos las diagonales con fila 0 fija, y chequeamos que sea igual a cada elemento de la fila.
		int cantFilas = input.length;
		for(int c = 0; c < input[0].length; c++){
			int valor = input[0][c];
			for(int f = 1; f < cantFilas; f++){
				try{	
					if(input[f][c+f] != valor){ return false; };
				}
				catch(Exception ex){	
					break;	
				}
			}
		}
		//recorremos las diagonales con columna 0 fija, y chequeamos que sea igual a cada elemento de la columna.
		int cantColumnas = input[0].length;
		for(int f = 0; f < input.length; f++){
			int valor = input[f][0];
			for(int c = 1; c < cantColumnas; c++){
				try{
					if(input[f+c][c] != valor){ return false; };
				}
				catch(Exception ex){	
					break;	
				}
			}
		}
		//si no sale porque algun elemento de las diagonales es distinto, entonces es toeplitz.
		return true;
	}
	
}