import java.util.*;

public class ordenamiento_de_listas {
    public static void main(String args[]) {

    	//Listas a ordenar
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(5);
        list1.add(10);
        list1.add(2);
        list1.add(7);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(6);
        list2.add(32);
        list2.add(15);
        list2.add(3);
        list2.add(15);

        //Proceso
        List<Integer> listOrdenada = ordenamientoDeListas(list1, list2);
        

        //Respuesta
        System.out.println(" - LISTA ORDENADA - ");
        System.out.println(listOrdenada.toString());

    }
    
    public static List<Integer> ordenamientoDeListas(List<Integer> list1, List<Integer> list2){
        List<Integer> newList = new ArrayList<Integer>();
        
        int menor = 0;
        int posicion = 0;

        List<Integer> listJoin = new ArrayList<Integer>();        
        listJoin.addAll(list1);
        listJoin.addAll(list2);

        while(!listJoin.isEmpty()){
        	//Inicializacion de lista.
        	if (!listJoin.isEmpty()){
        		posicion = 0;
        		menor = listJoin.get(posicion);
        	}
        	//Busqueda del menor numero en lista
        	for(int a=0; a < listJoin.size();a++){
                if (listJoin.get(a) <= menor){
                    menor = listJoin.get(a);
                    posicion = a;
                }
            }
        	//Agregar a nueva lista y remover de vieja.
        	newList.add(menor);
        	listJoin.remove(posicion);
        }
        
        return newList;
    }

}