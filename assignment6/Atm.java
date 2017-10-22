import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

class Transaction {
	public String transactionName;
	public double amount;
	Transaction(String transactionName, double amount) {
		this.transactionName = transactionName;
		this.amount = amount;
	}
	
	public String toString() {
		return this.transactionName + "-" + this.amount;
	}
}

class User {
	String name;
	int age;
	String address;
	String phoneNumber;
	UUID bankAccountNumber;
	double accountBalance;
	String password;
	List<Transaction> transactions;
	
	public User(String name, String password, int age, String address, String phoneNumber, UUID bankAccountNumber, double accountBalance) {
		this.name = name;
		this.password = password;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bankAccountNumber = bankAccountNumber;
		this.accountBalance = accountBalance;
		this.transactions = new ArrayList<Transaction>();
	}
}

public class Atm {
	double availableAmountInMachine;
	double transactionFee;
	HashMap<String, User> userData;
	User loggedInUser;
	
	public Atm(double availableAmountInMachine, double transactionFee) {
		this.availableAmountInMachine = availableAmountInMachine;
		this.userData = new HashMap<String, User>();
		this.transactionFee = transactionFee;
	}
	
	public void newUser(String username, String password, int age, String address, String phoneNumber, double accountBalance) {
		userData.put(username, new User(username, password, age, address, phoneNumber, UUID.randomUUID(), accountBalance));
	}
	
	public void login(String username, String password) {
		User user = userData.get(username);
		
		if (user != null && user.password.equals(password)) {
			this.loggedInUser = user;
			System.out.println("login succeed");
		} else {
			System.out.println("login failed");
		}
	}
	
	public void forgetPassword(String newPassword) {
		if (this.loggedInUser != null) {
			this.resetPassword(
					this.loggedInUser.name, 
					this.loggedInUser.age, 
					this.loggedInUser.phoneNumber, newPassword);
		} else {
			System.out.println("user not found");
		}
	}
	
	public void resetPassword(String username, int age, String phoneNumber, String newPassword) {
		User user = this.userData.get(username);
		if (user != null && user.age == age && user.phoneNumber == phoneNumber) {
			user.password = newPassword;
			System.out.println("new password set");
		} else {
			System.out.println("invalid user credential");
		}
	}
	
	public double checkAvailableBalance() {
		if (this.loggedInUser != null) {
			System.out.println("available balance: "+ this.loggedInUser.accountBalance);
			return this.loggedInUser.accountBalance;
		} else {
			return 0;
		}
	}
	
	public boolean withDrawal(double money) {
		if (this.loggedInUser != null) {
			if (this.loggedInUser.accountBalance + this.transactionFee < money) {
				System.out.println("No enough balance.");
				return false;
			} else if (this.availableAmountInMachine + this.transactionFee < money) {
				System.out.println("No enough balance.");
			} else if (money + this.transactionFee > this.loggedInUser.accountBalance) {
				System.out.println("No enough balance.");
			} else {
				System.out.println("Withdrawal amount: " + String.valueOf(money));
				this.loggedInUser.accountBalance = this.loggedInUser.accountBalance - money - this.transactionFee;
				this.loggedInUser.transactions.add(new Transaction("withdrawal", money));
				this.availableAmountInMachine = this.availableAmountInMachine - money + this.transactionFee;
				return true;
			}
		}
		
		return false;
	}
	
	public void deposit(double money) {
		if (this.loggedInUser != null) {
			this.loggedInUser.accountBalance = this.loggedInUser.accountBalance + money - this.transactionFee;
			this.loggedInUser.transactions.add(new Transaction("deposit", money));
			this.availableAmountInMachine =  this.availableAmountInMachine + money + this.transactionFee;
		} else {
			System.out.println("user not found");
		}
	}
	
	public List<Transaction> recentTransactions() {
		if (this.loggedInUser != null) {
			for (int i = 0; i< this.loggedInUser.transactions.size(); i++) {
				System.out.println(this.loggedInUser.transactions.get(i));
			}
			
			return this.loggedInUser.transactions;
		}
		
		return null;
	}
	
	public void changePassword(String newPassword) {
		if (this.loggedInUser != null) {
			this.loggedInUser.password = newPassword;
			System.out.println("password changed");
		}
	}
	
	public void exit() {
		this.loggedInUser = null;
	}
}
