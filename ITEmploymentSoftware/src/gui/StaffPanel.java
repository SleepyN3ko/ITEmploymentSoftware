package gui;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class StaffPanel extends JPanel{
	private MainFrame main;
	public StaffPanel(MainFrame main){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1,1,1};
		gridBagLayout.rowWeights = new double[]{1,1,1,1,1,1};
		setLayout(gridBagLayout);
	}

}
