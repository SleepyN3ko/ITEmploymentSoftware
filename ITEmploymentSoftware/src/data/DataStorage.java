package data;

import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/*
 * Model part of the MVC pattern
 * This class is responsible for storing and retrieving data from the database
 * It is also responsible for reading and writing data to the database
 * It is also responsible for creating and deleting objects from the database
 */
 
public class DataStorage {
	private Vector<Staff> staffVector = new Vector<Staff>();
	private Vector<Manager> managerVector = new Vector<Manager>();
	private Vector<Applicant> applicantVector = new Vector<Applicant>();
	private Vector<Interview> interviewVector = new Vector<Interview>();
	public DataStorage() {
		try {
			//read from staffAccounts.csv file storage
			BufferedReader br = new BufferedReader(new FileReader("staffAccounts.csv"));
			String line = "";
			int staffDataFlag = 0;
			while ((line=br.readLine())!=null){
				String[] currentStaffData = line.split(",");
				Staff currentStaff = new Staff(currentStaffData[0],currentStaffData[1]);
				this.staffVector.add(currentStaff);
				if (staffDataFlag == 0){
					staffDataFlag = 1;
				}
			}
			br.close();
			//read from managerAccounts.csv file storage
			br = new BufferedReader(new FileReader("managerAccounts.csv"));
			int managerDataFlag = 0;
			while ((line=br.readLine())!=null){
				String[] currentManagerData = line.split(",");
				Manager currentManager = new Manager(currentManagerData[0],currentManagerData[1]);
				this.managerVector.add(currentManager);
				if (managerDataFlag == 0){
					managerDataFlag = 1;
				}
			}
			
			br.close();
			br = new BufferedReader(new FileReader("applicantProfiles.csv"));
			while ((line=br.readLine())!=null){
				String[] currentApplicantData = line.split(",");
				/*for (int i=0;i<currentApplicantData.length;i++){
					System.out.print(currentApplicantData[i]+",");
				}*/
				//System.out.println("");
				Applicant currentApplicant = new Applicant(currentApplicantData);
				this.applicantVector.add(currentApplicant);
			}
			br.close();
			//read from "interviews.csv" and store in interviewVector
			br = new BufferedReader(new FileReader("interviews.csv"));
			while ((line=br.readLine())!=null){
				String[] currentInterviewData = line.split(",");
				Interview currentInterview = new Interview(currentInterviewData);
				this.interviewVector.add(currentInterview);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	//create function to add interview to the database
	public void addInterview(Interview interview){
		this.interviewVector.add(interview);
		//store in "interviews.csv"
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("interviews.csv",true));
			bw.append(interview.toCSV());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//create function to update a current interview in database using the interviewID
	public void updateInterview(Interview interview){
		for (int i=0;i<this.interviewVector.size();i++){
			if (this.interviewVector.get(i).getInterviewID().equals(interview.getInterviewID())){
				this.interviewVector.set(i, interview);
				break;
			}
		}
		//update "interviews.csv"
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("interviews.csv",false));
			for (int i=0;i<this.interviewVector.size();i++){
				bw.append(this.interviewVector.get(i).toCSV());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//create a function to get a vector of all interviews with the given intervieweeID
	public Interview getInterview(String intervieweeID) throws Exception{
		for (int i=0;i<this.interviewVector.size();i++){
			if (this.interviewVector.get(i).getIntervieweeID().equals(intervieweeID)){
				return this.interviewVector.get(i);
			}
		}
		//should never happen in theory as it there is another code to prevent it
		throw new Exception("Interview does not exist");
	}
	//create a function to see if an interview with the same StaffName and InterviewDate and InterviewTime already exists in the database
	public boolean interviewExists(String staffName, LocalDate interviewDate, String interviewTime){
		for (int i=0;i<this.interviewVector.size();i++){
			if (this.interviewVector.get(i).getStaffName().equals(staffName) && this.interviewVector.get(i).getInterviewDate().equals(interviewDate) && this.interviewVector.get(i).getTime().equals(interviewTime)){
				return true;
			}
		}
		return false;
	}
	public void addStaff(Staff newStaff) {
		//add staff to vector and data storage
		this.staffVector.add(newStaff);
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("staffAccounts.csv",true));
			fw.append(newStaff.getUsername()+","+newStaff.getPassword());
			fw.newLine();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Vector<Staff> getStaffVector(){
		return this.staffVector;
	}
	public Vector<Manager> getManagerVector() {
		return this.managerVector;
	}
	public void addManager(Manager newManager) {
		//add manager to vector and data storage
		this.managerVector.add(newManager);
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("managerAccounts.csv",true));
			fw.append(newManager.getUsername()+","+newManager.getPassword());
			fw.newLine();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addApplicant(Applicant newApplicant){
		//add applicant to vector and data storage
		this.applicantVector.add(newApplicant);
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("applicantProfiles.csv",true));
			String line = newApplicant.applicantAsCSV();
			fw.append(line);
			fw.newLine();
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		applicantVector = new Vector<Applicant>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("applicantProfiles.csv"));
			String line = "";
			while ((line=br.readLine())!=null){
				String[] currentApplicantData = line.split(",");
				Applicant currentApplicant = new Applicant(currentApplicantData);
				this.applicantVector.add(currentApplicant);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Applicant> getApplicants() {
		return this.applicantVector;
	}
	public BufferedImage getImageFromStorage(String imagePath) throws IOException {
		//retrieve image from storage
		File imageFile = new File(imagePath);
		BufferedImage img = ImageIO.read(imageFile);
		return img;
	}
	
	public Applicant getApplicant(String applicantID) {
		for (int index = 0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(applicantID)){
				return applicantVector.get(index);
			}
		}
		return null;
	}
	public Staff getStaff(String username){
		for (int index = 0;index<staffVector.size();index++){
			if (staffVector.get(index).getUsername().equals(username)){
				return staffVector.get(index);
			}
		}
		return null;
	}
	public boolean applicantExists(String applicantID) {
		//check if applicant with this specific id exists
		for (int index = 0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(applicantID)){
				return true;
			}
		}
		return false;
	}
	public void saveImageDS(Image image, String imagePath) {
		try {
		    // retrieve image
		    BufferedImage bi = (BufferedImage) image;
		    File outputfile = new File(imagePath);
		    //save image to specific path
		    ImageIO.write(bi, "png", outputfile);
		} catch (IOException e) {
		}
	}
	public void updateApplicantDS(Applicant currentApplicant) {
		//update specific applicant from vector
		for (int index=0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(currentApplicant.getApplicantID())){
				applicantVector.set(index, currentApplicant);
				break;
			}
		}
		//save updated applicant
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("applicantProfiles.csv",false));
			for (int index=0;index<applicantVector.size();index++){
				fw.append(applicantVector.get(index).applicantAsCSV());
				fw.newLine();
			}
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void updateStaffDS(Staff currentName) {
		//update specific staff from vector
		for (int index=0;index<staffVector.size();index++){
			if (staffVector.get(index).getUsername().equals(currentName.getUsername())){
				staffVector.set(index, currentName);
				break;
			}
		}
		//save updated staff
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("staffAccounts.csv",false));
			for (int index=0;index<staffVector.size();index++){
				fw.append(staffVector.get(index).staffAsCSV());
				fw.newLine();
			}
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteApplicantDS(String selectedApplicantID) {
		//remove specific applicant from vector
		for (int index=0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(selectedApplicantID)){
				if (!applicantVector.get(index).getImage().equals("null")){
					File applicantImage = new File(applicantVector.get(index).getImage());
					applicantImage.delete();
				}
				applicantVector.remove(index);
				break;
			}
		}
		//remove selected applicant from file along with associated image
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("applicantProfiles.csv",false));
			for (int index=0;index<applicantVector.size();index++){
				fw.append(applicantVector.get(index).applicantAsCSV());
				fw.newLine();
			}
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteStaffDS(String selectedUsername) {
		//remove specific staff from vector
		for (int index=0;index<staffVector.size();index++){
			if (staffVector.get(index).getUsername().equals(selectedUsername)){
				staffVector.remove(index);
				break;
			}
		}
		//remove selected staff from file
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("staffAccounts.csv",false));
			for (int index=0;index<staffVector.size();index++){
				fw.append(staffVector.get(index).staffAsCSV());
				fw.newLine();
			}
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public boolean interviewExists(String intervieweeID) {
		// TODO Auto-generated method stub
		for (int i=0;i<interviewVector.size();i++){
			if (interviewVector.get(i).getIntervieweeID().equals(intervieweeID)){
				return true;
			}
		}
		return false;
	}

	
}
