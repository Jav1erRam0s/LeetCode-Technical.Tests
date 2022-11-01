package Main;

import java.util.*;

public class merge_k_sorted_lists {

	public static void main(String[] args) {
		/*
		You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
		Merge all the linked-lists into one sorted linked-list and return it.

		Example 1:
		Input: lists = [[1,4,5],[1,3,4],[2,6]]
		Output: [1,1,2,3,4,4,5,6]
		Explanation: The linked-lists are:
		[
		  1->4->5,
		  1->3->4,
		  2->6
		]
		merging them into one sorted list:
		1->1->2->3->4->4->5->6

		Example 2:
		Input: lists = []
		Output: []
		
		Example 3:
		Input: lists = [[]]
		Output: []
		*/
		
		ListNode list1 = new ListNode(2, new ListNode(3, new ListNode(1)));
		ListNode list2 = new ListNode(4, new ListNode(7, new ListNode(6)));
		ListNode list3 = new ListNode(5, new ListNode(8, new ListNode(9)));		
		ListNode[] lists = { list1, list2, list3 };

		System.out.println(" - SOLUCION - ");
		
		ListNode output = mergeKSortedLists(lists);
		ListNode nodoActual = output;
		while(nodoActual != null){
			System.out.print(nodoActual.val + ", ");
			nodoActual = nodoActual.next;
		}
	}

	public static ListNode mergeKSortedLists( ListNode[] lists ){
		ListNode output = new ListNode();
		List<Integer> listsValues = new ArrayList<Integer>();
		//recorremos cada lista de nuestra bolsa de listas y guardamos los valores en una lista de enteros.
		for(ListNode list : lists){
			ListNode nodoActual = list;
			while(nodoActual != null){
				listsValues.add(nodoActual.val);
				nodoActual = nodoActual.next;
			}
		}
		//ordenamos la lista de enteros
		Collections.sort(listsValues);
		//creamos una lista enlazada a partir de nuestra lista de enteros.
		ListNode nodoActual = output;
		for(int i = 0; i < listsValues.size(); i++){
			nodoActual.val = listsValues.get(i);
			if( i != listsValues.size() - 1 ){
				ListNode newNode = new ListNode();
				nodoActual.next = newNode;
				nodoActual = nodoActual.next;
			}
		}
		
		return output;
	}
	
}