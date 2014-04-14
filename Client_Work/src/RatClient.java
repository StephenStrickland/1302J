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
	Node head = null, currentNode;
	Boolean backtracking = false;

	HashMap<Integer, String> positionMap = new HashMap<Integer, String>();





	public void move(String newMove)
	{ 
		int branches = 0;
		Node tempNode;
		Boolean leftNode, rightNode, upNode, downNode;
		Boolean[] BoolNodes = new Boolean[4];

		//		for(int i = 0; i < BoolNodes.length; i++)
		//		{
		//			int path = i;
		//			if ((path%2 == 0) || (path == 0))
		//			{
		//				path++;
		//			}
		//			
		//			if (newMove.charAt(path) == 'p')
		//			{
		//				BoolNodes[i] = true;
		//			}
		//		}

		
		//also make sure that its not the opposite of current enum
		if((newMove.charAt(1) == 'p') && (currentNode.getENUM() != ENUM_FROM_DIR.RIGHT))
		{
			leftNode = true;
			currentNode.left.setENUM(ENUM_FROM_DIR.LEFT);
			branches++;
		}

		if((newMove.charAt(3) == 'p') && (currentNode.getENUM() != ENUM_FROM_DIR.LEFT))
		{
			rightNode = true;
			currentNode.right.setENUM(ENUM_FROM_DIR.RIGHT);
			branches++;
		}
		if((newMove.charAt(5) == 'p') && (currentNode.getENUM() != ENUM_FROM_DIR.UP))
		{
			downNode = true;
			currentNode.down.setENUM(ENUM_FROM_DIR.DOWN);
			branches++;
		}
		if((newMove.charAt(7) == 'p') && (currentNode.getENUM() != ENUM_FROM_DIR.DOWN))
		{
			upNode = true;
			currentNode.up.setENUM(ENUM_FROM_DIR.UP);
			branches++;
		}
		
		if((branches == 0))
		{
			backtrack();
		}
		
		
		//the overall order for everything is Right DOWN Left UP
		if((currentNode.right != null) && (currentNode.right.isDead() == false))
		{
			
		}
		else if((currentNode.down != null) && (currentNode.down.isDead() == false))
		{
			
		}
		else if((currentNode.left != null) && (currentNode.left.isDead() == false))
		{
			
		}
		
		else if((currentNode.up != null) && (currentNode.up.isDead() == false))
		{
			
		}
		else
		{
			backtrack();
		}
	



//
//		if(!(INVALID_MOVE))
//		{
//			tempNode.set
//		}
//		else
//		{
//
//		}




		//		if(head != null)
		//		{
		//		if (newMove == WIN)
		//		{
		//			System.out.println("You WIN!!!");
		//			break;
		//		}
		//			
		//		if( newMove != INVALID_MOVE)
		//		{
		//			
		//		}
		//		else
		//			backtrack();
		//		}
		//		else
		//			createHead(newMove);

	}





	private String backtrack() {
		//backtracks to previous node until other nodes != null
		//test for other available branches
		//the order of
		int ratPos = 0;
		char[] pos = currentNode.getLocation().toCharArray();
		//System.out.println(currentNode.getENUM() + " Opposite to the head node.");

		switch (currentNode.getENUM()) {
		case DOWN:
			ratPos = 1;
			break;
		case UP:
			ratPos = 7;
			break;

		case LEFT:
			ratPos = 5;
			break;

		case RIGHT:
			ratPos = 3;
			break;

		case HEAD:
			System.out.println("Reached the Head of the Tree, please restart maze");
			break;
		default:
			break;
		}

		pos[4] = 'p';
		pos[ratPos] = 'r';

		String new_Bactrack = new String(pos);

		currentNode.deadEnd = true;
		Node tempNode = currentNode.getPrevious();
		currentNode = tempNode;
		return new_Bactrack;
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

	//TESTING build several mazes slowly gaining complexity to the nth degree.

	//for mains, IF deadend, backtrack -- that was it will increment its way back to a node that it can search another branch.


	//

	//keep up with the min/max of y and x, that way we can print it out through a for loop and the dictionary


	//write test for first location, to see if we can find out if there is anything that we can find out about the location(like which corner, is it on an edge or in the middle)...

	//* dead end
	//+ path
	//@ mouse location


	//the overall order for everything is Right DOWN Left UP
	//
	//When new location comes in, find available paths and set enums for the according nodes, when backtracking all null nodes are assumed walls and the nodes with enums will be available to traverse through.
}
