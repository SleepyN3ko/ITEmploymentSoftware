package Data;

import java.util.List;

public class Manager {

	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	public List<Shortlisted> shortlisted;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	public List<ReceivedJobOffer> receivedjoboffer;
	/**
	 * 
	 */
	public List<Applicant> applicant;
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
	 * Getter of shortlisted
	 */
	public List<Shortlisted> getShortlisted() {
	 	 return shortlisted; 
	}
	/**
	 * Setter of shortlisted
	 */
	public void setShortlisted(List<Shortlisted> shortlisted) { 
		 this.shortlisted = shortlisted; 
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
	 * Getter of receivedjoboffer
	 */
	public List<ReceivedJobOffer> getReceivedjoboffer() {
	 	 return receivedjoboffer; 
	}
	/**
	 * Setter of receivedjoboffer
	 */
	public void setReceivedjoboffer(List<ReceivedJobOffer> receivedjoboffer) { 
		 this.receivedjoboffer = receivedjoboffer; 
	}
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
	 * 
	 */
	public void login() { 
		// TODO Auto-generated method
	 } 

}
