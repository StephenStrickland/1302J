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
		
		String newPosMapValue = sb.toString();
		
		if(positionMap.containsKey(counter) != true)
		{
		positionMap.put(counter, newPosMapValue);
		}
		else
			addMap();
		
	}
	
	
	

}
