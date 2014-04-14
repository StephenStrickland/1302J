import java.util.HashMap;

/**
 * @author sstrickland
 *
 */


public class RatClient {
	static final String WIN = "ooooooooo";
	static final String LOST = "wwwwwwwww";
	static final String INVALID_MOVE = "rrrrrrrrr";
	int row, column, counter = 0;
	private Node head = null, current;
	Boolean backtracking = false;
	
	HashMap<Integer, String> positionMap = new HashMap<Integer, String>();
	
	
	
	
	
	public void move(String newMove)
	{
		
		if(head != null)
		{
		if (newMove == WIN)
		{
			System.out.println("You WIN!!!");
			break;
		}
			
		if( newMove != INVALID_MOVE)
		{
			
		}
		else
			backtrack();
		}
		else
			createHead(newMove);
		
	}





	private void backtrack() {
		//backtracks to previous node until other nodes != null
		
		
	}





	private void createHead(String loc) 
	{
		//	Creates head
		Node tempHead = new Node(loc, ENUM_FROM_DIR.HEAD, null);
		head = tempHead;
		addMap();
	}





	private void addMap() {
		counter++;
		StringBuilder sb = new StringBuilder();
		sb.append(column);
		sb.append('-');
		sb.append(row);
		//change this  - key is a string, (x~y) then value is the current Node;
		String newPosMapValue = sb.toString();
		
		if(positionMap.containsKey(counter) != true)
		{
		positionMap.put(counter, newPosMapValue);
		}
		else
			addMap();
		
	}
	
	//keep up with the min/max of y and x, that way we can print it out through a for loop and the dictionary
	
	
	//write test for first location, to see if we can find out if there is anything that we can find out about the location(like which corner, is it on an edge or in the middle)...
	
	//* dead end
	//+ path
	//@ mouse location
	

}
