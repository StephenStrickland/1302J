
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

		
		for(int row = 0; row < 100; row++)
		{
			for(int col = 0; col < 100; col++)
			{
				if(map.getIndex(col, row).equals("w"))
				{
					g.drawImage(map.getWall(), col*8, row*8, null);
				}
				
				if(map.getIndex(col, row).equals("p"))
				{
					g.drawImage(map.getPath(), col*8, row*8, null);
				}
				if(map.getIndex(col, row).equals("o"))
				{
					g.drawImage(map.getWall(), col*8, row*8, null);
				}
			}
		}
	}

	public void repaintLoc() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
