package controller;
import java.util.Vector;

import data.DataStorage;
import data.Manager;
import data.Staff;


public class Controller {
	private DataStorage ds = new DataStorage();
	public String verifyStaff(String username, String password){
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
		else if (staffExists(username,password)){
			errorMsg = "A staff with the same username already exists";
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
	public String verifyManager(String username, String password) {
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
		else if (managerExists(username,password)){
			errorMsg = "A manager with the same username already exists";
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

}

