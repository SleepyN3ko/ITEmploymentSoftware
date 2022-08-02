package data;

import java.util.List;

/*
 * This class is the class for Manager
 */
public class Manager {


	private String password;

	private String username;
	public Manager(String name, String password){
		//Constructor for manager
		this.username = name;
		this.password = password;
	}



	public String getPassword() {
		//Getter for password
	 	 return password; 
	}

	public void setPassword(String password) { 
		 //Setter for password
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
}
