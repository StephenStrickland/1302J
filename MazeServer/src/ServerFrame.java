//Stephen Strickland
//The Jframe for the Server GUI

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Component;


public class ServerFrame extends JFrame {
	/**
	 * This serial version was automatically generated.
	 */
	private static final long serialVersionUID = -3384245586477323684L;
	Board b = new Board();
	JLabel lblClientsConnected;
	public ServerFrame() {
		
		setTitle("Maze Server");
		setLocationRelativeTo(null);
		//I do not want my window to scale or move so...
		setMinimumSize(new Dimension(832, 875));
		setMaximumSize(new Dimension(832, 875));
		getContentPane().setLayout(new CardLayout(0, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Panel that contains our Board and Jlabel
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_1397937270295564000");
		panel.setBackground(new Color(238, 238, 238));
		panel.setLayout(new MigLayout("", "[800px,grow]", "[][29px,grow]"));
		panel.add(b, "cell 0 1,grow");
		
		lblClientsConnected = new JLabel("Waiting for Client to Connect...");
		lblClientsConnected.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblClientsConnected, "cell 0 0");
		//finally make it visible
		setVisible(true);
	}
}
