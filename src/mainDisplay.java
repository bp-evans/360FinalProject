//main display where stuff is displayed 
/*
Name: Brandon, Cameron, Ismael
Class ID: 70606
Assignment: Final Project
Description: This is the mainDisplay class which is where the
			 initial main display is located.
*/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.Scanner;
import java.time.LocalDate;

public class mainDisplay extends JPanel implements Observer {
	
	private JLabel label;
	private JTable table;
	private String month;
	private String day; 
	private JTextField month1, day1;
	private File roster_file;
	private File atten_file;
	private controller ctrl;
	public boolean dateChosen;
	
	public mainDisplay() {
		label = new JLabel("", SwingConstants.CENTER);
		this.add(label);
		//this.setLayout(new BorderLayout());
		ctrl = new controller();
		this.dateChosen = false;
	}
	
	public void updateLabel(String arg) { // mainly for use with about
		label.setText(arg);
	}
	
	public void showRoster(File csv_file) throws FileNotFoundException {
		this.remove(this.label);
		this.repaint();
		roster_file = csv_file;
		String[][] arr;
		arr = ctrl.tableData(csv_file,6);
		String column[] = {"ID","First Name","Last Name","Program","Level","ASURITE"};
		table = new JTable(arr,column);
		//table.setBounds(30,40,500,300);
		JScrollPane sp = new JScrollPane(table);
		//table.setFillsViewportHeight(true);
		this.add(sp);
		this.repaint();
		
	}
	
	public void attenRosterDate(File atten, JButton dateButton) throws FileNotFoundException {
		this.removeAll();
		this.repaint();
		atten_file = atten;
		month1 = new JTextField("Month (Text)");
		day1 = new JTextField("Day (XX)");
		this.add(month1);
		this.add(day1);
		//this.add(d_B);
		this.add(dateButton);
		System.out.println("Displaying Date Prompt");
		this.repaint();
	}
	
	public void showAttendance() throws FileNotFoundException {
		this.month = month1.getText();
		this.day = day1.getText();
		System.out.println("Month: " + this.month);
		System.out.println("Day: " + this.day);
		this.removeAll();
		this.repaint();
		String[][] arr;
		arr = ctrl.attenTableData(atten_file, roster_file, 7);
		String column[] = {"ID","First Name", "Last Name", "Program", "Level", "ASURITE", month.substring(0,3) + " " + day};
		table = new JTable(arr,column);
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);
		this.repaint();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
