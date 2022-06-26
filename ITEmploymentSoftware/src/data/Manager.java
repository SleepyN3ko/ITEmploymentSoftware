package data;

import java.util.List;


public class Manager {


	public List<Applicant> applicant;


	private String password;

	private String username;
	public Manager(String name, String password){
		this.username = name;
		this.password = password;
	}


	public List<Applicant> getApplicant() {
	 	 return applicant; 
	}

	public void setApplicant(List<Applicant> applicant) { 
		 this.applicant = applicant; 
	}


	public String getPassword() {
	 	 return password; 
	}

	public void setPassword(String password) { 
		 this.password = password; 
	}

	public String getUsername() {
	 	 return username; 
	}

	public void setUsername(String username) { 
		 this.username = username; 
	}

	
	public void login() { 
		// TODO Auto-generated method
	 } 

}
