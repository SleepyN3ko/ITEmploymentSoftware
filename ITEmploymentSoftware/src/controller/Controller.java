package controller;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;

import data.*;

/*
 * Controller part of the MVC pattern
 * This class is responsible for passing data from the model to the view and vice versa
 * It is also responsible for retrieving data from the database
 */

public class Controller {
	private DataStorage ds = new DataStorage();
	
	public String verifyStaff(String username, String password, int flag){
		/*
		 * Function is used for verifying the staff login details
		 * flag = 0 for staff registration
		 * flag = 1 for staff login
		 */
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
	//create a function to add a new interview to data base
	public String addInterview(String IntervieweeID,String StaffName,String Position, LocalDate InterviewDate,String Time){
		String errorMsg = "";
		if (IntervieweeID.isEmpty() && StaffName.isEmpty() && Position.isEmpty() && InterviewDate.toString().isEmpty() && Time.isEmpty()){
			errorMsg = "Please enter all the fields";
		}
		else if (IntervieweeID.isEmpty()){
			errorMsg = "Please enter IntervieweeID";
		}
		else if (StaffName.isEmpty()){
			errorMsg = "Please enter StaffName";
		}
		else if (Position.isEmpty()){
			errorMsg = "Please enter Position";
		}
		else if (InterviewDate.toString().isEmpty()){
			errorMsg = "Please enter InterviewDate";
		}
		else if (Time.isEmpty()){
			errorMsg = "Please enter Time";
		}
		else if (ds.interviewExists(StaffName,InterviewDate,Time)){
			errorMsg = "An interview with the same Staff, InterviewDate and Time already exists";
		}
		else{
			//create a new interview object and add it to the data base
			Interview interview = new Interview(IntervieweeID,StaffName,Position,InterviewDate,Time);
			ds.addInterview(interview);
		}
		return errorMsg;
	}
	//create a function to update an existing interview in the data base
	public String updateInterview(String InterviewID,String IntervieweeID,String StaffName,String Position, LocalDate InterviewDate,String Time){
		String errorMsg = "";
		if (IntervieweeID.isEmpty() && StaffName.isEmpty() && Position.isEmpty() && InterviewDate.toString().isEmpty() && Time.isEmpty()){
			errorMsg = "Please enter all the fields";
		}
		else if (IntervieweeID.isEmpty()){
			errorMsg = "Please enter IntervieweeID";
		}
		else if (StaffName.isEmpty()){
			errorMsg = "Please enter StaffName";
		}
		else if (Position.isEmpty()){
			errorMsg = "Please enter Position";
		}
		else if (InterviewDate.toString().isEmpty()){
			errorMsg = "Please enter InterviewDate";
		}
		else if (Time.isEmpty()){
			errorMsg = "Please enter Time";
		}
		else if (ds.interviewExists(StaffName,InterviewDate,Time)){
			errorMsg = "An interview with the same Staff, Interview Date and Time already exists";
		}
		else{
			//create a new interview object and update it in the data base
			Interview interview = new Interview(InterviewID,IntervieweeID,StaffName,Position,InterviewDate,Time);
			ds.updateInterview(interview);
		}
		return errorMsg;
	}
	public void registerStaff(String username, String password){
		/*
		 * Function is used for registering a new staff
		 */
		Staff newStaff = new Staff(username,password);
		this.ds.addStaff(newStaff);
	}

	public boolean staffExists(String username,String password){
		/*
		 * Function is used for checking if a staff exists
		 */
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
		/*
		 * Function is used for verifying the manager login details
		 * flag = 0 for manager registration
		 * flag = 1 for manager login
		 */
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
		/*
		 * Function is used for checking if a manager exists
		 */
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
		/*
		 * Function is used for registering a new manager
		 */
		Manager newManager = new Manager(username,password);
		this.ds.addManager(newManager);
	}

	
	private boolean managerLoginFailed(String username, String password){
		/*
		 * Function is used for checking if a manager login failed
		 */
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
		/*
		 * Function is used for checking if a staff login failed
		 */
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
		/*
		 * Function is used for getting all the staffs to be used in a JTable
		 */
		List<Staff> staffList= this.ds.getStaffVector();
		
		Object[][] data = staffList.stream().map(p->new Object[]{p.getUsername(),p.getPassword(),"Delete"}).toArray(Object[][]::new);

		return data;	
	}
	public String[] getStaffForInterview(){
		Vector<Staff> staffvector = this.ds.getStaffVector();
		String[] StaffList = new String[staffvector.size()];
		for (int i=0;i<staffvector.size();i++){
			StaffList[i] = staffvector.get(i).getUsername();
		}
		return StaffList;
	}
	public Object[][] getApplicants(){
		/*
		 * Function is used for getting all the applicants to be used in a JTable
		 */
		List<Applicant> applicantList= this.ds.getApplicants();
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),"View","Update","Delete","Set"}).toArray(Object[][]::new);

		return data;	
	}
	public Object[][] getApplicantsManager(){
		/*
		 * Function is used for getting all the applicants to be used in a JTable
		 */
		List<Applicant> applicantList= this.ds.getApplicants();//Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getphoneNumber(),p.getGender(),p.getWorkExperience(),p.getGenericSkill(),p.getTechnicalSkill(),p.getAchievement(),p.getQualification(),p.getShortlistStatus(),p.getReceivedJobOffer()}).toArray(Object[][]::new);
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View","Set"}).toArray(Object[][]::new);

		return data;	
	}
	
	public Object[][] getApplicants(List<String> filters){
		/*
		 * Function is used for getting all the applicants to be used in a JTable
		 * filters is a list of strings containing the filters to be applied
		 */
		List<Applicant> applicantList= this.ds.getApplicants(); //get data
		if (filters.size()>0){ //ensure filters are not empty
			//if there is a filter then apply the filter
			for (int filterIndex=0;filterIndex<filters.size();filterIndex++){
				String[] filterKeyValuePair = filters.get(filterIndex).split(","); //split the filter into key and value
				String filterKey = filterKeyValuePair[0]; //get the key
				String filterValue = filterKeyValuePair[1]; //get the value
				//checks what is the column to filter then filter according to value
				//applicants are filtered sequentially to speed up the program
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
		//convert the list to an array of objects to be used in a JTable
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),"View","Update","Delete","Set"}).toArray(Object[][]::new);

		return data;	
	}
	
	public Object[][] getShortlistApplicants(){
		/*
		 * Function is used for getting all the shortlisted applicants to be used in a JTable
		 */
		List<Applicant> applicantList= this.ds.getApplicants();
		
		applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getShortlistStatus() == true).collect(Collectors.toList());
		
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View","Set"}).toArray(Object[][]::new);
		return data;
	}
	public boolean interviewExists(String intervieweeID){
		//checks if interview exists for the applicant already
		return this.ds.interviewExists(intervieweeID);
	}
	public Interview getInterview(String intervieweeID) throws Exception{
		return this.ds.getInterview(intervieweeID);
	}
	public Object[][] getJobOfferedApplicants(){
		/*
		 * Function is used for getting all the applicants who have received a job offer to be used in a JTable
		 */
		List<Applicant> applicantList= this.ds.getApplicants();
		
		applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getReceivedJobOffer() == true).collect(Collectors.toList());
		
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View","Set"}).toArray(Object[][]::new);
		return data;
	}
	
	public Object[][] getBothApplicants(){
		/*
		 * Function is used for getting all the applicants who have received a job offer and are shortlisted to be used in a JTable
		 */
		List<Applicant> applicantList= this.ds.getApplicants();
		
		applicantList = (List<Applicant>) applicantList.stream().filter((p->p.getReceivedJobOffer() == true)).collect(Collectors.toList());
		applicantList = (List<Applicant>) applicantList.stream().filter(p->p.getShortlistStatus() == true).collect(Collectors.toList());
		
		Object[][] data = applicantList.stream().map(p->new Object[]{p.getApplicantID(),p.getName(),p.getShortlistStatus(),p.getReceivedJobOffer(),"View","Set"}).toArray(Object[][]::new);
		return data;
	}
	
	public boolean applicantExists(String ApplicantID){
		/*
		 * Function is used for checking if an applicant exists in the database
		 * ApplicantID is the ID of the applicant to be checked
		 */
		return this.ds.applicantExists(ApplicantID);
	}
	public Applicant getApplicant(String ApplicantID){
		/*
		 * Function is used for getting an applicant from the database
		 * ApplicantID is the ID of the applicant to be retrieved
		 */
		return this.ds.getApplicant(ApplicantID);
	}
	public Staff getStaff(String Username){
		/*
		 * Function is used for getting a staff member from the database
		 * Username is the username of the staff member to be retrieved
		 */
		return this.ds.getStaff(Username);
	}
	public void addApplicant(Applicant currentApplicant){
		/*
		 * Function is used for adding an applicant to the database
		 * currentApplicant is the applicant to be added
		 */
		this.ds.addApplicant(currentApplicant);
	}
	public void addStaff(Staff currentStaff){
		/*
		 * Function is used for adding a staff member to the database
		 * currentStaff is the staff member to be added
		 */
		this.ds.addStaff(currentStaff);
	}
	public BufferedImage getImage(String imagePath) throws IOException{
		/*
		 * Function is used for getting an image from the database
		 * imagePath is the path of the image to be retrieved
		 */
		return this.ds.getImageFromStorage(imagePath);
	}
	public void saveImage(Image image, String imagePath) {
		/*
		 * Function is used for saving an image to the database
		 * image is the image to be saved
		 * imagePath is the path of the image to be saved
		 */
		this.ds.saveImageDS(image,imagePath);
	}
	public void updateApplicant(Applicant currentApplicant) {
		/*
		 * Function is used for updating an applicant in the database
		 * currentApplicant is the applicant to be updated
		 */
		this.ds.updateApplicantDS(currentApplicant);
	}
	public void updateStaff(Staff currentStaff) {
		/*
		 * Function is used for updating a staff member in the database
		 * currentStaff is the staff member to be updated
		 */
		this.ds.updateStaffDS(currentStaff);
	}
	public void deleteApplicant(String selectedApplicantID) {
		/*
		 * Function is used for deleting an applicant from the database
		 * selectedApplicantID is the ID of the applicant to be deleted
		 */
		this.ds.deleteApplicantDS(selectedApplicantID);
	}
	public void deleteStaff(String selectedUsername) {
		/*
		 * Function is used for deleting a staff member from the database
		 * selectedUsername is the username of the staff member to be deleted
		 */
		this.ds.deleteStaffDS(selectedUsername);
	}
}

