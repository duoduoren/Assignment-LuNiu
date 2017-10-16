/* Awesome work
 * Score 9.5 + extra credit 2; Total score 10
 */ 
import java.util.Scanner;

public class Assignment3 {

	//1. 
	public class Book { // score 1
	    int size;
	    int price;
	    String name;
	   
	    public Book(int size, int price) {
	        this.size = size;
	        this.price = price;
	    }      
	    
	    Book(int size, int price, String name) {
	        this.size = size;
	        this.price = price;
	        this.name = name;
		}
	    
	    public String getName() {
	        return name;
	    } 
	    
	    public void setName(String name) {
	    		this.name = name;
	    }
	} 
	
	/* 
	 * get method is to return the value what it is supposed to get, while set method is to set the value,
	 * no return needed.
	 * 
	 * book does not have superclass; // superClass is Object class for every class in java
	 * duplicate constructor is not allowed;
	 */

	//2.
	class Clock { // score 1
	    String time;
	    
	    public String getTime() {
	        return this.time;
	    }
	    
	    public void setTime(String t) {
	        this.time = t ;
	    } 
	}
	/*
	 * return type does not match;
	 * mark getters and setters public for access control;
	 * this keyword for reference is missing;
	*/

	//3.
	public String removeVowelsFromString(String input) { // good, score 2
		
		return input.replaceAll("[aeiouAEIOU]", "");
	}

	//4.
	private boolean checkIfTwoStringsareAnagrams(String s1, String s2) { // score 1.5, good but you have to consider
		if (s1.length() != s2.length()) {	// spaces and extra credits
			return false;
		}
		
		int [] frequencies = new int [26];
		
		for(int i = 0; i < s1.length(); i++) {
			frequencies[s1.charAt(i)-'a']++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			if (frequencies[s2.charAt(i) - 'a'] == 0) {
				return false;
			}
			
			frequencies[s2.charAt(i) - 'a']--;
		}
		
		return true;
	}
	
	//5.
	public static double add(double x, double y) { // score 4 + extra credit 2
		double result = x + y;
		return result;
	}
	public static double sub(double x, double y) {
		double result = x - y;
		return result;
	}
	
	public static double mul(double x, double y) {
		double result = x * y;
		return result;
	}
	
	public static double div(double x, double y) {
		double result = x / y;
		return result;
	}
	
	public static double sqrt(double x) {
		return Math.sqrt(x);
	}
	
	public static double square(double x) {
		double result = x * x;
		return result;
	}
	public static double cube(double x) {
		double result = x * x * x;
		return result;
	}
	
	public static double fahrenheitToCelsius(double f) {
		return (f - 32) * 5/9;
	}
	
	public static double celsiusToFahrenheit(double c) {
		return c * 9/5 + 32;
	}
	
	public static double feetToInches(double f) {
		return f * 12;
	}
	
	public static double inchesToFeet(double i) {
		return i / 12;
	}

	public static void calculator(String[] args) {
		System.out.println("Enter the number");
		Scanner in = new Scanner(System.in);
		
		double num1, num2;
		num1 = in.nextDouble();
		num2 = in.nextDouble();
		System.out.println("Enter your operation: "
				+ "1 for Addition, "
				+ "2 for Subtraction, "
				+ "3 for Multiplication, "
				+ "4 for Division, "
				+ "5 for SquareRoot,"
				+ "6 for Squre, "
				+ "7 for Cube, "
				+ "8 for FahrenheitToCelsius, "
				+ "9 for CelsiusToFahrenheit, "
				+ "10 for FeetToInches, "
				+ "11 for InchesToFeet, ");
		int choose;
		choose = in.nextInt();
		switch(choose) {
			case 1:
				System.out.println(add(num1, num2));
				break;
			case 2:
				System.out.println(sub(num1, num2));
				break;
			case 3:
				System.out.println(mul(num1, num2));
				break;	
			case 4:
				System.out.println(div(num1, num2));
				break;	
			case 5:
				System.out.println(sqrt(num1));
				break;	
			case 6:
				System.out.println(square(num1));
				break;		
			case 7:
				System.out.println(cube(num1));
				break;	
			case 8:
				System.out.println(fahrenheitToCelsius(num1));
				break;	
			case 9:
				System.out.println(celsiusToFahrenheit(num1));
				break;	
			case 10:
				System.out.println(feetToInches(num1));
				break;	
			case 11:
				System.out.println(inchesToFeet(num1));
				break;	
			default:
				System.out.println("Illegal Operation");
		}
	}
	
	//5 Extra
	public static void quadraticCalculator() { // extra credit 2
		System.out.println("Enter the number");
		Scanner in = new Scanner(System.in);
		
		double A, B, C;
		A = in.nextDouble();
		B = in.nextDouble();
		C = in.nextDouble();
		double[] res;
		try {
			res = quadraticEquation(A, B, C);
			System.out.println(
					String.format("res: x1 = {0}, x2 = {1}",String.valueOf(res[0]), String.valueOf(res[1])));
			in.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			in.close();
		}	
	}
	
	public static double[] quadraticEquation(double a, double b, double c) throws Exception {
		double x1 = (-b + Math.sqrt(b * b- 4 * a * c))/2*a;
		double x2 = (-b - Math.sqrt(b * b- 4 * a * c))/2*a;
		if ((b * b - 4 * a * c) < 0) {	// check this statement first
			throw new Exception("No Result");
		}
		
		return new double[] {x1, x2};
	}
}
