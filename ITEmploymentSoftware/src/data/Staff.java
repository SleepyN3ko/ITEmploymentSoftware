package data;

import java.util.List;

public class Staff {


	private String username;

	public List<Applicant> applicant;

	private String password;
	public Staff(String name, String password){
		this.username = name;
		this.password = password;
	}
	
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
	public String staffAsCSV(){

		String line = "";
		line+=this.getUsername()+",";
		line+=this.getPassword();
		return line;
	}

}
