/*
Name: Brandon, Cameron, Ismael
Class ID: 70606
Assignment: Final Project
Description: This is the loadRoster class which prompts the user
			 to select a CSV file.
*/

import java.io.File;

import javax.swing.*;

public class loadRoster {
	
	private static File csv_file = null;
	//csv = comma separated values
    //ID(int), FN(String), LN(String), Program(String), AL(String), ASURITE(String)
    //Six fields per row
    
	public static File getFile() {
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Please Select a CSV file to Load");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
        	csv_file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        	System.out.println("File has been chosen");
        }
        
        return csv_file;

    }
}