
import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;

import javax.swing.*;


public class board extends JPanel implements ActionListener {
	
	
	Map map;
	int newRow, newCol, endRow, endCol;
	private Timer timer;
	
	public board() {
		map = new Map();
		//updates the board every 25 milliseconds
		timer  = new Timer(25, this);
		timer.start();
		
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);

		//iterate through the array and draw the images.
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
					g.drawImage(map.getOut(), col*8, row*8, null);
				}
			}
		}
	

		
		//Draw Start
		g.drawImage(map.getRat(), newCol*8, newRow*8, null);
	}

	//Setting the endlocation
	public void setEnd(Integer[] newLoc)
	{
		endRow = newLoc[0];
		endCol = newLoc[1];
	}
	//setting the start location
	public void updateLocation(Integer[] newLoc) 
	{
		newRow = newLoc[0];
		newCol = newLoc[1];
	}
	
	
	

}
