package CES29.Q2;

public class Account {
	
	 private String accountNumber, firstName, lastName, password;
	 private double accountBalance;
	 private boolean logged;

	public Account(String accountNumber, String password, String firstName, String lastName) {
		this.accountNumber = accountNumber;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = 0.0;
		this.logged = false;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public String geAccountNumber() {
		return this.accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
