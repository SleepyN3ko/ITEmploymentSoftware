package controller;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;

import data.*;


public class Controller {
	private DataStorage ds = new DataStorage();
	
	public String verifyStaff(String username, String password, int flag){
		String errorMsg = "";
		if (username.isEmpty() && password.isEmpty()){
			errorMsg = "Please enter username and password.";
		}
		else if (username.isEmpty()){
			errorMsg = "Please enter username.";
		}
		else if (password.isEmpty()){
			errorMsg = "Please enter password";
		}
		else if (staffExists(username,password)&&(flag==0)){
			errorMsg = "A staff with the same username already exists";
		}
		else if (staffLoginFailed(username,password) && (flag == 1)){
			errorMsg = "Login failed as HR staff, please try again";
		}
		return errorMsg;
	}
	public void registerStaff(String username, String password){
		Staff newStaff = new Staff(username,password);
		this.ds.addStaff(newStaff);
	}

	public boolean staffExists(String username,String password){
		Vector<Staff> staffVector = ds.getStaffVector();
		Staff newStaff = new Staff(username,password);
		boolean exists = false;
		//code to check if account already exists
		for (int index=0;index < staffVector.size();index++){
			Staff checkStaff = staffVector.get(index);
			if ((checkStaff.getUsername().equals(newStaff.getUsername()))){
				exists=true;
				break;
			}
		}
		return exists;
	}
	public String verifyManager(String username, String password, int flag) {
		String errorMsg = "";
		if (username.isEmpty() && password.isEmpty()){
			errorMsg = "Please enter username and password.";
		}
		else if (username.isEmpty()){
			errorMsg = "Please enter username.";
		}
		else if (password.isEmpty()){
			errorMsg = "Please enter password";
		}
		else if (managerExists(username,password) && (flag == 0)){
			errorMsg = "A manager with the same username already exists";
		}
		else if (managerLoginFailed(username,password) && (flag == 1)){
			errorMsg = "Login failed as manager, please try again";
		}
		
		return errorMsg;
	}
	private boolean managerExists(String username, String password) {

		Vector<Manager> managerVector = ds.getManagerVector();
		Manager newManager = new Manager(username,password);
		boolean exists = false;
		//code to check if account already exists
		for (int index=0;index < managerVector.size();index++){
			Manager checkManager = managerVector.get(index);
			if ((checkManager.getUsername().equals(newManager.getUsername()))){
				exists=true;
				break;
			}
		}
		return exists;
	}
	public void registerManager(String username, String password) {
		Manager newManager = new Manager(username,password);
		this.ds.addManager(newManager);
	}

	
	private boolean managerLoginFailed(String username, String password){
		Vector<Manager> managerVector = ds.getManagerVector();
		Manager loginManager = new Manager(username,password);
		boolean failed = true;
		for (int index=0;index < managerVector.size();index++){
			Manager checkManager = managerVector.get(index);
			if ((checkManager.getUsername().equals(loginManager.getUsername()))){
				if ((checkManager.getPassword().equals(loginManager.getPassword()))){
					failed = false;
					break;
				}
			}
		}
		return failed;
	}
	
	private boolean staffLoginFailed(String username, String password){
		Vector<Staff> staffVector = ds.getStaffVector();
		Staff loginStaff = new Staff(username,password);
		boolean failed = true;
		for (int index=0;index < staffVector.size();index++){
			Staff checkStaff = staffVector.get(index);
			if ((checkStaff.getUsername().equals(loginStaff.getUsername()))){
				if ((checkStaff.getPassword().equals(loginStaff.getPassword()))){
					failed = false;
					break;
				}
			}
		}
		return failed;
	}
	
	public Object[][] getStaffs(){
	

		List<Staff> staffList= this.ds.getStaffVector();
		
		Object[][] data = staffList.stream().map(p->new Object[]{p.getUsername(),p.getPassword(),"Delete"}).toArray(Object[][]::new);

		return data;	
	}
	
	public Object[][] getApplicants(){
		//{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()})

		List<Applicant> applicantList= this.ds.getApplicants();
		//Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()}).toArray(Object[][]::new);
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),"View","Update","Delete"}).toArray(Object[][]::new);

		return data;	
	}
	public Object[][] getApplicantsManager(){
		//{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()})

		List<Applicant> applicantList= this.ds.getApplicants();
		//Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()}).toArray(Object[][]::new);
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View"}).toArray(Object[][]::new);

		return data;	
	}
	
	public Object[][] getApplicants(List<String> filters){
		List<Applicant> applicantList= this.ds.getApplicants(); //get data
		if (filters.size()>0){
			//if there is a filter then apply the filter
			for (int filterIndex=0;filterIndex<filters.size();filterIndex++){
				String[] filterKeyValuePair = filters.get(filterIndex).split(",");
				//split the filter into key value pairs
				String filterKey = filterKeyValuePair[0];
				String filterValue = filterKeyValuePair[1];
				//checks what is the column to filter then filter according to value
				if (filterKey.equals("gender")){ 
					if (!filterValue.equals("All")){
						applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getGender().equals(filterValue.toString())).collect(Collectors.toList());
					}
					
				}
				else if (filterKey.equals("tskill")){
					if (!filterValue.equals("All")){
						applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getTechnicalSkill().equals(filterValue.toString())).collect(Collectors.toList());
					}
				}
				else if (filterKey.equals("qualification")){
					if (!filterValue.equals("All")){
						applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getQualification().equals(filterValue.toString())).collect(Collectors.toList());
					}
				}
				else if (filterKey.equals("shortlist")){
					if (!filterValue.equals("All")){
						applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getShortlistStatusAsString().equals(filterValue.toString())).collect(Collectors.toList());
					}
				}
			}
		}
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),"View","Update","Delete"}).toArray(Object[][]::new);

		return data;	
	}
	
	public Object[][] getShortlistApplicants(){
		List<Applicant> applicantList= this.ds.getApplicants();
		
		applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getShortlistStatus() == true).collect(Collectors.toList());
		
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View"}).toArray(Object[][]::new);
		return data;
	}
	
	public Object[][] getJobOfferedApplicants(){
		List<Applicant> applicantList= this.ds.getApplicants();
		
		applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getReceivedJobOffer() == true).collect(Collectors.toList());
		
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View"}).toArray(Object[][]::new);
		return data;
	}
	
	public Object[][] getBothApplicants(){
		List<Applicant> applicantList= this.ds.getApplicants();
		
		applicantList = (List<Applicant>) applicantList.stream().filter((p->p.getReceivedJobOffer() == true)).collect(Collectors.toList());
		applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getShortlistStatus() == true).collect(Collectors.toList());
		
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View"}).toArray(Object[][]::new);
		return data;
	}
	
	public boolean applicantExists(String ApplicantID){
		return this.ds.applicantExists(ApplicantID);
	}
	public Applicant getApplicant(String ApplicantID){
		return this.ds.getApplicant(ApplicantID);
	}
	public Staff getStaff(String Username){
		return this.ds.getStaff(Username);
	}
	public void addApplicant(Applicant currentApplicant){
		this.ds.addApplicant(currentApplicant);
	}
	public void addStaff(Staff currentStaff){
		this.ds.addStaff(currentStaff);
	}
	public BufferedImage getImage(String imagePath) throws IOException{
		return this.ds.getImageFromStorage(imagePath);
	}
	public void saveImage(Image image, String imagePath) {
		this.ds.saveImageDS(image,imagePath);
	}
	public void updateApplicant(Applicant currentApplicant) {
		this.ds.updateApplicantDS(currentApplicant);
	}
	public void updateStaff(Staff currentStaff) {
		this.ds.updateStaffDS(currentStaff);
	}
	public void deleteApplicant(String selectedApplicantID) {
		this.ds.deleteApplicantDS(selectedApplicantID);
	}
	public void deleteStaff(String selectedUsername) {
		this.ds.deleteStaffDS(selectedUsername);
	}
}

