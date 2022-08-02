package controller;
import gui.*;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import data.Staff;
import gui.LoginPanel;
import gui.RegisterPanel;

/*
 * MainFrame is the main frame of the application. It is responsible for creating the main frame and initializing the application.
 */

public class MainFrame extends JFrame{
	
	private CardLayout card;
	private Controller cont;

	public MainFrame()
	{
		this.setTitle("IT Employment System");
		this.setSize(1600,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.card = new CardLayout();
		getContentPane().setLayout(this.card);
		
		this.cont = new Controller();
		this.showLoginPanel();
		
    this.setVisible(true);
	}
	public void showLoginPanel()
	{
		/*
		 * Create a new LoginPanel and add it to the content pane
		 */
		LoginPanel panel = new LoginPanel(this);
		getContentPane().add(panel, "LoginPanel");
		this.card.show(this.getContentPane(), "LoginPanel");
	}
	public void showRegisterPanel()
	{
		/*
		 * Create a new RegisterPanel and add it to the content pane
		 */
		RegisterPanel panel = new RegisterPanel(this);
		getContentPane().add(panel, "LoginPanel");
		this.card.show(this.getContentPane(), "LoginPanel");
	}
	public void showStaffPanel()
	{
		/*
		 * Create a new StaffPanel and add it to the content pane
		 */
		StaffPanel panel = new StaffPanel(this);
		getContentPane().add(panel,"StaffPanel");
		this.card.show(this.getContentPane(), "StaffPanel");
	}
	public void showManagerPanel()
	{
		/*
		 * Create a new ManagerPanel and add it to the content pane
		 */
		ManagerPanel panel = new ManagerPanel(this);
		getContentPane().add(panel,"ManagerPanel");
		this.card.show(this.getContentPane(), "ManagerPanel");
	}
	public void showViewApplicantPanel(String ApplicantID,String parentPanelName)
	{
		/*
		 * Create a new ViewApplicantPanel and add it to the content pane
		 */
		ViewApplicantPanel panel = new ViewApplicantPanel(this,ApplicantID,parentPanelName);
		getContentPane().add(panel,"ViewApplicantPanel");
		this.card.show(this.getContentPane(), "ViewApplicantPanel");
	}
	public void showAddUpdateApplicantPanel(String ApplicantID){
		/*
		 * Create a new AddUpdateApplicantPanel and add it to the content pane
		 */
		AddUpdateApplicantPanel panel = new AddUpdateApplicantPanel(this,ApplicantID);
		getContentPane().add(panel,"AddUpdateApplicantPanel");
		this.card.show(this.getContentPane(), "AddUpdateApplicantPanel");
		
	}
	public void showInfoStaffPanel(){
		/*
		 * Create a new InfoStaffPanel and add it to the content pane
		 */
		InfoStaffPanel panel = new InfoStaffPanel(this);
		getContentPane().add(panel,"InfoStaffPanel");
		this.card.show(this.getContentPane(), "InfoStaffPanel");
		
	}
	public static void main(String[] args) {
		// Create a new MainFrame to start the program
		MainFrame main = new MainFrame();
	}
	public Controller getController() {
		//gets the controller
		return this.cont;
	}

}
