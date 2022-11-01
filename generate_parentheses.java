package Main;

import java.util.*;

public class generate_parentheses {

	public static void main(String[] args) {
		
		/*
		Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

		Example 1:
		Input: n = 3
		Output: ["((()))","(()())","(())()","()(())","()()()"]

		Example 2:

		Input: n = 1
		Output: ["()"]
		*/
		
		int pairsParentheses = 4;
		List<String> output = generatorParentheses(pairsParentheses);
		System.out.println("- RESOLUCION -");
		System.out.println(output.toString());
		
	}

	public static List<String> generatorParentheses(int pairsParentheses){
		List<String> combinaciones = new ArrayList<String>();
		String base = "";
		String fin = "";
		int espacios = 0;
		boolean onion = true;
		if (pairsParentheses==1) {
			combinaciones.add("()");
			return combinaciones;
		}
		if (pairsParentheses>=2) {
			espacios = pairsParentheses*2 - 2 + 1;
			for (int x = 1; x <= pairsParentheses; x++){
				fin = fin + "()";
				base = "(" + base + ")";
			}
		}
		
		combinaciones.add(base);
		
		while (onion){
			//buscar la ultima capa de la cebolla de parentesis.
			int positionInit = base.lastIndexOf("((")+1;
			int positionEnd = positionInit + 1;

			//cortamos y creamos nuestra nueva base.
			base = base.substring(0,positionInit) + base.substring(positionEnd+1);

			String combinacionBase = base;
			String combinacion = "";
			//recorremos el "()" sobre la nueva base.
			for (int i = 0; i < espacios; i++){

				if(i!=espacios){
					combinacion = combinacionBase.substring(0,i) + "()" + combinacionBase.substring(i);
				}
				else if( i==espacios-1 ){
					combinacion = combinacion + "()";
				}

				
				if(!combinaciones.contains(combinacion) && !combinacion.equals(fin)){
					combinaciones.add(combinacion);
				}
						
				if(combinacion.equals(fin) && i==espacios-1){
					combinaciones.add(fin);
					onion = false;
				}
				if(!combinacion.equals(fin) && i==espacios-1){
					base = combinacion;
				}
			}
		}
		return combinaciones;
	}
	
}