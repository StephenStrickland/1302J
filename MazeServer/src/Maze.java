
import java.util.Arrays;
import java.lang.StringBuilder;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class Maze {

	char[] newMove = new char[9];

	int row, collumn,start, end, endcol, endrow, request;
	String[] mazeArr;



	public Maze(String[] arr)
	{
		mazeArr = arr;
		findStartEnd(arr[1], arr[99]);
	}



	public String getStart() {
		//String startLoc = new String(getLocation());
		String startLoc = new String(getLocation());
		return startLoc;
	}



	private void findStartEnd(String fStart, String fEnd) {

		//			boolean beg, end;

		start = fStart.indexOf('r');
		end = fEnd.indexOf('o');

		row = 1;
		collumn = start;

		endrow = 99;
		endcol = end;



	}



	public char[] move(char[] tempMove)
	{
		int pos;
		char[] currLoc = getLocation(); 
		char[] newLoc;


		//pos = Arrays.binarySearch(tempMove, 'r');
		pos = ArrayUtils.indexOf(tempMove, 'r');
		//pos = Arrays.binarySearch(tempMove, 'r');

		System.out.println("\nindex of rat in char[] : " + pos);


		if((currLoc[pos] == 'p') || (currLoc[pos] == 'o'))
		{
			if (pos == 1)
			{
				//up
				--row;
			}

			if (pos == 3)
			{
				//left
				--collumn;
			}

			if (pos == 5)
			{
				//rightooowpwwrw
				++collumn;
			}

			if (pos == 7)
			{
				//down
				++row;
			}

			if((row == endrow) && (collumn == endcol))
			{
				newLoc = "ooooooooo".toCharArray();
				System.out.println("Maze Completed");
			}
			else
			{
				newLoc = getLocation();
				System.out.println("Moving to: " + row + ',' + collumn);
			}
		}
		else
		{
			System.err.println("Attempted Move: " + tempMove);
			newLoc = "rrrrrrrrr".toCharArray();
			System.out.println("Invalid move");
		}

		return newLoc;


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



	//	private void updateMaze(int tempRow, int tempCol) {
	//		// TODO Auto-generated method stub
	//		//update Rat location
	//		
	//		//change char at rats current location to p
	//		
	//		//change char temps values to r
	//		
	//		//then set Location = Temps
	//		
	//		
	//		
	//		
	//	}

}
