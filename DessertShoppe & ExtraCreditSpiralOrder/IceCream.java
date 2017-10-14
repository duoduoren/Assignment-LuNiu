

public class IceCream extends DessertItem{
	int cost;
	
	public IceCream(String name, int cost) {
		super(name);
		this.cost = cost;
	}
		
	private void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public String printUnit() {
		return "";
	}

	@Override
	public String printName() {
		return this.name;
	}
}
