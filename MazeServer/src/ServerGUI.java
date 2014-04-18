
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;



public class ServerGUI {
	
	public ServerGUI() {
		JFrame frame = new JFrame();
		frame.setTitle("Maze Server");
		frame.setMinimumSize(new Dimension(1200, 1000));
		
//		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.NORTH);
//		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		
//		JButton btnStart = new JButton("Start");
//		btnStart.setMargin(new Insets(0, 1, 0, 1));
//		panel.add(btnStart);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new board());
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.ORANGE);
//		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
//		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
//		panel_1.add(new board());
	}
	
	public static void main(String[] args) throws Exception
	{
		new ServerGUI();
	}

}
