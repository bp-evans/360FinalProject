import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class commandListener implements ActionListener {
	public String label;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "aboutPrint") {
			System.out.println("Print the about information");
		}
	}
}