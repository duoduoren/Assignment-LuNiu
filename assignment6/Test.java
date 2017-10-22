
public class Test {
	public static void main(String[] args) {
		Atm atm = new Atm(1000, 2);
		atm.newUser(
				"admin", 
				"secret", 
				30, 
				"2690 152nd Ave NE, Redmond, WA98074", 
				"7327890425", 
				100);
		
		// Verify user log in failed
		atm.login("admin", "wrong password");
		System.out.println(atm.loggedInUser == null);
		
		// Verify user log in succeed
		atm.login("admin", "secret");
		System.out.println(atm.loggedInUser != null);
		
		// Verify available balance  
		System.out.println(atm.checkAvailableBalance() == 100);
		
		atm.changePassword("newPassword");
		System.out.println(atm.loggedInUser.password.equals("newPassword"));
		
		atm.forgetPassword("secret");
		System.out.println(atm.loggedInUser.password.equals("secret"));
		
		// Verify reset password failed
		atm.resetPassword("admin", 29, "7327890425", "newPassword");
		System.out.println(atm.loggedInUser.password.equals("secret"));
		
		// Verify reset password succeed
		atm.resetPassword("admin", 30, "7327890425", "newPassword");
		System.out.println(atm.loggedInUser.password.equals("newPassword"));
		
		// Verify no recent transactions
		System.out.println(atm.recentTransactions().size() == 0);
		
		// Verify withdrawal failed due to not enough balance in user account;
		System.out.println(!atm.withDrawal(200));
		
		atm.loggedInUser.accountBalance = 1200;
		// Verify withdrawal failed due to not enough balance in ATM machine;
		System.out.println(!atm.withDrawal(1100));
		
		// Verify withdrawal succeed;
		atm.loggedInUser.accountBalance = 100;
		atm.withDrawal(98);
		System.out.println(atm.loggedInUser.accountBalance == 0);
		
		// Verify available balance decreased
		System.out.println(atm.availableAmountInMachine == 904);
		
		// Verify deposit succeed
		atm.deposit(100);
		System.out.println(atm.loggedInUser.accountBalance == 98);
		System.out.println(atm.availableAmountInMachine == 1006);
		
		// Verify transactions
		System.out.println(atm.recentTransactions().size() == 2);
	}
}
