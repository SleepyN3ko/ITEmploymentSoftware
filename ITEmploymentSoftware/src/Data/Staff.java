package Data;

import java.util.List;

public class Staff {

	/**
	 * 
	 */
	public List<Applicant> applicant;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String username;
	/**
	 * Getter of applicant
	 */
	public List<Applicant> getApplicant() {
	 	 return applicant; 
	}
	/**
	 * Setter of applicant
	 */
	public void setApplicant(List<Applicant> applicant) { 
		 this.applicant = applicant; 
	}
	/**
	 * Getter of password
	 */
	public String getPassword() {
	 	 return password; 
	}
	/**
	 * Setter of password
	 */
	public void setPassword(String password) { 
		 this.password = password; 
	}
	/**
	 * Getter of username
	 */
	public String getUsername() {
	 	 return username; 
	}
	/**
	 * Setter of username
	 */
	public void setUsername(String username) { 
		 this.username = username; 
	}
	/**
	 * 
	 */
	public void login() { 
		// TODO Auto-generated method
	 } 

}
