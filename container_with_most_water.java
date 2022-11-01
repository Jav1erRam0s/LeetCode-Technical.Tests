package Main;

import java.util.*;

public class container_with_most_water {

	public static void main(String[] args) {
		/*
		You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
		Find two lines that together with the x-axis form a container, such that the container contains the most water.
		Return the maximum amount of water a container can store.
		Notice that you may not slant the container.

		Example 1:
		Input: height = [1,8,6,2,5,4,8,3,7]
		Output: 49
		Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

		Example 2:
		Input: height = [1,1]
		Output: 1
		
		Constraints:
	    n == height.length
	    2 <= n <= 105
	    0 <= height[i] <= 104
		*/

		int[] height = new int[] {1,8,6,2,5,4,8,3,7};

		int output = containerWithMostWater(height);

		//imprimimos la solucion
		System.out.println("- RESOLUCION -");
		System.out.print("Area (m2) mas grande : " + output);
	}
	
	public static int containerWithMostWater(int[] height)	{
		//calculamos todas las medidas/areas del tanque.
		List<Integer> areas = new ArrayList<Integer>(); 
		for(int i=0; i<height.length; i++){
			for(int j=i+1; j<height.length; j++){
				if(height[i]<=height[j]){
					areas.add(height[i] * (j-i));
				}else{
					areas.add(height[j] * (j-i));
				}
			}
		}
		//buscamos el area mayor de nuestra lista
		int areaMayor = 0;
		for(int area : areas){
			if(area > areaMayor){
				areaMayor=area;	
			}
		}
		return areaMayor;
	}
	
}