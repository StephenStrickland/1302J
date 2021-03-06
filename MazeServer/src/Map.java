//Stephen Strickland
//this was part of the same code that I learned in my Board Class
import java.awt.Image;
import javax.swing.ImageIcon;


public class Map {
	JReader read = new JReader("./Maze.txt");
	
	private String[] mazeArr = read.getArr();
	
	private Image wall, path, rat, out;
	
	public Map()
	{
		ImageIcon image  = new ImageIcon("./img/wall.png");
		wall = image.getImage();
		image = new ImageIcon("./img/path.png");
		path = image.getImage();
		image = new ImageIcon("./img/rat.png");
		rat = image.getImage();
		image  = new ImageIcon("./img/out.png");
		out = image.getImage();
	}
	
	public Image getPath()
	{
		return path;
	}
	
	public Image getWall()
	{
		return wall;
	}
	public Image getRat()
	{
		return rat;
	}
	
	public Image getOut()
	{
		return out;
	}
	
	public String getIndex(int x, int y)
	{
			String index = mazeArr[y].substring(x, x + 1);
			return index;
	}
	

}
