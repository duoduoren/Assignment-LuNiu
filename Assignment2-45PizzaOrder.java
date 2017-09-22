import java.util.Date;
import java.util.UUID;

//4. pizza
class Pizza {
	String pizzaType;
	double unitPrice;
	int loyaltyPoints; 
	String pizzaSize;
	String[] topping;
	
	Pizza(double unitPrice, String[] topping, String pizzaType, int loyaltyPoints, String pizzaSize) {
		this.topping = topping;
		this.pizzaType = pizzaType;
		this.pizzaSize = pizzaSize;
		this.unitPrice = unitPrice;
		this.loyaltyPoints = loyaltyPoints;
	}
}

class Customer {
	String name;	
	
	Customer(String name) {
		this.name = name;
	}
}

class Order {
	UUID orderId;
	Date createdAt;
	Date updatedAt;
	Pizza[] pizzas;
	OrderStatus status;
	Customer customer;
	
	Order(Customer customer, Pizza[] pizzas) {
		this.pizzas = pizzas;
		this.customer = customer;
		this.createdAt = new Date();
		this.updatedAt = new Date();
		this.orderId = UUID.randomUUID();
		this.status = OrderStatus.IN_PROGRESS;
	}
	
	public void markOrderComplete() {
		this.status = OrderStatus.COMPLETE;
		this.updatedAt = new Date();
	}
	
	public double totalPrice() {
		double sum = 0;
		for (int i = 0; i < this.pizzas.length; i++) {
			sum += this.pizzas[i].unitPrice;
		}
		
		return sum;
	}
}

enum OrderStatus {
	IN_PROGRESS,
	COMPLETE
}

public class PizzaOrder {

	
	//5. customer
	public static void main(String[] args) {
		Pizza[] pizzas = loadsAllPizzas();
		Customer newCustomer = new Customer("Lu Niu");
		Order order = new Order(newCustomer, pizzas);
		System.out.print(order.totalPrice());
	}
	
	public static Pizza[] loadsAllPizzas() {
		return new Pizza[] {
			new Pizza(11.0, new String[] {"bacon", "sausage", "mushroom"}, "Regular", 11, "Big"),
			new Pizza(6.0, new String[] {"tomato", "spinach", "pineapple"}, "Wheat", 6, "Small")
		};
	}	
}
