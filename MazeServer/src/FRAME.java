import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;


public class FRAME extends JFrame {
	public FRAME() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblTest = new JLabel("TEST");
		panel.add(lblTest);
		
		JLabel lblTest_1 = new JLabel("TEST");
		panel.add(lblTest_1);
		
		JLabel lblTest_2 = new JLabel("Test");
		panel.add(lblTest_2);
		
		JLabel lblTest_3 = new JLabel("Test");
		panel.add(lblTest_3);
	}

}
