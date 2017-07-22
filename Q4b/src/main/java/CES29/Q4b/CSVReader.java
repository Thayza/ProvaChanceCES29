package CES29.Q4b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CSVReader {
	// change array size
	public static Object changeArraySize(Object obj, int len) {
		Class<?> arr = obj.getClass().getComponentType();
		Object newArray = Array.newInstance(arr, len);
 
		//do array copy
		int co = Array.getLength(obj);
		System.arraycopy(obj, 0, newArray, 0, co);
		return newArray;
	}
	
	public static void main(String[] args) throws Exception {

        String csvFile = "entrada.txt";
        String line = "";
        String cvsSplitBy = ",";
        int i = 0;     // realocado para imprimir
        User[] users = new User[10];
        BufferedReader br = null;
		FileReader fr = null;
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");   //padronizar nome do arquivo
		Matcher matcher = pattern.matcher(csvFile);
		
		if (matcher.find()){
			throw new Exception();
		}
		
        try  {
        	fr = new FileReader(csvFile);
        	br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {   
                // use comma as separator
	            	if (line != null) {                //garantir que a string não é vazia 
	            		if(line.contains(",")){                //ver se string tem separador
		            		String[] usersLine = line.split(cvsSplitBy);
		            		if(usersLine.length == 5){                      // garantir que o usuario possui todos os dados, ignora os qu não tem
		            			if(users.length == i) {  // se chegar ao limite aloca mais  10
		            				users = (User[]) changeArraySize(users, users.length + 10);
		            			}
		            			User user = new User((usersLine[0]), usersLine[1], usersLine[2], 
		    	                		usersLine[3], usersLine[4]);
		    	                users[i]=user;
		    	                i++;
		                    } else{
		    	            	System.out.printf("Dados incorretos do usuário %d!\n", i);
		    	            }
		            	} else {
		            	    throw new IllegalArgumentException("String " + line + " nao contem ,");
		            	}
	            	} 
            	
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {                              // fechar buffer e reader
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
        }
        print(users, i);
    } 
    
 // print
  	public static void print(User[] users, int size) {
  		for(int i=0; i<size; i++){
 			System.out.println("Usuario " + (i+1) + " = " + users[i].getNome() );
 		}
  	}
}
