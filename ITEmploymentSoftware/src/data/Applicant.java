package data;

public class Applicant {


	private String applicantID;

	public ReceivedJobOffer receivedjoboffer;

	public Profile profile;

	private boolean shortlistStatus;

	public String getApplicantID() {
	 	 return applicantID; 
	}

	public void setApplicantID(String applicantID) { 
		 this.applicantID = applicantID; 
	}

	public ReceivedJobOffer getReceivedjoboffer() {
	 	 return receivedjoboffer; 
	}

	public void setReceivedjoboffer(ReceivedJobOffer receivedjoboffer) { 
		 this.receivedjoboffer = receivedjoboffer; 
	}

	public Profile getProfile() {
	 	 return profile; 
	}

	public void setProfile(Profile profile) { 
		 this.profile = profile; 
	}

	public boolean getShortlistStatus() {
	 	 return shortlistStatus; 
	}

	public void setShortlistStatus(boolean shortlistStatus) { 
		 this.shortlistStatus = shortlistStatus; 
	}

	public void addNewApplicant() { 
		// TODO Auto-generated method
	 }

	public void shortlistApplicant() { 
		// TODO Auto-generated method
	 }

	public void saveDetailsDS() { 
		// TODO Auto-generated method
	 }

	public void viewApplicantProfile() { 
		// TODO Auto-generated method
	 }

	public void viewShortlistApplicants() { 
		// TODO Auto-generated method
	 } 

}
