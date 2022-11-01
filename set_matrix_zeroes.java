package Main;

public class set_matrix_zeroes {

	public static void main(String[] args) {
		/*
		Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
		You must do it in place.

		Example 1:
		Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
		Output: [[1,0,1],[0,0,0],[1,0,1]]

		Example 2:
		Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
		Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
		*/

		//matriz inicial
		int [][] matriz = {{0,1,1,1},{1,1,1,1},{1,1,0,1}};
		//matriz final
		int [][] newMatriz = setMatrixZeroes(matriz);

		//imprimimos la nueva matriz
		System.out.println("- RESOLUCION -");
		for (int x=0; x < newMatriz.length; x++) {
		  System.out.print("[ ");
		  for (int y=0; y < newMatriz[x].length; y++) {
		    System.out.print(newMatriz[x][y]);
		    if(y != newMatriz[x].length-1){
		    	System.out.print(", ");
		    }
		  }
		  System.out.print(" ]");
		  System.out.println();
		}
		
	}

	public static int [][] setMatrixZeroes(int [][] matriz){
        //creamos la matriz de salida.
		int [][] newMatriz = new int[matriz.length][matriz[0].length];
		
		//copiamos matriz "vieja" a la nueva.
		for (int x=0; x < newMatriz.length; x++) {
		  for (int y=0; y < newMatriz[x].length; y++) {
		    newMatriz[x][y] = matriz[x][y];
		  }
		}
		
		//cambiamos fila y columna en '0' en newMatriz.
		for (int x=0; x < matriz.length; x++) {
		  for (int y=0; y < matriz[x].length; y++) {
		    if (matriz[x][y] == 0){
		    	//seteamos fila 'x' de newMatriz en '0'.
				for (int f=0; f < matriz.length; f++) {
				  newMatriz[f][y]=0;
				}
		    	//seteamos columna 'y' de newMatriz en '0'.
				for (int c=0; c < matriz[0].length; c++) {
				  newMatriz[x][c]=0;
				}
		    }
		  }
		}
		return newMatriz;
	}
	
}