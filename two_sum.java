package Main;

import java.util.*;

public class two_sum {

	public static void main(String[] args) {
		/*
		...
		*/
		List<Integer> input = new ArrayList<Integer>();
		input.add(11);
		input.add(7);
		input.add(2);
		input.add(15);
		
		int target = 9;
		
		List<Integer> output = twoSum(input, target);

		//imprimimos la nueva matriz
		System.out.println("- RESOLUCION -");
		System.out.println(output.toString());
	}

	public static List<Integer> twoSum(List<Integer> input, int target){
		List<Integer> output = new ArrayList<Integer>();
		for(int i=0; i<input.size(); i++){
			for(int j=0; j<input.size(); j++){
				if(i!=j && target==input.get(i)+input.get(j)){
					output.add(i);
					output.add(j);
					i = j = input.size();
				}
			}	
		}
		return output;
	}
	
}