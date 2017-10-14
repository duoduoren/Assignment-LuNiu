

public class Cookie extends DessertItem{
	int number;
	int pricePerDozen;
	
	public Cookie(String name, int number, int pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}	

	private void setNumber(int number) {
		this.number = number;
	}

	private void setPricePerDozen(int pricePerDozen) {
		this.pricePerDozen = pricePerDozen;
	}
	
	private int getNumber() {
		return number;
	}

	private int getPricePerDozen() {
		return pricePerDozen;
	}

	@Override
	public int getCost() {
		int cost = this.number * this.pricePerDozen / 12;
		return cost;
	}
	
	public String printUnit() {
		return this.number + " @ " + this.pricePerDozen/100.0; 
	}
	
	public String printName() {
		return this.name;
	}
}