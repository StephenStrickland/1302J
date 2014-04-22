//Stephen Strickland
//this was part of the same code that I learned in my Board Class
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Arrays;


public class Map {
	
	char[][] mazeArr = new char[100][100];
	private Image wall, path, rat, out;
	
	public Map()
	{
		for(char[] row : mazeArr)
			Arrays.fill(row, 'w');
		
		ImageIcon image  = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/wall.png");
		wall = image.getImage();
		image = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/path.png");
		path = image.getImage();
		image = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/rat.png");
		rat = image.getImage();
		image  = new ImageIcon("/Users/stephen/GitProjects/1302J/Client_Work/img/out.png");
		out = image.getImage();
	}
	
	public void updateMaze(char c, int x, int y)
	{
		mazeArr[y][x] = c;
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
	
	public char getIndex(int x, int y)
	{
			char index = mazeArr[y][x];
			return index;
	}
	

}
