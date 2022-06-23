package data;

import java.util.List;


public class Manager {


	public List<Applicant> applicant;

	public List<Shortlisted> shortlisted;

	private String password;

	private String username;
	public Manager(String name, String password){
		this.username = name;
		this.password = password;
	}

	public List<ReceivedJobOffer> receivedjoboffer;

	public List<Applicant> getApplicant() {
	 	 return applicant; 
	}

	public void setApplicant(List<Applicant> applicant) { 
		 this.applicant = applicant; 
	}

	public List<Shortlisted> getShortlisted() {
	 	 return shortlisted; 
	}

	public void setShortlisted(List<Shortlisted> shortlisted) { 
		 this.shortlisted = shortlisted; 
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

	public List<ReceivedJobOffer> getReceivedjoboffer() {
	 	 return receivedjoboffer; 
	}

	public void setReceivedjoboffer(List<ReceivedJobOffer> receivedjoboffer) { 
		 this.receivedjoboffer = receivedjoboffer; 
	}

	public void login() { 
		// TODO Auto-generated method
	 } 

}
