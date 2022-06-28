package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainFrame;
import data.Applicant;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;

public class ManagerPanel extends JPanel{
	private MainFrame main;
	private JTable table;

	public ManagerPanel(MainFrame main){
		this.main = main;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 20, 20, 20, 0,20,20};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20,20,20};
		gridBagLayout.columnWeights = new double[]{1,1.0,1.0,1, 0.0,1,1};
		gridBagLayout.rowWeights = new double[]{1,1.0,1,1,1,1};
		setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome Manager :D");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.gridwidth = 5;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		this.table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setRowHeight(table.getRowHeight()+30);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 30 ));
		
		Object[][] rows = this.main.getController().getApplicants();
		String[] columns = {
				"ApplicantID", "Name","Short Listed","Job Offer","View Applicant"
		};
		
		this.table.setModel(new DefaultTableModel(rows,columns) {
			@Override
			public boolean isCellEditable(int row,int column){
				if (column==4){
					return true;
				}
				return false;
			}
		});
		Action view = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        String selectedApplicantID = rows[modelRow][0].toString();
		        main.showViewApplicantPanel(selectedApplicantID,"manager");
		    }
		};
		ButtonColumn viewColumn = new ButtonColumn(this.table,view,4);
		this.table.setFillsViewportHeight(true);
		scrollPane.setViewportView(this.table);
		
		JButton btnInterview = new JButton("Select Applicant For Interview");
		btnInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
					Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
					selectedApplicant.setShortlistStatus(!selectedApplicant.getShortlistStatus());
					main.getController().updateApplicant(selectedApplicant);
					main.showManagerPanel();
				}
			}
		});
		btnInterview.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnInterview = new GridBagConstraints();
		gbc_btnInterview.insets = new Insets(0, 0, 0, 5);
		gbc_btnInterview.gridx = 1;
		gbc_btnInterview.gridy = 5;
		add(btnInterview, gbc_btnInterview);
		
		JButton btnJobOffer = new JButton("Give Job Offer");
		btnJobOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(table.getSelectedRow()==-1)){
					String selectedApplicantID = rows[table.getSelectedRow()][0].toString();
					Applicant selectedApplicant = main.getController().getApplicant(selectedApplicantID);
					selectedApplicant.setReceivedJobOffer(!selectedApplicant.getReceivedJobOffer());
					main.getController().updateApplicant(selectedApplicant);
					main.showManagerPanel();
				}
			}
		});
		btnJobOffer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnJobOffer = new GridBagConstraints();
		gbc_btnJobOffer.insets = new Insets(0, 0, 0, 5);
		gbc_btnJobOffer.gridx = 2;
		gbc_btnJobOffer.gridy = 5;
		add(btnJobOffer, gbc_btnJobOffer);
		
		JButton btnListJobOffer = new JButton("Generate List");
		btnListJobOffer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnListJobOffer = new GridBagConstraints();
		gbc_btnListJobOffer.insets = new Insets(0, 0, 0, 5);
		gbc_btnListJobOffer.gridx = 3;
		gbc_btnListJobOffer.gridy = 5;
		add(btnListJobOffer, gbc_btnListJobOffer);
		

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 5;
		gbc_btnBack.gridy = 5;
		add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginPanel();
			}
		});
	}
}
