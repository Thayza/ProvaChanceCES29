package CES29.Q2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnitTests {
 
	ATM atm = new ATM();
	
	@Test
	public void criarContaSenhaInvalida() {
		boolean create = atm.createAccount("1", "fraco" , "Thayza", "Tabisz");
		assertFalse(create);
	}

	@Test
	public void criarContaSenhaValida() {
		boolean create = atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		assertTrue(create);
	}
	
	@Test
	public void unicoLogin() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		boolean alreadyLoged = atm.Login("1", "forte");
		boolean login = atm.checkLogin("1");
		assertTrue(login);
		assertFalse(alreadyLoged);
	}
	
	@Test
	public void multiplosLogins() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		atm.Login("1", "forte");
		boolean alreadyLoged = atm.Login("1", "forte");
		assertTrue(alreadyLoged);
	}
	
	@Test
	public void logout() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		atm.Login("1", "forte");
		atm.Logout("1");
		boolean loged = atm.checkLogin("1");
		assertFalse(loged);
	}
	
	@Test
	public void fazerDepositoSemTerConta() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		double balance = atm.deposit("1", 100.00);
		assertEquals(100, balance, 0.01);
	}
	
	@Test
	public void consultarSaldoEstandoLogado() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		atm.Login("1", "forte");
		atm.deposit("1", 100.00);
		atm.deposit("1", 30.00);
		double balance = atm.CheckBalance("1");
		assertEquals(130, balance, 0.01);
	}
	@Test
	public void consultarSaldoNaoEstandoLogado() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		atm.deposit("1", 100.00);
		atm.deposit("1", 30.00);
		double balance = atm.CheckBalance("1");
		assertEquals(Double.NaN, balance, 0.01);
	}
	
	@Test
	public void fazerpagamentoEstandoLogado() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		atm.Login("1", "forte");
		atm.payment("1", "11111", 30.00);
		double balance = atm.CheckBalance("1");
		assertEquals(-30, balance, 0.01);
	}
	
	@Test
	public void fazerpagamentoNaoEstandoLogado() {
		atm.createAccount("1", "forte" , "Thayza", "Tabisz");
		atm.payment("1", "11111", 30.00);
		double balance = atm.CheckBalance("1");
		assertEquals(Double.NaN, balance, 0.01);
	}
}
