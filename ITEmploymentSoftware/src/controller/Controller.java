package controller;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

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
	public Object[][] getApplicants(){
		//{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()})
		List<Applicant> applicantList= this.ds.getApplicants();
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()}).toArray(Object[][]::new);
		return data;	
	}
	public boolean ApplicantExists(String ApplicantID){
		return this.ds.ApplicantExists(ApplicantID);
	}
	public Applicant getApplicant(String ApplicantID){
		return this.ds.getApplicants(ApplicantID);
	}
	public void addApplicant(Applicant currentApplicant){
		this.ds.addApplicant(currentApplicant);
	}
	public BufferedImage getImage(String imagePath) throws IOException{
		return this.ds.getImageFromStorage(imagePath);
	}
	public void saveImage(Image image, String imagePath) {
		this.ds.saveImage(image,imagePath);
	}
	public void updateApplicant(Applicant currentApplicant) {
		this.ds.updateApplicant(currentApplicant);
	}
}

