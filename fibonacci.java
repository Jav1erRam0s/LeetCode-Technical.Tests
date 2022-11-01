package Main;

public class fobonacci {

	public static void main(String[] args) {
	
		System.out.println("- *********************************** -");
		System.out.println("- Fibonacci sin recursion");
		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
		int n = 11;
		int num1 = 0;
		int num2 = 1;
		for(int i = 0; i < n; i++){
			int sum = i;
			if(i>=2){
				sum = num1 + num2;
				num1 = num2;
				num2 = sum;
			}
			System.out.print(sum);
			if(i != n-1) System.out.print(", ");
		}

		System.out.println();
		System.out.println("- *********************************** -");
		
		System.out.println("- Fibonacci con recursion");
		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
		int m = 11;
		for (int j = 0; j < m ; j++){
			System.out.print(fibonacci(j));
			if(j != m-1) System.out.print(", ");
		}
        
		System.out.println("- *********************************** -");
		
	}
	
	public static int fibonacci(int n){
		if( n == 0 ) return 0;
		if( n == 1 ) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}