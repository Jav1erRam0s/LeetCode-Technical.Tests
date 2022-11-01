package Main;

import java.util.*;

public class median_of_two_sorted_arrays {

	public static void main(String[] args) {
		/*
		Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
		The overall run time complexity should be O(log (m+n)).

		Example 1:
		Input: nums1 = [1,3], nums2 = [2]
		Output: 2.00000
		Explanation: merged array = [1,2,3] and median is 2.

		Example 2:
		Input: nums1 = [1,2], nums2 = [3,4]
		Output: 2.50000
		Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

		Constraints:
	    nums1.length == m
	    nums2.length == n
	    0 <= m <= 1000
	    0 <= n <= 1000
	    1 <= m + n <= 2000
	    -106 <= nums1[i], nums2[i] <= 106
		*/

		int[] list1 = new int[] {1,3,5};
		int[] list2 = new int[] {2,4};

		double output = medianOfTwoSortedArrays(list1, list2);

		//imprimimos la solucion
		System.out.println("- RESOLUCION -");
		System.out.print("Media : " + output);
	}
	
	public static double medianOfTwoSortedArrays(int[] list1, int[] list2){
		//Unimos las dos lista en una sola
		List<Integer> list = new ArrayList<Integer>();
		for(int num : list1){
			list.add(num);
		}
		for(int num : list2){
			list.add(num);
		}
		List<Integer> listOrdenada = new ArrayList<Integer>();
		while( !list.isEmpty() ){
			int menor = list.get(0);
			int positionMenor = 0;
			for (int i=0; i<list.size(); i++){
				if(list.get(i)<=menor){
					menor = list.get(i);
					positionMenor = i;
				}
			}
			listOrdenada.add(menor);
			list.remove(positionMenor);
		}
		System.out.println("Lista ordenada : " + listOrdenada.toString());
		listOrdenada.remove(0);
		listOrdenada.remove(listOrdenada.size()-1);	
		if(listOrdenada.size()>=2){
			int sum = 0;
			for(int num : listOrdenada){
				sum = sum + num;
			}
			return (double)sum/2;
		}else{
			return listOrdenada.get(0);
		}
	}
	
}