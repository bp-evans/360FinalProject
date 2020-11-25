//prompts user to
import javax.swing.*;

public class loadRoster {

    //csv = comma separated values
    //ID(int), FN(String), LN(String), Program(String), AL(String), ASURITE(String)
    //Six fields per row
    public static void getFile() {
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Please Select a CSV file to Load");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
            //fileChooser.getSelectedFile().getAbsolutePath();
        }

    }
}