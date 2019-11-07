package whatsForDinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UserInput extends Pantry {


	public HashSet<String> userInput() {
		

	    //Enter data using BufferReader 
	    BufferedReader reader =  
	               new BufferedReader(new InputStreamReader(System.in)); 
	    HashSet<String> inputSet = new HashSet<String>();
	    String input = "";
	    
	    while (!input.equals("done")) {
		    // Reading data using readLine 
		    try {
				input = reader.readLine().trim().toLowerCase();
			} catch (NullPointerException | IOException e) {
				System.out.println("Can not add NULL");
			}
		    if (!input.equals("done")) {
			    inputSet.add(input); 
		    }

	    }
		return inputSet;
	}
	
	

}
