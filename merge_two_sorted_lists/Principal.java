package Main;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		/*
		You are given the heads of two sorted linked lists list1 and list2.
		Merge the two lists in a one sorted list. The list should be made by splicing together 
		the nodes of the first two lists.
		Return the head of the merged linked list.
		*/
		ListNode list1 = new ListNode(1, new ListNode(7, new ListNode( 3 )));
		ListNode list2 = new ListNode(6, new ListNode(5, new ListNode( 4 ))); 
		ListNode output = mergeTwoSortedLists(list1, list2);

		System.out.println(" - SOLUCION - ");
		ListNode nodoActual = output;
		while( nodoActual != null ){
			System.out.print(nodoActual.val);
			nodoActual = nodoActual.next;
			if( nodoActual!=null ) System.out.print(", "); 
		}
	}

	public static ListNode mergeTwoSortedLists( ListNode list1, ListNode list2 ){
		ListNode output = new ListNode();
		List<Integer> values = new ArrayList<Integer>(); 
		// juntamos los valores
		ListNode nodoActual = list1;
		while( nodoActual != null ){
			values.add(nodoActual.val);
			nodoActual = nodoActual.next;
		}
		nodoActual = list2;
		while( nodoActual != null ){
			values.add(nodoActual.val);
			nodoActual = nodoActual.next;
		}
		// hacemos un ordenamiento ascendente.
		Collections.sort(values);
		// creamos una lista en base a lista values.
		nodoActual = output;
		for(int i = 0; i < values.size(); i++){
			nodoActual.val = values.get(i);
			if(i != values.size()-1 ){
				ListNode newNode = new ListNode();
				nodoActual.next = newNode;
				nodoActual = nodoActual.next;
			}
		}
		return output;
	}
	
}