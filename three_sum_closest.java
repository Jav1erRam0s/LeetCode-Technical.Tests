package Main;

public class three_sum_closest {

	public static void main(String[] args) {
		/*
		Given an integer array nums of length n and an integer target, find three integers in nums such
		that the sum is closest to target.
		
		Return the sum of the three integers.
		You may assume that each input would have exactly one solution.
		
		Example 1:
		Input: nums = [-1,2,1,-4], target = 1
		Output: 2
		Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
		
		Example 2:
		Input: nums = [0,0,0], target = 1
		Output: 0
		Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

		Constraints:
	    3 <= nums.length <= 500
	    -1000 <= nums[i] <= 1000
	    -104 <= target <= 104
		*/

		int[] input = new int[] { -1, 2, 1, -4 };
		int target = 1;
		System.out.println("- RESOLUCION -");
		
		System.out.println("Suma mas cercana : " + threeSumClosest(input, target));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		//Inicializamos las salidas, con el punto mas cercano y diff de base [0,1,2].
		int masCercano = nums[0] + nums[1] + nums[2];
		int diffAnterior = Math.abs( target - ( nums[0] + nums[1] + nums[2] ) );

		for (int a = 0; a < nums.length - 2; a++){
			for (int b = a + 1; b < nums.length - 1; b++){
				for (int c = b + 1; c < nums.length; c++){
					int sum = nums[a] + nums[b] + nums[c];
					int diff = Math.abs( target - sum );
					if(diff<diffAnterior){
						diffAnterior = diff;
						masCercano = sum;
					};
				}
			}	
		}
		
		return masCercano;
	}
	
}