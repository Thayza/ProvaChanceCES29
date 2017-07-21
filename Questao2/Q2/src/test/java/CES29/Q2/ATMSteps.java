package CES29.Q2;

import cucumber.api.PendingException;
import static org.junit.Assert.*;

import org.junit.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ATMSteps {
	
	ATM atm = new ATM();
	boolean logged = false;
	boolean created = false;
	double balance = 0.0;

	@Given("^User is on running Application$")
	public void user_is_on_running_Application(){
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		logged = atm.Login("1", "forte");
	}
	
	@When("^User chooses login option with valid AccountNumber and Password$")
	public void user_chooses_login_option_with_valid_AccountNumber_and_Password(){
		logged = atm.Login("1", "forte");
	}
	
	@Then("^the System must not log the user again$")
	public void the_System_must_not_log_the_user_again(){
		assertTrue(logged);
	}
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page(){
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
	}
	
	@When("^User chooses Login option with valid AccountNumber and Password$")
	public void user_chooses_Login_option_with_valid_AccountNumber_and_Password(){
		logged = atm.Login("1", "forte");
	}
	
	@Then("^the System must show chance the status of logged of the account$")
	public void the_System_must_show_chance_the_status_of_logged_of_the_account() {
		assertTrue(atm.checkLogin("1"));
		
	}
	
	@When("^User chooses CreateAccount option with a weak password$")
	public void user_chooses_CreateAccount_option_with_a_weak_password(){
		created = atm.createAccount("1", "fraco" , "Thayza", "Tabisz");
	}
	
	@Then("^the System must not create the account$")
	public void the_System_must_not_create_the_account(){
		assertFalse(created);
	}
	
	@Given("^User is on a Session of the Application$")
	public void user_is_on_a_Session_of_the_Application(){
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		logged = atm.Login("1", "forte");
		atm.deposit("1", 100.00);
	}
	
	@When("^User Choose CheekBalance Option$")
	public void user_Choose_CheekBalance_Option(){
		balance = atm.CheckBalance("1");
	}
	
	@Then("^the System must show the Balance$")
	public void the_System_must_show_the_Balance(){
		double balance = atm.CheckBalance("1");
		assertEquals(100, balance, 0.01);
	}
	
	@When("^User choose Deposit Option with valid Number of Account and the Amount$")
	public void user_choose_Deposit_Option_with_valid_Number_of_Account_and_the_Amount() {
		balance = atm.deposit("1", 130.00);
	}
	
	@Then("^System must update the balance of the account$")
	public void system_must_update_the_balance_of_the_account(){
		assertEquals(130, balance, 0.01);
	}
	
	@When("^User Choose Payment Option with valid AccountNumber and Password and bar code$")
	public void user_Choose_Payment_Option_with_valid_AccountNumber_and_Password_and_bar_code(){
	}
	
	@Then("^System must make the payment$")
	public void system_must_make_the_payment(){
	
	}
	
	@When("^User chooses CreateAccount option$")
	public void user_chooses_CreateAccount_option(){
		created = atm.createAccount("1", "forte" , "Thayza", "Tabisz");
	}
	
	@Then("^the System must add an account to his DB$")
	public void the_System_must_add_an_account_to_his_DB(){
		assertTrue(created);
	}
}
