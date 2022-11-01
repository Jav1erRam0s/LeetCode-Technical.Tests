package Main;

public class logger_rate_limiter {

	public static void main(String[] args) {
		
		/*
		Diseñe un sistema de registro que reciba un flujo de mensajes junto con sus marcas de tiempo, 
		cada mensaje debe imprimirse si y solo si no se imprime en los últimos 10 segundos.
		Dado un mensaje y una marca de tiempo (en segundos de granularidad), devuelve verdadero si el 
		mensaje debe imprimirse en la marca de tiempo dada; de lo contrario, devuelve falso.
		Es posible que varios mensajes lleguen más o menos al mismo tiempo.
		*/
		
		Logger logger = new Logger();

		// logging string "foo" at timestamp 1
		System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true; 
		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;
		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;
		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;
		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;
		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
		
	}

}

//--------------------------------------------------------------------------------------------------------------------

package Main;

import java.util.*;

class Logger {
	  
	HashMap<String, Integer> hash;
  
	/** Initialize your data structure here. */
	public Logger() {
		hash = new HashMap<String, Integer>();
	}
  
	/*Returns true if the message should be printed in the given timestamp, otherwise returns false.
	If this method returns false, the message will not be printed.
	The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		Integer prevTime = hash.get(message);
		if(prevTime == null || (timestamp - prevTime >= 10) )
		{
			hash.put(message, timestamp);
			return true;
		}
		return false;
	}

}

//--------------------------------------------------------------------------------------------------------------------