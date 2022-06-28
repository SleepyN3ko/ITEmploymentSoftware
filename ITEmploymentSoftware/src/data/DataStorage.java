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
import java.util.List;
import java.util.Scanner;

public class DataStorage {
	private Vector<Staff> staffVector = new Vector<Staff>();
	private Vector<Manager> managerVector = new Vector<Manager>();
	private Vector<Applicant> applicantVector = new Vector<Applicant>();
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
					System.out.println("Staffs");
					staffDataFlag = 1;
				}
				System.out.println("Username: " + currentStaffData[0] + "   Password: " + currentStaffData[1]);	
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
					System.out.println("Manager");
					managerDataFlag = 1;
				}
				System.out.println("Username: " + currentManagerData[0] + "   Password: " + currentManagerData[1]);	
			}
			
			br.close();
			br = new BufferedReader(new FileReader("applicantProfiles.csv"));
			while ((line=br.readLine())!=null){
				String[] currentApplicantData = line.split(",");
				for (int i=0;i<currentApplicantData.length;i++){
					System.out.print(currentApplicantData[i]+",");
				}
				System.out.println("");
				Applicant currentApplicant = new Applicant(currentApplicantData);
				this.applicantVector.add(currentApplicant);
			}
			br.close();
			//read from profileAccounts file storage
			//TODO Implement the reading of file after format is decided
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	public void addStaff(Staff newStaff) {
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
		this.applicantVector.add(newApplicant);
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("applicantProfiles.csv",true));
			/*String line = "";
			line+=newApplicant.getApplicantID()+",";
			line+=newApplicant.getName()+",";
			line+=newApplicant.getphoneNumber()+",";
			line+=newApplicant.getGender()+",";
			line+=newApplicant.getWorkExperience()+",";
			line+=newApplicant.getGenericSkill()+",";
			line+=newApplicant.getTechnicalSkill()+",";
			line+=newApplicant.getAchievement()+",";
			line+=newApplicant.getQualification()+",";
			line+=Boolean.toString(newApplicant.getShortlistStatus())+",";
			line+=Boolean.toString(newApplicant.getReceivedJobOffer());*/
			String line = newApplicant.applicantAsCSV();
			fw.append(line);
			fw.newLine();
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public Vector<Applicant> getApplicants() {
		return this.applicantVector;
	}
	public BufferedImage getImageFromStorage(String imagePath) throws IOException {
		File imageFile = new File(imagePath);
		BufferedImage img = ImageIO.read(imageFile);
		return img;
	}
	
	public Applicant getApplicants(String applicantID) {
		for (int index = 0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(applicantID)){
				return applicantVector.get(index);
			}
		}
		return null;
	}
	public boolean ApplicantExists(String applicantID) {
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
		    ImageIO.write(bi, "png", outputfile);
		} catch (IOException e) {
		}
	}
	public void updateApplicantDS(Applicant currentApplicant) {
		for (int index=0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(currentApplicant.getApplicantID())){
				applicantVector.set(index, currentApplicant);
				break;
			}
		}
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
	public void deleteApplicantDS(String selectedApplicantID) {
		for (int index=0;index<applicantVector.size();index++){
			if (applicantVector.get(index).getApplicantID().equals(selectedApplicantID)){
				applicantVector.remove(index);
				break;
			}
		}
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
	

}
