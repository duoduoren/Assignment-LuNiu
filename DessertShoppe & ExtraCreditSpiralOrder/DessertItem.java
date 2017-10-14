

public abstract class DessertItem {
	
	protected String name;
	
	public DessertItem(String name) {
		this.name = name;
	}
	
	public final String getName() {
		return this.name;
	}

	public abstract int getCost();
	
	public abstract String printUnit();
	
	public abstract String printName();
}	
