import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;


public class ServerFrame extends JFrame {
	board b = new board();
	JLabel lblClientsConnected;
	public ServerFrame() {
		setTitle("Maze Server");
		setMinimumSize(new Dimension(830, 872));
		getContentPane().setLayout(new CardLayout(0, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_1397937270295564000");
		panel.setBackground(Color.orange);
		panel.setLayout(new MigLayout("", "[800px,grow]", "[][29px,grow]"));
		
		//JPanel panel_1 = new JPanel();
		
		panel.add(b, "cell 0 1,grow");
		
		lblClientsConnected = new JLabel("Waiting for Client to Connect...");
		lblClientsConnected.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblClientsConnected, "cell 0 0");
		
		setVisible(true);
	}
}
