import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame {
	private static JFrame frame;
	//private static commandListener listen;
	public Main() {
		
	}
	public static void main(String[] args) {
		//listen = new commandListener();
		// Setting up the main JFrame
		frame = new JFrame("CSE360 Final Project");
        // creating and adding the scroll bar
		
        //mainDisplay disp = new mainDisplay(); SCROLL BAR IS DISABLED FOR NOW, NEED TO FIGURE OUT HOW TO ADD STUFF INSIDE IT
        //frame.add(disp.createScroll());
		
		
        frame.setVisible(true);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JMenuBar jMenuBar = new JMenuBar();
        frame.setJMenuBar(jMenuBar);
        
        JMenu file = new JMenu("File");
        jMenuBar.add(file);

        //adds drop down options from file tab
        JMenuItem roster = new JMenuItem("Load a Roster");
        file.add(roster);
        JMenuItem attendance = new JMenuItem("Add Attendance");
        file.add(attendance);
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        JMenuItem data = new JMenuItem("Plot Data");
        file.add(data);
        
        class commandListener2 implements ActionListener {
        	public String label;
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getActionCommand() == "aboutPrint") {
        			System.out.println("Print the about information");
        			JLabel label = new JLabel("About stuff");
        			frame.add(label);
        		}
        	}
        }

        //add about tab to menu
        commandListener2 listen2 = new commandListener2();
        JMenu about = new JMenu("About");
        jMenuBar.add(about);
        JMenuItem aboutPrint = new JMenuItem("About");
        about.add(aboutPrint);
        aboutPrint.setActionCommand("aboutPrint");
        aboutPrint.addActionListener(listen2);
      
        
	}
}
