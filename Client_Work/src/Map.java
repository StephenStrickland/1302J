//Stephen Strickland
//this was part of the same code that I learned in my Board Class
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;


public class Map {
	
	char[][] mazeArr = new char[100][100];
	private Image wall, path, rat, out;
	
	public Map()
	{
		for(char[] row : mazeArr)
			Arrays.fill(row, 'w');
		
		ImageIcon image  = new ImageIcon(getClass().getResource("/Client_Work/img/rat.png"));
		wall = image.getImage();
//		image = new ImageIcon("/img/path.png");
//		path = image.getImage();
//		image = new ImageIcon("/img/rat.png");
//		rat = image.getImage();
//		image  = new ImageIcon("/img/out.png");
//		out = image.getImage();
	}
	
	public void updateMaze(char[] c, int x, int y)
	{
		int counter = 0;
		for(int col = y - 1; col < y+2; col++)
		{
			for(int row = x - 1; row < x+2; row++)
			{
				char jk = c[counter];
				mazeArr[col][row] = jk;
				counter++;	
			}
		}
		
		//mazeArr[y][x] = c;
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
