package Main;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		/*
		Given the head of a linked list, remove the nth node from the end of the list and return its head.

		Example 1:
		Input: head = [1,2,3,4,5], n = 2
		Output: [1,2,3,5]
		
		Example 2:
		Input: head = [1], n = 1
		Output: []
		
		Example 3:
		Input: head = [1,2], n = 1
		Output: [1]
		*/

		ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		int n = 1;
		//imprimimos la nueva matriz
		ListNode siguiente = removeNthNodeFromEndOfList(input, n);
		
		while( siguiente != null ){
			System.out.print( siguiente.val );
			siguiente = siguiente.next;
			if( siguiente != null )	System.out.print( ", " );
		}
	}

	public static ListNode removeNthNodeFromEndOfList(ListNode head, int n){
		//cramos una lista de enteros (valores) recorriendo la lista enlazada
		List<Integer> values = new ArrayList<Integer>();
		ListNode siguiente = head;
		while( siguiente != null ){
			values.add( siguiente.val );
			siguiente = siguiente.next;
		}
		//eliminamos de la lista la posicion n final de la lista de enteros (valores)
		values.remove( values.size() - n );
		System.out.println(values.toString());
		//creamos la lista enlazada a partir de la lista de enteros (valores)
		ListNode nodoPuntero = new ListNode();
		ListNode output = nodoPuntero;
		for( int i=0; i < values.size(); i++ ){
			nodoPuntero.val = values.get(i);
			if( i != values.size() - 1 ){
				ListNode newNode = new ListNode();
				nodoPuntero.next = newNode;
				nodoPuntero = nodoPuntero.next;
			}
		}
		return output;
	}
	
}