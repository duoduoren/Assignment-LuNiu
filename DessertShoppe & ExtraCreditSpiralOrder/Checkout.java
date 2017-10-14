

import java.util.ArrayList;
import java.util.Vector;

public class Checkout {
	
	ArrayList<DessertItem> dessertItems; 
	
	public Checkout() {
		this.dessertItems = new ArrayList<DessertItem>();
	}
	
	public int numberOfItems() {
		return this.dessertItems.size();
	}
	
	public void enterItem(DessertItem item) {
		this.dessertItems.add(item);
	}
	
	public void clear() {
		this.dessertItems.clear();
	}
	
	public int totalCost() {
		int totalCost = 0;
		
		for (DessertItem dessertItem : dessertItems) {
			totalCost += dessertItem.getCost();
		}
		
		return totalCost;
	}

	public int totalTax() {
		return (int) (this.totalCost() * DessertShoppe.taxRate);
	}
		
	private void appendSpaces(StringBuilder strToAppend, int countOfSpaces) {
		for (int count = 0; count < countOfSpaces; count++) {
			strToAppend.append(" ");
		}
	}
	
	public String toString(){
		StringBuilder title = new StringBuilder();
		StringBuilder divider = new StringBuilder();
		int spaces = (DessertShoppe.maxWidth - DessertShoppe.nameOfStore.length()) / 2;
		this.appendSpaces(title, spaces);
		this.appendSpaces(divider, spaces);
		title.append(DessertShoppe.nameOfStore);
		for (int i = 0; i < DessertShoppe.nameOfStore.length(); i++) {
			divider.append("-");
		}
		
		this.appendSpaces(title, spaces);
		this.appendSpaces(divider, spaces);
		
		String receipt = title.toString() + "\n";
		
		receipt += divider.toString() + "\n";
		
		for (DessertItem dessertItem : dessertItems) {
			if (!dessertItem.printUnit().isEmpty()) {
				receipt += dessertItem.printUnit() + "\n";
			}
			
			String name = dessertItem.getName();
			String price = DessertShoppe.cents2dollarsAndCents(dessertItem.getCost());
			int linesForName = name.length() % DessertShoppe.maxNameLength != 0
					? (name.length() / DessertShoppe.maxNameLength) + 1: name.length() / DessertShoppe.maxNameLength;
					
			for (int line = 0; line < linesForName - 1; line++) {
				receipt += name.substring(line * DessertShoppe.maxNameLength, line * DessertShoppe.maxNameLength + DessertShoppe.maxNameLength) + "\n";
			}
			
			StringBuilder lastLine = new StringBuilder();
			String nameInLastLine = name.substring((linesForName - 1) * DessertShoppe.maxNameLength, name.length());
			lastLine.append(nameInLastLine);
			int countOfSpaceToAppend = DessertShoppe.maxWidth - nameInLastLine.length() - price.length();
			this.appendSpaces(lastLine, countOfSpaceToAppend);
			lastLine.append(price);
			receipt += lastLine.toString() + "\n";
		}
		
		receipt += "\n";
		
		StringBuilder taxLine = new StringBuilder();
		taxLine.append("Tax");
		String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());
		this.appendSpaces(taxLine, DessertShoppe.maxWidth - taxLine.length() - tax.length());
		taxLine.append(tax);
		receipt += taxLine.toString() + "\n";

		StringBuilder priceLine = new StringBuilder();
		priceLine.append("Total Cost");
		String price = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());
		this.appendSpaces(priceLine, DessertShoppe.maxWidth - priceLine.length() - price.length());
		priceLine.append(price);
		receipt += priceLine.toString() + "\n";

		return receipt;		
	}	
}
