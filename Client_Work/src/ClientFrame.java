//Stephen Strickland
//My JFrame Class
//handles the GUI for the Project
//I used Elcipse's window builder for the creation of this. 
//I had to keep everything in a certain format so that it cold parse what I developed. 
//the window builder was great because it allowed me to do quick prototyping of this frame.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class ClientFrame extends JFrame {
	//private JTextField txtMs;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6505600518828054109L;

	RatMap map = new RatMap();
	JPanel glass;
	JRadioButton rdbtnDebugMode = new JRadioButton();
	JButton btnStart = new JButton();
	JTextField txtMs = new JTextField();
	boolean isClicked = false;
	private final JLabel lblMs = new JLabel("ms");

	public ClientFrame() {
		setTitle("Rat Client");
		//set size, I did not want my window to be able to resize.
		setSize(832, 890);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//our main panel that everything is placed on
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		//one of the better java layout managers
		panel.setLayout(new MigLayout("", "[1000px]", "[16px][1300px]"));
		//adding the map
		panel.add(map, "cell 0 1,grow");
		//adding the start button, with a listener. This is just the way is played out, 
		//but this is not the most efficient way of doing the start button
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isClicked = true;
			}
		});
		btnStart.setText("Start");
		panel.add(btnStart, "flowx,cell 0 0,alignx left,aligny top");

		//this is the radio debug mode button, if this is selected when you click start, 
		//the value in the txtMs will be the value of the thread.sleep(debug)
		rdbtnDebugMode.setText("Debug Mode");
		panel.add(rdbtnDebugMode, "cell 0 0,alignx right");
		
		txtMs.setToolTipText("Insert the number of milliseconds desired for debug");
		//txtMs.setText("milliseconds");
		panel.add(txtMs, "cell 0 0,alignx right");
		txtMs.setColumns(3);
		
		panel.add(lblMs, "cell 0 0");
		//finally set Frame to visible
		setVisible(true);

	}

	public void setGlassVisible()
	{
		glass.setVisible(true);
	}

}
