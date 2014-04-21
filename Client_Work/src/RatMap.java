import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class RatMap extends JPanel implements ActionListener {
	
	int ratRow, ratCol;
	private Image wall, path, out, rat;
	
	RatMap()
	{
		ImageIcon image  = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/wall.png");
		wall = image.getImage();
		image = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/path.png");
		path = image.getImage();
		image = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/rat.png");
		rat = image.getImage();
		image  = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/out.png");
		out = image.getImage();
		
		Timer timer  = new Timer(25, this);
	}


	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

}
