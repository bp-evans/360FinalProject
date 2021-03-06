//sets up the JFrame

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;



public class Main extends JFrame implements ActionListener {
	
	private JFrame frame;
	private commandListener listen;
	mainDisplay disp;
	
	public Main() {
		
		listen = new commandListener();
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
			
		}
		else if(e.getActionCommand() == "roster") {
			System.out.println("Please select a csv file to upload");
			loadRoster.getFile(); //calls getFile from loadRoster allowing user to choose a file to upload
		}
		else if(e.getActionCommand() == "Attendance") {
			System.out.println("The data was saved");
		}
		else if(e.getActionCommand() == "add") {
			System.out.println("Plot the data");
			
			ScatterPlot plot = new ScatterPlot(); //instantiate new object
			plot.setSize(800,450);
			plot.setLocationRelativeTo(null);
			plot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close only plot window, not main program
			plot.setVisible(true);
		}
	}
}