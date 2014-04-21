//Stephen Strickland
//This is the maze class, it handles the current location of the rat and its movements

import java.lang.StringBuilder;
//this is a fantastic library...
import org.apache.commons.lang.ArrayUtils;

public class Maze {

	char[] newMove = new char[9];
	int row, collumn,start, end, endcol, endrow, request;
	String[] mazeArr;

	public Maze(String[] arr)
	{
		//initialize our main array.
		mazeArr = arr;
		findStartEnd(arr[1], arr[98]);
	}

	public String getStart() 
	{
		//gets the initial start position String
		String startLoc = new String(getLocation());
		return startLoc;
	}


	private void findStartEnd(String fStart, String fEnd) 
	{
		//my maze will start from the top and will finish at the bottom, so we can assume that the maze start will be on the arrays 
		start = fStart.indexOf('r');
		end = fEnd.substring(1, 98).indexOf('o') + 1;

		row = 1;
		collumn = start;

		endrow = 99;
		endcol = end;
	}

	public char[] move(char[] tempMove)
	{
		int pos;
		char[] currLoc = getLocation(); 
		char[] newLoc = null;

		pos = ArrayUtils.indexOf(tempMove, 'r');

		System.out.println("\nindex of rat in char[] : " + pos);

		if(currLoc[pos] != 'w')
		{
			switch(pos) {
			case 1: 
				//up
				--row;
				break;
			case 3:
				//left
				--collumn;
				break;
			case 5:
				//right
				++collumn;
				break;
			case 7:
				//down
				++row;
				break;
			}

			if((row == endrow) && (collumn == endcol) )
			{
				newLoc = "ooooooooo".toCharArray();
				System.out.println("Maze Completed");
			}
			else
			{
				try {
					newLoc = getLocation();
					System.out.println("Moving to: " + row + ',' + collumn);

				} catch (Exception e) {
					System.err.println("INVALID MOVE");
				}
			}
		}
		else
		{
			System.err.println("Attempted Move: " + tempMove.toString());
			newLoc = "rrrrrrrrr".toCharArray();
			System.out.println("Invalid move");
		}

		return newLoc;
	}

	public Integer[] getCurrentLocation() {

		Integer[] curLoc = new Integer[2];
		curLoc[0] = row;
		curLoc[1] = collumn;
		return curLoc;
	}

	public Integer[] getEndLocation()
	{
		Integer[] end = new Integer[2];
		end[0] = endrow;
		end[1] = endcol;
		return end;
	}

	private char[] getLocation() {
		char[] location = new char[9];
		// rat is @ row col.

		StringBuilder SB = new StringBuilder();


		for(int i = (row - 1); i <= (row + 1); i++)
		{
			SB.append(mazeArr[i].substring(collumn - 1, collumn + 2));
		}

		//construct char array
		String tempLoc = SB.toString();

		location = tempLoc.toCharArray();
		location[4] = 'r';

		if(location[1] == 'r')
			location[1] = 'p';

		//System.out.println(location);

		// need row-1, row, row+1
		return location;
	}

}
