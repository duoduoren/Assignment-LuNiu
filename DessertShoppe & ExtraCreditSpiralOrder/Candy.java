

public class Candy extends DessertItem{
	double weight;	// access should be private
	int pricePerPound;
	public Candy(String name, double weight, int pricePerPound) {
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setPricePerPound(int pricePerPound) {
		this.pricePerPound = pricePerPound;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getPricePerPound() {
		return pricePerPound;
	}
	
	@Override
	public int getCost() {
		int cost = (int) (Math.round(this.weight * this.pricePerPound));
		return cost;
	}

	@Override
	public String printUnit() {
		return this.weight + " lbs @ " + this.pricePerPound/100.0;
	}

	@Override
	public String printName() {
		return this.name;
	}
}

