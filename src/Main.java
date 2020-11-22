import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
			System.out.println("Save was selected");
			disp.removeLabel();
		}
		else if(e.getActionCommand() == "roter") {
			
		}
		else if(e.getActionCommand() == "Attendance") {
			
		}
		else if(e.getActionCommand() == "add") {
			
		}
	}
	
}
