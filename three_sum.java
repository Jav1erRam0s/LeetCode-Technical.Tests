package Main;

import java.util.*;

public class three_sum {

	public static void main(String[] args) {
		/*
		Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
		such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
		Notice that the solution set must not contain duplicate triplets.
		
		Example 1:
		Input: nums = [-1,0,1,2,-1,-4]
		Output: [[-1,-1,2],[-1,0,1]]
		Explanation: 
		nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
		nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
		nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
		The distinct triplets are [-1,0,1] and [-1,-1,2].
		Notice that the order of the output and the order of the triplets does not matter.
		
		Example 2:
		Input: nums = [0,1,1]
		Output: []
		Explanation: The only possible triplet does not sum up to 0.
		
		Example 3:
		Input: nums = [0,0,0]
		Output: [[0,0,0]]
		Explanation: The only possible triplet sums up to 0.

		Constraints:
	    3 <= nums.length <= 3000
	    -105 <= nums[i] <= 105
		*/

		int[] input = new int[] { -1, 0, 1, 2, -1, -4 };

		System.out.println("- RESOLUCION -");
		List<List<Integer>> sol = threeSum(input);
		for(List<Integer> list: sol){
			System.out.println(list.toString());
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		for(int a=0; a<nums.length-2; a++){
			for(int b=a+1; b<nums.length-1; b++){
				for(int c=b+1; c<nums.length; c++){
					if(nums[a]+nums[b]+nums[c]==0){
						List<Integer> subSol = new ArrayList<Integer>();
						subSol.add(nums[a]); subSol.add(nums[b]); subSol.add(nums[c]);
						if(include(subSol, output)){
							output.add(subSol);							
						}
					}
				}	
			}
		}
		
		return output;
	}
	
	public static boolean include(List<Integer> listEvaluar, List<List<Integer>> output){
		for (List<Integer> list :output){
			//Evaluamos si listEvaluar "=" list;
			int cont = 0;
			for (int element: listEvaluar){
				if(!list.contains(element)){
					break;
				}else{
					cont++;
					if( cont==3 ){
						return false;
					}
				}
			}
		}
		return true;
	}
	
}