import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClientFrame extends JFrame {
	//private JTextField txtMs;
	
	 RatMap map = new RatMap();
	 JPanel glass;
	 JRadioButton rdbtnDebugMode = new JRadioButton();
	 JButton btnStart = new JButton();
	 JTextField txtMs = new JTextField();
	 boolean isClicked = false;
	 
	public ClientFrame() {
		setTitle("Rat Client");
		setSize(840, 890);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		//panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		
//		glass = new JPanel()
//		{
//		 public void painComponents(Graphics g)
//		 {
//			 g.setColor(new Color(1,0,0,0.5f));
//			 g.fillRect(10, 10, this.getWidth(), this.getHeight());
//		 }
//		};
				//(JPanel) getGlassPane();
//		glass.setOpaque(false);
//		setGlassPane(glass);
//		glass.setVisible(true);
		
		
		
		panel.setLayout(new MigLayout("", "[1000px]", "[16px][1300px]"));

		
		panel.add(map, "cell 0 1,grow");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isClicked = true;
			}
		});
		
		btnStart.setText("Start");
		panel.add(btnStart, "flowx,cell 0 0,alignx left,aligny top");
		
		
		
		
		rdbtnDebugMode.setText("Debug Mode");
		panel.add(rdbtnDebugMode, "cell 0 0,alignx right");
		
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
