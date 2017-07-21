package CES29.Q3;

import junit.framework.TestCase;

public class Tests extends TestCase {

	Matematica matematica = new Matematica();  
	  
    public void testFibonacciZero() {  
        verificaFibonacci(0, 0);  
    }  
      
    public void testFibonacciUm() {  
        verificaFibonacci(1, 1);  
    }  
      
    public void testFibonacciDois() {  
        verificaFibonacci(1, 2);  
    }  
      
    public void testFibonacciTres() {  
        verificaFibonacci(2, 3);  
    }  
      
    public void testFibonacciQuatro() {  
        verificaFibonacci(3, 4);  
    }  
      
    public void testFibonacciCinco() {  
        verificaFibonacci(5, 5);  
    }  
      
    public void testFibonacciSeis() {  
        verificaFibonacci(8, 6);  
    }  
      
    public void testFibonacciParaNumeroInvalido() {  
        try {  
            matematica.fibonacci(-1);  
            fail("Deveria ter lançado IllegalArgumentException");  
        } catch (IllegalArgumentException e) {  
            assertTrue(true);  
        }  
    }  
      
    private void verificaFibonacci(int resultadoEsperado, int valor) {  
        assertEquals(resultadoEsperado, matematica.fibonacci(valor));  
    }  
	
}
