import java.util.Date;
import java.util.UUID;

class Assignment2 {

	// 1. calculate employee salary
	public double employeeSalary(double hours) throws Exception {
		 double salary; 
		 
		 if (hours <= 36) {
			 return 15 * hours;
		 }
		 
		 salary = 15 * 36;
		 
		 if (hours <= 41) {
			 return salary + (hours - 36) * 15 * 1.5;
		 }
		 
		 salary += (41 - 36) * 15 * 1.5;
		 
		 if (hours <= 48) {
			 return salary + (hours- 41) * 15 * 2;
		 }
		 
		 throw new Exception("Working hours are not valid");
	}
	 
	// 2. add all the digits of an integer until it is single digit
	public int addDigits(int input) {
	    int sum = 0;
	    
	    String s = String.valueOf(input);
	    for (int i = 0; i < s.length(); i++) {
	        sum = sum + (s.charAt(i)-'0');
	    }
	 
	    if (sum < 10) {
	        return sum;
	    } else {
	        return addDigits(sum);
	    }
	}

	
	// 3. print all perfect numbers between 1 and n.
	public static void printPerfectNumbers(int n) {
		int sum = 0;
		for (int num = 1; num < n; num++) {
			for(int divisor = 1; divisor < n; divisor++) {
				if (num % divisor == 0) {
					sum = sum + divisor;
				}
				
				if (sum == num) {
					System.out.println(sum);
				}
			}
	    }
	}
	

	// 6. generates an isosceles right angled triangle made of asterisks.
	public void printIsoscelesTriangle(int n){
		if (n > 0) {
			System.out.println("*");
	}
	
	for (int i = 1; i < n ; i++) {
		System.out.print("*");
	for (int j = 0; j < i - 1; j++) {
		System.out.print(" ");
	}
	
	System.out.println("*");
	}
	
	if (n > 2) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
			}
		}
	}
}
