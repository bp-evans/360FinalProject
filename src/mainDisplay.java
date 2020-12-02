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
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private ArrayList<String> month;
	private ArrayList<String> day; 
	private JTextField month1, day1;
	private File roster_file;
	private File atten_file;
	private controller ctrl;
	public String[][] arr;
	public String[] column;
	public boolean dateChosen;
	public int lines;
	private int countAtten;
	public int dateCount;
	
	public mainDisplay() {
		label = new JLabel("", SwingConstants.CENTER);
		this.add(label);
		//this.setLayout(new BorderLayout());
		ctrl = new controller();
		this.dateChosen = false;
		arr = null;
		column = null;
		countAtten = 7;
		dateCount = 0;
		month = new ArrayList<String>();
		day = new ArrayList<String>();
	}
	
	public void updateLabel(String arg) { // mainly for use with about
		label.setText(arg);
	}
	
	public void showRoster(File csv_file) throws FileNotFoundException {
		this.remove(this.label);
		this.repaint();
		roster_file = csv_file;
		arr = ctrl.tableData(csv_file,6);
		column = new String[] {"ID","First Name","Last Name","Program","Level","ASURITE"};
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
		this.month.add(month1.getText()); 
		this.day.add(day1.getText());
		dateCount++;
		System.out.println("Month: " + this.month);
		System.out.println("Day: " + this.day);
		this.removeAll();
		this.repaint();
		ctrl.processAttenFile(atten_file,roster_file);
		if(countAtten > 7) {
			arr = ctrl.attenAddData(atten_file,countAtten);
			column = ctrl.generateColumns(month, day, dateCount);
			//column = new String[] {"ID","First Name", "Last Name", "Program", "Level", "ASURITE", month.get(substring(0,3) + " " + day,"Other Date"};
		} else {
			arr = ctrl.attenTableData(atten_file, roster_file, countAtten);
			column = ctrl.generateColumns(month, day, dateCount);
			//column = new String[] {"ID","First Name", "Last Name", "Program", "Level", "ASURITE", month.substring(0,3) + " " + day};
		}
		
		
		this.lines = arr.length;
		
		table = new JTable(arr,column);
		JScrollPane sp = new JScrollPane(table);
		this.countAtten++;
		JOptionPane.showMessageDialog(this, "Data loaded for: " + ctrl.countLoad + " Users");
		this.add(sp);
		this.repaint();
	}

	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		ScatterPlot sc = new ScatterPlot(((Repository)o).getPoints());
	}
	
}







