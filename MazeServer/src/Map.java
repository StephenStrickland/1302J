import java.awt.Image;

import javax.swing.ImageIcon;


public class Map {
	JReader read = new JReader("/Users/stephen/GitProjects/1302J/JARS/Maze.txt");
	
	private String[] mazeArr = read.getArr();
	
	private Image wall, path, rat;
	
	public Map()
	{
		ImageIcon image  = new ImageIcon("/Users/stephen/GitProjects/1302J/JARS/img/wall.png");
		wall = image.getImage();
		image = new ImageIcon("/Users/stephen/GitProjects/1302J/JARS/img/path.png");
		path = image.getImage();
		image = new ImageIcon("/Users/stephen/GitProjects/1302J/JARS/img/rat.png");
		rat = image.getImage();
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
	
	public String getIndex(int x, int y)
	{
			String index = mazeArr[y].substring(x, x + 1);
			return index;
	}
	

}
