package controller;

import java.awt.CardLayout;
import javax.swing.JFrame;

import gui.LoginPanel;
import gui.RegisterPanel;

public class MainFrame extends JFrame{
	
	private CardLayout card;
	private Controller cont;

	public MainFrame()
	{
		this.setTitle("Login");
		this.setSize(686, 546);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.card = new CardLayout();
		getContentPane().setLayout(this.card);
		
		this.cont = new Controller();
		this.showLoginPanel();
		this.setVisible(true);
	}
	
	public void showLoginPanel()
	{
		LoginPanel p1 = new LoginPanel(this);
		getContentPane().add(p1, "Panel1");
		this.card.show(this.getContentPane(), "Panel1");
	}
	
	
	public static void main(String[] args) {
	MainFrame ex = new MainFrame();
	
	}
	public Controller getController() {
		// TODO Auto-generated method stub
		return this.cont;
	}

}
