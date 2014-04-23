import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import java.lang.String;
import java.util.Arrays;

public class RatMap extends JPanel implements ActionListener {
	
	int ratRow, ratCol;
	//private ImageIcon wall, path, out, rat;
	Map map;
	
	RatMap()
	{
		map = new Map();
		Timer timer  = new Timer(25, this);
		timer.start();
		
		validate();
	
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		for(int row = 0; row < 100; row++)
		{
			for(int col = 0; col < 100; col++)
			{
				if(map.getIndex(col, row) == 'w')
				{
					g.drawImage(map.getWall(), col*8, row*8, null);
				}
				
				if(map.getIndex(col, row) == 'p')
				{
					g.drawImage(map.getPath(), col*8, row*8, null);
				}
				
				if(map.getIndex(col, row) == 'o')
				{
					g.drawImage(map.getOut(), col*8, row*8, null);
				}
			}
		}
		
		g.drawImage(map.getRat(), ratRow*8, ratCol*8, null);

		
	}
	//messy but gets the job done.
	public void newPosition(String position, ENUM_FROM_DIR dir)
	{
		
		char[] pos = position.toCharArray();
		pos[4] = 'p';
		map.updateMaze(pos, ratRow, ratCol);
		
//		switch(dir)
//		{
//		case HEAD:
//			map.updateMaze(pos[0], ratRow-1, ratCol-1);
//			map.updateMaze(pos[1], ratRow, ratCol-1);
//			map.updateMaze(pos[2], ratRow+1, ratCol-1);
//			map.updateMaze(pos[3], ratRow-1, ratCol);
//			map.updateMaze(pos[4], ratRow, ratCol);
//			map.updateMaze(pos[5], ratRow+1, ratCol);
//			map.updateMaze(pos[6], ratRow-1, ratCol+1);
//			map.updateMaze(pos[7], ratRow, ratCol+1);
//			map.updateMaze(pos[8], ratRow+1, ratCol+1);
//			break;
//		case RIGHT:
//			int temprow = ratRow++;
//			map.updateMaze(pos[2], temprow, ratCol-1);
//			map.updateMaze(pos[5], temprow, ratCol);
//			map.updateMaze(pos[8], temprow, ratCol+1);
//			break;
//			
//		case LEFT:
//			temprow = ratRow--;
//			map.updateMaze(pos[0], temprow, ratCol-1);
//			map.updateMaze(pos[3], temprow, ratCol);
//			map.updateMaze(pos[6], temprow, ratCol+1);
//			break;
//			
//		case UP:
//			int tempCol = ratCol--;
//			map.updateMaze(pos[0], ratRow-1, tempCol);
//			map.updateMaze(pos[1], ratRow, tempCol);
//			map.updateMaze(pos[2], ratRow+1, tempCol);
//			break;
//		
//		case DOWN:
//			tempCol = ratCol++;
//			map.updateMaze(pos[6], ratRow-1, tempCol);
//			map.updateMaze(pos[7], ratRow, tempCol);
//			map.updateMaze(pos[8], ratRow+1, tempCol);
//		break;
//		
//		}
		
		
		
		
		
		
		
	}
	
	public void setRow(int i)
	{
		ratRow = i;
	}
	
	public void setCol(int i)
	{
		ratCol = i;
	}
	

	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

}
