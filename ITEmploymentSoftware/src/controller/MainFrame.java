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

public class MainFrame extends JFrame{
	
	private CardLayout card;
	private Controller cont;

	public MainFrame()
	{
		this.setTitle("IT Employment System");
		this.setSize(1980,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.card = new CardLayout();
		getContentPane().setLayout(this.card);
		
		this.cont = new Controller();
		this.showLoginPanel();
		
    this.setVisible(true);
	}
	public void showLoginPanel()
	{
		LoginPanel panel = new LoginPanel(this);
		getContentPane().add(panel, "LoginPanel");
		this.card.show(this.getContentPane(), "LoginPanel");
	}
	public void showRegisterPanel()
	{
		RegisterPanel panel = new RegisterPanel(this);
		getContentPane().add(panel, "LoginPanel");
		this.card.show(this.getContentPane(), "LoginPanel");
	}
	public void showStaffPanel()
	{
		StaffPanel panel = new StaffPanel(this);
		getContentPane().add(panel,"StaffPanel");
		this.card.show(this.getContentPane(), "StaffPanel");
	}
	public void showManagerPanel()
	{
		ManagerPanel panel = new ManagerPanel(this);
		getContentPane().add(panel,"ManagerPanel");
		this.card.show(this.getContentPane(), "ManagerPanel");
	}
	public void showViewApplicantPanel(String ApplicantID,String parentPanelName)
	{
		ViewApplicantPanel panel = new ViewApplicantPanel(this,ApplicantID,parentPanelName);
		getContentPane().add(panel,"ViewApplicantPanel");
		this.card.show(this.getContentPane(), "ViewApplicantPanel");
	}
	public void showAddUpdateApplicantPanel(String ApplicantID){
		AddUpdateApplicantPanel panel = new AddUpdateApplicantPanel(this,ApplicantID);
		getContentPane().add(panel,"AddUpdateApplicantPanel");
		this.card.show(this.getContentPane(), "AddUpdateApplicantPanel");
		
	}
	public void showInfoStaffPanel(){
		InfoStaffPanel panel = new InfoStaffPanel(this);
		getContentPane().add(panel,"InfoStaffPanel");
		this.card.show(this.getContentPane(), "InfoStaffPanel");
		
	}
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
	}
	public Controller getController() {
		// TODO Auto-generated method stub
		return this.cont;
	}

}
