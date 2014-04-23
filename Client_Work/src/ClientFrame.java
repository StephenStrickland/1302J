import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import java.awt.Button;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;


public class ClientFrame extends JFrame {
	private JTextField txtMs;
	
	 RatMap map = new RatMap();
	 JPanel glass;
	public ClientFrame() {
		setTitle("Rat Client");
		setSize(850, 900);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		//panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		glass = new JPanel()
		{
		 public void painComponents(Graphics g)
		 {
			 g.setColor(new Color(1,0,0,0.5f));
			 g.fillRect(10, 10, this.getWidth(), this.getHeight());
		 }
		};
				//(JPanel) getGlassPane();
		glass.setOpaque(false);
		setGlassPane(glass);
		glass.setVisible(true);
		
		
		
		panel.setLayout(new MigLayout("", "[1000px]", "[16px][1300px]"));

		
		panel.add(map, "cell 0 1,grow");
		
		JButton btnStart = new JButton("Start");
		panel.add(btnStart, "flowx,cell 0 0,alignx left,aligny top");
		
		
		JRadioButton rdbtnDebugMode = new JRadioButton("Debug Mode");
		panel.add(rdbtnDebugMode, "cell 0 0,alignx right");
		
		txtMs = new JTextField();
		txtMs.setToolTipText("Insert the number of milliseconds desired for debug");
		txtMs.setText("milliseconds");
		panel.add(txtMs, "cell 0 0,alignx right");
		txtMs.setColumns(10);
		
		setVisible(true);
		
	}
	
	public void setGlassVisible()
	{
		glass.setVisible(true);
	}

}
