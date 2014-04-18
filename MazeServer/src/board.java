
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


public class board extends JPanel {
	
	
	Map map;
	
	public board() {
		map = new Map();
		
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
//		g.setColor(Color.darkGray);
//		g.fillRect(45, 60, 16, 16);
		
		for(int row = 0; row < 100; row++)
		{
			for(int col = 0; col < 100; row++)
			{
				if(map.getIndex(col, row).equals("w"))
				{
					g.drawImage(map.getWall(), col*8, row*8, null);
				}
				
				if(map.getIndex(col, row).equals("p"))
				{
					g.drawImage(map.getPath(), col*8, row*8, null);
				}
			}
		}
	}
	
	
	

}
