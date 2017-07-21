Feature: ATM

 Scenario: Start Multiple Sessions
 	As a Bank Manager 
	In order to synchronize the update of an account
	I want the customer have just one session of the application
   
    Given User is on running Application
    When User chooses login option with valid AccountNumber and Password
    Then the System must not log the user again

 
 Scenario: Start one Session
 	As a User
	In order to access my account
	I want start a session of the application
	
    Given User is on Home Page
    When User chooses Login option with valid AccountNumber and Password
    Then the System must show chance the status of logged of the account
 
 Scenario: Register a Strong Password
 	As a Bank Manager
	In order ensure more security for the customer
	I want the customer have to register a Strong Password for a new account
 
    Given User is on Home Page
    When User chooses CreateAccount option with a weak password
    Then the System must not create the account 
 
Scenario: Consult Balance Transaction
	As a User
	In order to know the balance of my account
	I want to see the balance

    Given User is on a Session of the Application
    When User Choose CheekBalance Option
    Then the System must show the Balance

 Scenario: Deposit Transaction
 	As a User
	In order to keep my money on the bank
	I want to deposit money on the ATM
	
    Given User is on Home Page
    When User choose Deposit Option with valid Number of Account and the Amount 
    Then System must update the balance of the account

 Scenario: Payment Transaction
 	As a User
	In order to avoid lines on the bank
	I want to bay my bills on the ATM
 
    Given User is on Home Page
    When User Choose Payment Option with valid AccountNumber and Password and bar code
    Then System must make the payment
 
 Scenario: Create Account
	As a User
	In order to make my daily financial transaction easier
	I want create an Account on the ATM
	
    Given User is on Home Page
    When User chooses CreateAccount option
    Then the System must add an account to his DB

 