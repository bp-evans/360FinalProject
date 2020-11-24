import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class mainDisplay extends JPanel implements Observer {
	
	private JLabel label;
	
	public mainDisplay() {
		label = new JLabel("Test Label",SwingConstants.CENTER);
		this.add(label);
		
	}
	
	public void updateLabel(String arg) { // mainly for use with about
		label.setText(arg);
	}

	public void Names(){ //displays names when about is clicked
		JOptionPane.showMessageDialog(this, "This project was completed by: Brandon, Ismael, and Cameron");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
