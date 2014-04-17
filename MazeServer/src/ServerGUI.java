import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;


public class ServerGUI extends JFrame {
	public ServerGUI() {
		setTitle("Maze Server");
		setMinimumSize(new Dimension(1200, 1000));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnStart = new JButton("Start");
		panel.add(btnStart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
	}

}
