import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class mainDisplay extends JPanel implements Observer {
	
	public JScrollPane createScroll() {
		JPanel scrollPanel = new JPanel();
		JScrollPane scrollBar=new JScrollPane(scrollPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		return scrollBar;
	}
	
	public JLabel createLabel(String arg) {
		JLabel label = new JLabel(arg);
		return label;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
