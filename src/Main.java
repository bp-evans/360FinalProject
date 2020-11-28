/*
Name: Brandon, Cameron, Ismael
Class ID: 70606
Assignment: Final Project
Description: This is the main class which sets up the JFrame and
			 JMenu.
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/*
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;
*/


public class Main extends JFrame implements ActionListener {
	
	private JFrame frame;
	mainDisplay disp;
	private JButton dateButton;
	
	public Main() {
		dateButton = new JButton("Enter Date Information");
		dateButton.setActionCommand("Get Date");
		dateButton.addActionListener(this);
		
		// Setting up the main JFrame
		//frame = new JFrame("CSE360 Final Project");
		this.setTitle("CSE 360 Final Project");
		// creating and adding the scroll bar
				
		disp = new mainDisplay(); 
	    this.add(disp);
	    
	    JMenuBar jMenuBar = new JMenuBar();
        this.setJMenuBar(jMenuBar);
        
        JMenu file = new JMenu("File");
        jMenuBar.add(file);

        //adds drop down options from file tab
        JMenuItem roster = new JMenuItem("Load a Roster");
        file.add(roster);
        roster.setActionCommand("roster");
        roster.addActionListener(this);
        
        JMenuItem attendance = new JMenuItem("Add Attendance");
        file.add(attendance);
        attendance.setActionCommand("Attendance");
        attendance.addActionListener(this);
        
        
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        save.setActionCommand("save");
        save.addActionListener(this);
        
        JMenuItem data = new JMenuItem("Plot Data");
        file.add(data);
        data.setActionCommand("add");
        data.addActionListener(this);
        
        //add about tab to menu
        JMenu about = new JMenu("About");
        jMenuBar.add(about);
        JMenuItem aboutPrint = new JMenuItem("About");
        about.add(aboutPrint);
        aboutPrint.setActionCommand("aboutPrint");
        aboutPrint.addActionListener(this);
       
	}
	
	public static void main(String[] args) {
		Main mainScreen = new Main();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setSize(1000,1000);
		mainScreen.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "aboutPrint") {
			System.out.println("Print the about information");
			disp.updateLabel("This project was completed by: Brandon, Ismael, Cameron");
		}
		else if(e.getActionCommand() == "save") {
			System.out.println("The data was saved");
		}
		else if(e.getActionCommand() == "roster") {
			System.out.println("Please select a csv file to upload");
			File csv_file = loadRoster.getFile(); //calls getFile from loadRoster allowing user to choose a file to upload
			try {
				disp.showRoster(csv_file);
				this.repaint();
				this.setVisible(true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // calls mainDisplay function to create table with file information
		}
		else if(e.getActionCommand() == "Attendance") {
			File attn_file = loadRoster.getFile();
			try {
				disp.attenRosterDate(attn_file,dateButton);
				this.repaint();
				this.setVisible(true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand() == "Get Date") {
			try {
				disp.showAttendance();
				this.repaint();
				this.setVisible(true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getActionCommand() == "add") {
			System.out.println("Plot the data");
			/*
			ScatterPlot plot = new ScatterPlot(); //instantiate new object
			plot.setSize(800,450);
			plot.setLocationRelativeTo(null);
			plot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close only plot window, not main program
			plot.setVisible(true);
			*/
		}
	}
}