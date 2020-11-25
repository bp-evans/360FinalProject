import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu{
    public static void main(String args[]){
        //create JPanel
        JPanel panel = new JPanel();

        //Create vertical and horizontal scroll bars
        JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //create JFrame titled "CSE360 Final Project" and its attributes
        JFrame frame = new JFrame("CSE360 Final Project");
        frame.add(scrollBar);
        frame.setVisible(true);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create menu bar attached to JFrame
        JMenuBar jMenuBar = new JMenuBar();
        frame.setJMenuBar(jMenuBar);

        //add file tab to menu
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

        //add about tab to menu
        JMenu about = new JMenu("About");
        jMenuBar.add(about);

        //Needs to put info from a csv table into table, exits currently 
        class loadRoster implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        }
        roster.addActionListener(new loadRoster());
    }
}
