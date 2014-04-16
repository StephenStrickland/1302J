import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;


/**
 * @author sstrickland
 *
 */


public class RatClient {
	static final String WIN = "ooooooooo";
	static final String LOST = "wwwwwwwww";
	static final String INVALID_MOVE = "rrrrrrrrr";
	int row = 0, column = 0, counter = 0;
	Node head = null, currentNode, tempNode;
	Boolean backtracking = false;
	//int xy boundries
	HashMap<Integer, String> positionMap = new HashMap<Integer, String>();
	
	
	//start of mains

	public static void main(String argv[]) throws Exception
	{
		String sentence;
		//BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 13000); 

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter writeToServer = new PrintWriter(clientSocket.getOutputStream(), true);

		String serverResponse;
		RatClient rat = new RatClient();

		try
		{

			//DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

			// print starting location
			serverResponse = inFromServer.readLine();
			System.out.println("FROM SERVER: " + serverResponse);
			rat.createHead(serverResponse);
			rat.findBranches(serverResponse);
			writeToServer.println(rat.move(serverResponse));


			while (true)
			{

				serverResponse = inFromServer.readLine();

				if(serverResponse.equalsIgnoreCase(WIN))
				{
					System.out.println("You win, the end of the maze is at:" + rat.row +',' + rat.column);
					System.exit(0);
				}
				
				if(!serverResponse.equals(INVALID_MOVE))
				{	
					System.out.println("~FROM SERVER: " + serverResponse);
					//rat.currentNode.setLocation(serverResponse);
					rat.createNode(serverResponse);
					rat.findBranches(serverResponse);
					writeToServer.println(rat.move(serverResponse));


				}
				else
				{
					writeToServer.println(rat.backtrack());
				}


				//rat.repaint();

			}
		}
		finally
		{
			clientSocket.close();
		}
	}
	
	private void findBranches(String newMove) 
	{
		int branches = 0;
		//tempNode = new Node();
		//ooowrwwpw
		if((newMove.charAt(3) == 'p'))
		{
			if(tempNode.left == null)
				tempNode.createNode(3);
			tempNode.left.setENUM(ENUM_FROM_DIR.LEFT);
			branches++;
		}

		if((newMove.charAt(5) == 'p'))
		{
			if(tempNode.right == null)
				tempNode.createNode(1);
			tempNode.right.setENUM(ENUM_FROM_DIR.RIGHT);
			branches++;
		}

		if((newMove.charAt(7) != 'w'))
		{
			if(tempNode.down == null)
				tempNode.createNode(2);
				
			tempNode.down.setENUM(ENUM_FROM_DIR.DOWN);
			branches++;
		}
		if((newMove.charAt(1) == 'p'))
		{
			if(tempNode.up == null)
				tempNode.createNode(4);
			tempNode.up.setENUM(ENUM_FROM_DIR.UP);
			branches++;
		}

		if((branches == 0))
		{
			backtrack();
		}

		
	}

	//end of mains


	public void createNode(String serverResponse)
	{
		tempNode = new Node();
		currentNode.setLocation(serverResponse);
		tempNode.setPrevious(currentNode);
		
	}


	//ORDER OF OPERATIONS
	//get string
	//find new nodes that havent been created(hashmap). checking x,y values if exxists in hasmap.
	//select the next node to traverse
	//send new string for movement(if valid update x,y position)
	//repeat till deadend, bactrack

	//maze make new paths(attach side nodes)
	//pick next path
	//deadend = backtrack()


	//get string in temp
	//create tempnode
	//instantiate tempnode(tempstring, enum, ...)
	//set tempnode.previous to currentnode
	//currentnode = tempnode

	public String move(String newMove)
	{ 
		String newPos;


		//the overall order for everything is Right DOWN Left UP
		//just need to see if theres a difference between !null and enums !null.
		//tempNode.setLocation(newMove);
		//tempNode.setPrevious(currentNode);
		

		if((currentNode.right != null) && (currentNode.right.isDead() != true))
		{
			//move RIGHT
			row++;
			newPos = createString(newMove,5);

			tempNode.setENUM(ENUM_FROM_DIR.RIGHT);
			currentNode.right = tempNode;
			
			
		}
		else if((tempNode.down != null) && (tempNode.down.isDead() != true))
		{
			//move DOWN
			column++;
			newPos = createString(newMove,7);
			tempNode.setENUM(ENUM_FROM_DIR.DOWN);
			currentNode.down = tempNode;
		}
		else if((currentNode.left != null) && (currentNode.left.isDead() != true))
		{
			//move LEFT
			row--;
			newPos = createString(newMove,3);
		}

		else if((currentNode.up != null) && (currentNode.up.isDead() != true))
		{
			//move UP
			column--;
			newPos = createString(newMove,1);
		}
		else
		{
			//all else is null backtrack.
			newPos = backtrack();
		}
		
		
		addMap();
		//updateBoundries();
		currentNode = tempNode;
		tempNode = null;
		
		return newPos;

	}



	private String createString(String Pos, int i) {
		
		char[] j = Pos.toCharArray();
		
		j[4] = 'p';
		j[i] = 'r';
		
		String move = new String(j);
		
		
		return move;
	}

	private String backtrack() {
		//backtracks to previous node until other nodes != null
		//test for other available branches
		//the order of
		int ratPos = 0;
		char[] pos = currentNode.getLocation().toCharArray();

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
			System.err.println("Reached the Head of the Tree, please restart maze");
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
		//Node tempHead = new Node(loc, ENUM_FROM_DIR.HEAD, null);
		//tempNode = tempHead;
	
		head = new Node(loc, ENUM_FROM_DIR.HEAD, null);
		//head = tempNode;
		currentNode = new Node();
		currentNode.setPrevious(head);
		tempNode = new Node();
		tempNode.setPrevious(currentNode);
		addMap();
		//updateboundries();
	}





	private void addMap() {
		counter++;
		StringBuilder sb = new StringBuilder();
		sb.append(column);
		sb.append('~');
		sb.append(row);
		//change this  - key is a string of the location, (x~y) then value is the current Node;

		//x~y makes sure it can keep up with negative values. 
		// ---- dash changed to tilde-----

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
