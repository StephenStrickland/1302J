//Stephen Strickland

//watched a youtube tutorial on game making for some tips on creating my maze; but I never used any of his source code.
//check it out: https://www.youtube.com/watch?v=fn-T7J1ytMc&list=PLA38BD857DC0EE786&index=5

import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;


public class Board extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2900749320141558719L;
	//declare variables, etc...
	Map map;
	int newRow, newCol, endRow, endCol;
	private Timer timer;
	
	public Board() {
		map = new Map();
		//updates the board every 25 milliseconds. Calls actionpPrformed();
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//calls repaint method
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

		//Draw Rat
		g.drawImage(map.getRat(), newCol*8, newRow*8, null);
	}

	//setting the start location
	public void updateLocation(Integer[] newLoc) 
	{
		newRow = newLoc[0];
		newCol = newLoc[1];
	}
}
