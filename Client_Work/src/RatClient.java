

/**
 * @author sstrickland
 *
 */



public class RatClient {
	static final String WIN = "ooooooooo";
	static final String LOST = "wwwwwwwww";
	static final String INVALID_MOVE = "rrrrrrrrr";
	private Node head;
	Boolean backtracking = false;
	
	
	
	
	
	public void move(String newMove)
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
	
	
	

}
