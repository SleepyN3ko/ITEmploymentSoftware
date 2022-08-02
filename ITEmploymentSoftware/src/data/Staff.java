package data;

import java.util.List;
/*
 * This class is the class for Staff
 */
 

public class Staff {


	private String username;

	private String password;
	public Staff(String name, String password){
		//Constructor for staff
		this.username = name;
		this.password = password;
	}
	
	public String getUsername() {
		//Getter for username
	 	 return username; 
	}

	public void setUsername(String username) {
		 //Setter for username 
		 this.username = username; 
	}

	public String getPassword() {
		//Getter for password
	 	 return password; 
	}

	public void setPassword(String password) { 
		 //Setter for password
		 this.password = password; 
	}
	public String staffAsCSV(){
		//Return a string of the staff in CSV format
		String line = "";
		line+=this.getUsername()+",";
		line+=this.getPassword();
		return line;
	}

}
