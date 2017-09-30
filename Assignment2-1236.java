/* good work
 * score 7.5 + extra credit 2; Total score = 9.5
 */


import java.util.Date;
import java.util.UUID;

class Assignment2 {

	// 1. calculate employee salary
	// score 1.5
	public double employeeSalary(double hours) throws Exception { // for hours greater than 48, you should return pay of 48
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
	// score 2
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
	// score 0
	public static void printPerfectNumbers(int n) {
		int sum = 0;
		for (int num = 1; num < n; num++) {
			//int sum = 0; should be declared here
			for(int divisor = 1; divisor < n; divisor++) {
				if (num % divisor == 0) {
					sum = sum + divisor;
				}
				
				if (sum == num) { // this if block should be after this for loop
					System.out.println(sum);
				}
			}
			// here
	    }
	}
	

	// 6. generates an isosceles right angled triangle made of asterisks.
	// extra credit 1
	public void printIsoscelesTriangle(int n){
		if (n > 0) {
			System.out.println("*");
	}
	
	for (int i = 1; i < n ; i++) { // it should be for(int i = 1; i<n-1; i++) , because you are already printing 1 * before
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
