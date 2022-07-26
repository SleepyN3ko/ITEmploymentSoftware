package data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Applicant {


	private String applicantID;


	private String name;
	private String phoneNumber;
	private String gender;
	private String workExperience;
	private String genericSkill;
	private String technicalSkill;
	private String achievement;
	private String qualification;
	
	private String applicantImagePath;

	private boolean shortlisted;
	private boolean receivedJobOffer;
	public Applicant(){
		this.applicantID = UUID.randomUUID().toString();
		this.shortlisted = false;
		this.receivedJobOffer = false;
	}
	public Applicant(String[] dataFromCSV){
		this.applicantID = dataFromCSV[0];
		this.name = dataFromCSV[1];
		this.phoneNumber = dataFromCSV[2];
		this.gender = dataFromCSV[3];
		this.workExperience = dataFromCSV[4];
		this.genericSkill = dataFromCSV[5];
		this.technicalSkill = dataFromCSV[6];
		this.achievement = dataFromCSV[7];
		this.qualification = dataFromCSV[8];
		this.shortlisted = Boolean.parseBoolean(dataFromCSV[9]);
		this.receivedJobOffer = Boolean.parseBoolean(dataFromCSV[10]);
		this.applicantImagePath = dataFromCSV[11];
	}
	public String getApplicantID() {
	 	 return applicantID; 
	}

	public void setApplicantID(String applicantID) { 
		 this.applicantID = applicantID; 
	}


	public boolean getShortlistStatus() {
	 	 return shortlisted; 
	}
	public String getShortlistStatusAsString() {
	 	 return String.valueOf(shortlisted); 
	}
	public void setShortlistStatus(boolean shortlistStatus) { 
		 this.shortlisted = shortlistStatus; 
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
	public String getImage(){
		return this.applicantImagePath;
	}
	public void setImage(String imagePath){
		//TODO add overwrite previousImage function
		this.applicantImagePath = imagePath;
	}

	public boolean getReceivedJobOffer() {
		return receivedJobOffer;
	}

	public void setReceivedJobOffer(boolean receivedJobOffer) {
		this.receivedJobOffer = receivedJobOffer;
	}

	public String getWorkExperience() {
	 	 return workExperience; 
	}

	public void setWorkExperience(String workExperience) { 
		 this.workExperience = workExperience; 
	}

	public String getGender() {
	 	 return gender; 
	}

	public void setGender(String gender) { 
		 this.gender = gender; 
	}

	public String getGenericSkill() {
	 	 return genericSkill; 
	}

	public void setGenericSkill(String genericSkill) { 
		 this.genericSkill = genericSkill; 
	}

	public String getTechnicalSkill() {
	 	 return technicalSkill; 
	}

	public void setTechnicalSkill(String technicalSkill) { 
		 this.technicalSkill = technicalSkill; 
	}

	public String getName() {
	 	 return name; 
	}

	public void setName(String name) { 
		 this.name = name; 
	}

	public String getAchievement() {
	 	 return achievement; 
	}

	public void setAchievement(String achievement) { 
		 this.achievement = achievement; 
	}

	public String getQualification() {
	 	 return qualification; 
	}

	public void setQualification(String qualification) { 
		 this.qualification = qualification; 
	}

	public String getphoneNumber(){
		return phoneNumber;
	}
	
	public void setphoneNumber(String phoneNumber) { 
		 this.phoneNumber = phoneNumber; 
	} 



	
	
	public void updateProfile(String n, String ph, String g,String we, String gskill, String tskill, String a, String q) {
		this.setName(n);
		this.setphoneNumber(ph);
		this.setGender(g);
		this.setWorkExperience(we);
		this.setGenericSkill(gskill);
		this.setTechnicalSkill(tskill);
		this.setAchievement(a);
		this.setQualification(q);
		// TODO Auto-generated method
	 }

	public void saveProfile(String n, int ph, String g,String we, String gskill, String tskill, String a, String q) { 
		// TODO Auto-generated method
	 }
	public String applicantAsCSV(){

		String line = "";
		line+=this.getApplicantID()+",";
		line+=this.getName()+",";
		line+=this.getphoneNumber()+",";
		line+=this.getGender()+",";
		line+=this.getWorkExperience()+",";
		line+=this.getGenericSkill()+",";
		line+=this.getTechnicalSkill()+",";
		line+=this.getAchievement()+",";
		line+=this.getQualification()+",";
		line+=Boolean.toString(this.getShortlistStatus())+",";
		line+=Boolean.toString(this.getReceivedJobOffer())+",";
		line+=this.getImage();
		return line;
	}

}
