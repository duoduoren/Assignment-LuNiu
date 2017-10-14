public class DessertShoppe{
	public static double taxRate = 0.0654;
	public static String nameOfStore = "M & M Dessert Shoppe";
	public static int maxNameLength = 23;
	public static int maxWidth = 30;
	
	public static String cents2dollarsAndCents(int input) {
		double dollar = input / 100.00;
		return String.valueOf(dollar);
	}
}

