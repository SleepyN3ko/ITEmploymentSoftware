package data;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;
public class DataStorage {
	private Vector<Staff> staffVector = new Vector<Staff>();
	private Vector<Manager> managerVector = new Vector<Manager>();
	private Vector<Applicant> applicantVector;
	public DataStorage() {
		try {
			//read from staffAccounts.csv file storage
			File file = new File("staffAccounts.csv");
			Scanner sc = new Scanner(file);
			while (sc.hasNext()){
				String[] currentStaffData = sc.next().split(",");
				Staff currentStaff = new Staff(currentStaffData[0],currentStaffData[1]);
				this.staffVector.add(currentStaff);
			}
			sc.close();
			//read from managerAccounts.csv file storage
			file = new File("managerAccounts.csv");
			sc = new Scanner(file);
			while (sc.hasNext()){
				String[] currentManagerData = sc.next().split(",");
				Manager currentManager = new Manager(currentManagerData[0],currentManagerData[1]);
				managerVector.add(currentManager);
			}
			sc.close();
			//read from profileAccounts file storage
			//TODO Implement the reading of file after format is decided
			
		} catch (FileNotFoundException e) {
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

}
