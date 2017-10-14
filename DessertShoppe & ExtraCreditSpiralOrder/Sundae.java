

public class Sundae extends IceCream{
	String topping;
	int toppingCost;
	
	public Sundae( String name, int cost, String topping, int toppingCost) {
		super(name, cost);
		this.topping = topping;
		this.toppingCost = toppingCost;
	}
	
	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public void setToppingCost(int toppingCost) {
		this.toppingCost = toppingCost;
	}
	
	public int getToppingCost() {
		return this.toppingCost;
	}
	
	@Override		
	public int getCost() {
		return this.cost + this.toppingCost;
	}
	
	@Override
	public String printUnit() {
		return this.topping + " Sundae with ";
	}
	
	@Override
	public String printName() {
		return this.name;
	}
}
