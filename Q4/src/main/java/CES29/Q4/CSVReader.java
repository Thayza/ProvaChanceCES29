package CES29.Q4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {

        String csvFile = "/Users/mkyong/csv/users.csv";
        String line = "";
        String cvsSplitBy = ",";
        User[] users = new User[10];
        BufferedReader br = null;
		FileReader fr = null;
        try  {
        	fr = new FileReader(csvFile);
        	br = new BufferedReader(fr);
            int i = 0;
            while ((line = br.readLine()) != null && i < 10) {

                // use comma as separator
                String[] usersLine = line.split(cvsSplitBy);
	            if(usersLine.length == 5){
	                User user = new User((usersLine[0]), usersLine[1], usersLine[2], 
	                		usersLine[3], usersLine[4]);
	                users[i]=user;
                }
	            else{
	            	System.out.printf("Dados incorretos do usuário %d!\n", i);
	            }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
        }
    }
}
