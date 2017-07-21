package CES29.Q2;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private List<Account> accountList = new ArrayList();
    private boolean loged = false;
    
    public boolean createAccount(String accountNumber, String password, String firstName, String lastName){
    	boolean created = false;
    	if(password.equals("fraco")){
    		System.out.println("Senha precisa ter mais que 8 caracteres com numeros, letras e caractere especial");	
    	} else{
    		Account account = new Account(accountNumber, password, firstName, lastName );
        	accountList.add(account);
        	created = true;
    	}
    	return created;
    }
    
    public double deposit (String accountNumber, double amount)
    {
    	Double newBalance = null;
    	Account account = findAccount(accountNumber);
    	if(account != null){
    		newBalance = account.getAccountBalance() + amount;
    	    account.setAccountBalance(newBalance);
    	}
    	return newBalance;
    }

    public double payment (String accountNumber, String codeBar, Double amount)
    {
    	double newBalance = Double.NaN;
    	Account account = findAccount(accountNumber);
    	if(account != null && account.isLogged()){
    		newBalance = account.getAccountBalance() - amount;
    	    account.setAccountBalance(newBalance);
    	}
    	return newBalance;
    }
    
    public double CheckBalance(String accountNumber){
    	Account account= findAccount(accountNumber);
    	double balance = Double.NaN;
    	if(account != null && account.isLogged()){
    		balance = account.getAccountBalance();
    	}
    	return balance;
    }
    
    public boolean Login(String accountNumber, String password){
    	Account account = null;
    	boolean alreadyLogged = false;
    	account = findAccount(accountNumber);
    	if(account != null){
    		if(checkPassword( accountNumber, password)){
		    	if(account.isLogged()){
		    		alreadyLogged = true;
		    	} else{
		    		account.setLogged(true);
		    	}
    		}
    	}
    	return alreadyLogged;
    }
    
     public void Logout(String accountNumber){
    	 Account account= findAccount(accountNumber);
    	 account.setLogged(false);
     }
    
     public boolean checkLogin (String accountNumber){
    	 Account account= findAccount(accountNumber);
    	 return account.isLogged();
     }
     
    private boolean checkPassword(String accountNumber, String password) {
    	boolean passwordOk = true;
    	Account account = findAccount(accountNumber);
    	if (!account.getPassword().equals(password)) {
    		passwordOk = false;
    	 } 
    	return passwordOk;
	}

	private Account findAccount(String accountNumber) {
    	Account account = null;
    	boolean find = false;
    	for(int i =0; i < accountList.size() && find == false; i++){
    		if(accountList.get(i).geAccountNumber().equals(accountNumber)){
    			find = true;
    			account = accountList.get(i);
    		}
    	}
		return account;  
	}

   
}
