package Main;

import java.util.*;

public class four_sum {

	public static void main(String[] args) {
		/*
		Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], 
		nums[c], nums[d]] such that:

	    0 <= a, b, c, d < n
	    a, b, c, and d are distinct.
	    nums[a] + nums[b] + nums[c] + nums[d] == target

		You may return the answer in any order.

		Example 1:
		Input: nums = [1,0,-1,0,-2,2], target = 0
		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		
		Example 2:
		Input: nums = [2,2,2,2,2], target = 8
		Output: [[2,2,2,2]]
		*/

		//Example 1
		int[] nums = new int[]{ 1, 0, -1, 0, -2, 2 };
		int target = 0;
		//Example 2
		//int[] nums = new int[]{ 2, 2 , 2, 2, 2 };
		//int target = 8;
		List<List<Integer>> output = fourSum(nums, target);
		for(List<Integer> out : output){
			System.out.println(out.toString());
		}
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		//a, b, c y d son punteros que arman la combinacion con posiciones sin repetir
		for(int a = 0; a < nums.length-3; a++){
			for(int b = a + 1; b < nums.length-2; b++){
				for(int c = b + 1; c < nums.length-1; c++){
					for(int d = c + 1; d < nums.length; d++){
						int sum = nums[a] + nums[b] + nums[c] + nums[d];
						if( sum == target ){
							List<Integer> combinacion = new ArrayList<Integer>();
							combinacion.add( nums[a] );
							combinacion.add( nums[b] );
							combinacion.add( nums[c] );
							combinacion.add( nums[d] );
							if(combinacionExitente(combinacion, output)==false)	output.add(combinacion);
						}
					}	
				}	
			}	
		}
		return output;
	}

	public static boolean combinacionExitente( List<Integer> combinacion, List<List<Integer>> output){
		for(List<Integer> combinacionOut : output){
			for(int i = 0; i < combinacion.size(); i++){
				if( !combinacionOut.contains(combinacion.get(i)) && !combinacion.contains(combinacionOut.get(i)) ){
					break;
				}
				if(i == combinacion.size()-1){
					return true;
				}
			}
		}
		return false;
	}
	
}