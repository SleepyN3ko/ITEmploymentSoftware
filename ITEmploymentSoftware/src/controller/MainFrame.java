package controller;

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
		this.setTitle("Login");
		this.setSize(800,800);
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
	
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
	}
	public Controller getController() {
		// TODO Auto-generated method stub
		return this.cont;
	}

}
