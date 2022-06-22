package data;

import java.util.List;

public class Staff {


	private String username;

	public List<Applicant> applicant;

	private String password;

	public String getUsername() {
	 	 return username; 
	}

	public void setUsername(String username) { 
		 this.username = username; 
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

	public void login() { 
		// TODO Auto-generated method
	 } 

}
