import javax.swing.*;

public class loadRoster {

    public static final String delimiter = ",";

    public static void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr : tempArr) {
                    System.out.print(tempStr + " ");
                }
                System.out.println();
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //csv = comma separated values
    //ID(int), FN(String), LN(String), Program(String), AL(String), ASURITE(String)
    //Six fields per row
    public static void loadRoster() {
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            File roster = fileChooser.getSelectedFile();
            String csvRoster = roster.getAbsolutePath();
            loadRoster.read(csvRoster);

    }
}
