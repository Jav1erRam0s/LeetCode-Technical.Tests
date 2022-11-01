package Main;

public class Principal {

	public static void main(String[] args) {
		/*
		You are given two non-empty linked lists representing two non-negative integers.
		The digits are stored in reverse order, and each of their nodes contains a single digit.
		Add the two numbers and return the sum as a linked list.
		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
		
		Example 1:
		Input: l1 = [2,4,3], l2 = [5,6,4]
		Output: [7,0,8]
		Explanation: 342 + 465 = 807.
		
		Example 2:
		Input: l1 = [0], l2 = [0]
		Output: [0]
		
		Example 3:
		Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		Output: [8,9,9,9,0,0,0,1]
		*/

		ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4)));
				
		ListNode output = addTwoNumber(list1, list2);

		//imprimimos la nueva matriz
		System.out.println("- RESOLUCION -");
		boolean seguir = true;
		ListNode nodoActual = output;
		ListNode nodoPosterior = nodoActual.next;
		while (seguir){
			if(nodoPosterior==null){				
				seguir=false;
			}
			System.out.print(nodoActual.val);
			if(seguir) System.out.print(",");
			nodoActual = nodoPosterior;
			try { nodoPosterior = nodoActual.next; }
			catch(Exception e) { nodoPosterior = null; }
		}
	}

	
	public static ListNode addTwoNumber(ListNode list1, ListNode list2){
		ListNode output = new ListNode();
		
		boolean seguir = true;
		ListNode nodoActual = list1;
		ListNode nodoPosterior = nodoActual.next;
		String list1Numbers = "";
		//Recorremos lista 1
		while (seguir){
			if(nodoPosterior==null){				
				seguir=false;
			}
			list1Numbers = list1Numbers + nodoActual.val;
			nodoActual = nodoPosterior;
			try { nodoPosterior = nodoActual.next; }
			catch(Exception e) { nodoPosterior = null; }
		}
		//Iniccializamos las variables
		seguir = true;
		nodoActual = list2;
		nodoPosterior = nodoActual.next;
		String list2Numbers = "";
		//Recorremos lista 2
		while (seguir){
			if(nodoPosterior==null){				
				seguir=false;
			}
			list2Numbers = list2Numbers + nodoActual.val;
			nodoActual = nodoPosterior;
			try { nodoPosterior = nodoActual.next; }
			catch(Exception e) { nodoPosterior = null; }
		}
		// Revertir lista1
		String list1Revert = "";
		for (int i=0; i<list1Numbers.length(); i++)
		{
			list1Revert = list1Numbers.charAt(i) + list1Revert;
		}
		String list2Revert = "";
		for (int i=0; i<list2Numbers.length(); i++)
		{
			list2Revert = list2Numbers.charAt(i) + list2Revert;
		}
		int list1IntRevert = Integer.valueOf(list1Revert);
		int list2IntRevert = Integer.valueOf(list2Revert);
		int sumList12 = list1IntRevert + list2IntRevert;
		String listOutput =  String.valueOf(sumList12);
		
		ListNode actual = output;
		for (int i=0; i<listOutput.length(); i++)
		{
			actual.val = Character.getNumericValue(listOutput.charAt(i));
			if(i!=listOutput.length()-1){
				actual.next = new ListNode();
				actual = actual.next;
			}
		}
		return output;
	}
	
}