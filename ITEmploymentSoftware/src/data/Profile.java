package data;

public class Profile {
	
	private String name;
	private int phoneNumber;
	private boolean gender;
	private String workExperience;
	private String genericSkill;
	private String technicalSkill;
	private String achievement;
	private String qualification;
	

	public Profile(String n, int ph, boolean g,String we, String gskill, String tskill, String a, String q){
		this.name = n;
		this.phoneNumber = ph;
		this.gender = g;
		this.workExperience = we;
		this.genericSkill = gskill;
		this.technicalSkill = tskill;
		this.achievement = a;
		this.qualification = q;
	}
	
	public String getWorkExperience() {
	 	 return workExperience; 
	}

	public void setWorkExperience(String workExperience) { 
		 this.workExperience = workExperience; 
	}

	public boolean getGender() {
	 	 return gender; 
	}

	public void setGender(boolean gender) { 
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

	public int getphoneNumber(){
		return phoneNumber;
	}
	
	public void setphoneNumber(int phoneNumber) { 
		 this.phoneNumber = phoneNumber; 
	} 
	

	
	
	public void updateProfile() { 
		// TODO Auto-generated method
	 }

	public void saveProfile() { 
		// TODO Auto-generated method
	 }

	public Profile() { 
		// TODO Auto-generated method
	 } 

}
