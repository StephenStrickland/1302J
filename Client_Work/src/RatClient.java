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
	int row = 50, column = 0, counter = 0;
	Node head = null, currentNode;//, tempNode;
	Boolean backtracking = false;
	//int xy boundries
	HashMap<String, String> positionMap = new HashMap<String, String>();


	//start of mains

	public static void main(String args[]) throws Exception
	{
		String sentence;
		ClientFrame gui = new ClientFrame();
		//BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 13000); 

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter writeToServer = new PrintWriter(clientSocket.getOutputStream(), true);

		String serverResponse;
		RatClient rat = new RatClient();

		try
		{

			// print starting location
			serverResponse = inFromServer.readLine();
			System.out.println("FROM SERVER: " + serverResponse);
			rat.createHead(serverResponse);
			rat.findBranches(serverResponse);
			writeToServer.println(rat.move(serverResponse));
			gui.map.setRow(rat.row);
			gui.map.setCol(rat.column);
			gui.map.newPosition(serverResponse, rat.currentNode.getENUM());

			while (true)
			{

				serverResponse = inFromServer.readLine();

				if(serverResponse.equalsIgnoreCase(WIN))
				{
					System.out.println("You win, the end of the maze is at:" + rat.row +',' + rat.column);
					gui.setGlassVisible();
					//System.exit(0);
				}

				if(!serverResponse.equals(INVALID_MOVE))
				{	
					System.out.println("~FROM SERVER: " + serverResponse);
					//rat.currentNode.setLocation(serverResponse);
					rat.createNode(serverResponse);
					//rat.findBranches(serverResponse);
					writeToServer.println(rat.move(serverResponse));
					gui.map.setRow(rat.row);
					gui.map.setCol(rat.column);
					gui.map.newPosition(serverResponse, rat.currentNode.getENUM());

					try
					{
						Thread.sleep(200);
					}
					catch(InterruptedException ex)
					{
						Thread.currentThread().interrupt();
					}

				}
				else
				{
					writeToServer.println(rat.backtrack());
				}


			}
		}
		finally
		{
			clientSocket.close();
		}
	}

	private void findBranches(String newMove) 
	{
		if(newMove.charAt(3) != 'w')
		{
			if(NodeTest(currentNode, ENUM_FROM_DIR.RIGHT))
				currentNode.createNode(3);
			//else
				//currentNode.left.setPrevious(currentNode);
		}

		if((newMove.charAt(5) != 'w') )
		{
			if (NodeTest(currentNode, ENUM_FROM_DIR.LEFT))
				currentNode.createNode(1);	
		//	else
			//	currentNode.right.setPrevious(currentNode);
		}

		if((newMove.charAt(7) != 'w'))
		{
			if(NodeTest(currentNode, ENUM_FROM_DIR.UP))
				currentNode.createNode(2);
		//	else
			//	currentNode.down.setPrevious(currentNode);
		}
		if(newMove.charAt(1) != 'w')
		{
			if(NodeTest(currentNode, ENUM_FROM_DIR.DOWN))
				currentNode.createNode(4);
			//else
				//currentNode.up.setPrevious(currentNode);
		}

	}

	//end of mains


	public void createNode(String serverResponse)
	{
		if(!currentNode.isDead())
		{
			currentNode.setLocation(serverResponse);
//			tempNode = null;
//			tempNode = new Node();
//			tempNode.setPrevious(currentNode);
			findBranches(serverResponse);
		}

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

		if((currentNode.isDead() != true) || (!positionMap.containsValue(mapBuilder(row, column))))
		{
			if(NodeTest(currentNode.right, ENUM_FROM_DIR.LEFT))
			{
				//move RIGHT
				row++;
				newPos = createString(newMove,5);

				//tempNode.setENUM(ENUM_FROM_DIR.RIGHT);
			//	currentNode.right.setENUM(ENUM_FROM_DIR.RIGHT);;
				currentNode = currentNode.right;


			}
			else if(NodeTest(currentNode.down, ENUM_FROM_DIR.UP))
			{
				//move DOWN
				column++;
				newPos = createString(newMove,7);
			//	tempNode.setENUM(ENUM_FROM_DIR.DOWN);
			//	currentNode.down.setENUM(ENUM_FROM_DIR.DOWN);;
				currentNode = currentNode.down;
			}
			else if(NodeTest(currentNode.left, ENUM_FROM_DIR.RIGHT))
			{
				//move LEFT
				row--;
				newPos = createString(newMove,3);

			//	tempNode.setENUM(ENUM_FROM_DIR.LEFT);
				//currentNode.left.setENUM(ENUM_FROM_DIR.LEFT);
				currentNode = currentNode.left;
			}
// && (!positionMap.containsValue(mapBuilder(row, column-1)))
			else if(NodeTest(currentNode.up, ENUM_FROM_DIR.DOWN))
			{
				//move UP
				column--;
				newPos = createString(newMove,1);
				//tempNode.setENUM(ENUM_FROM_DIR.UP);
				//currentNode.up.setENUM(ENUM_FROM_DIR.UP);;
				currentNode = currentNode.up;
			}
			else
			{
				//all else is null backtrack.
				newPos = backtrack();
			}
			//currentNode = tempNode;

		}
		else
			newPos = backtrack();


		//updateBoundries();


		addMap();
		return newPos;

	}

	private Boolean NodeTest(Node nod, ENUM_FROM_DIR en)
	{
		Boolean isAvailable;

		if((nod != null) && (!nod.isDead()) && nod.getENUM() != en)
			isAvailable = true;
		else
			isAvailable = false;

		return isAvailable;

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

		switch (currentNode.getENUM()) {
		case DOWN:
			column--;
			ratPos = 1;
			currentNode.setDead(true);
			currentNode.getPrevious().down.setDead(true);
			//tempNode.setDead(true);
			break;
		case UP:
			column++;
			ratPos = 7;
			currentNode.setDead(true);
			currentNode.getPrevious().up.setDead(true);
			//tempNode.setDead(true);
			break;


		case LEFT:
			row++;
			ratPos = 5;
			currentNode.setDead(true);
			currentNode.getPrevious().left.setDead(true);
			//tempNode.setDead(true);
			break;

		case RIGHT:
			row--;
			ratPos = 3;
			currentNode.setDead(true);
			currentNode.getPrevious().right.setDead(true);
			//tempNode.setDead(true);
			break;

		case HEAD:
			System.err.println("Reached the Head of the Tree, please restart maze");
			break;
		default:
			break;
		}

		String new_Bactrack = createString(currentNode.getLocation(), ratPos);

		// tempNode.setDead(true);
		Node tempNod = currentNode.getPrevious();
		currentNode = tempNod;
		//tempNode = tempNod;
		//currentNode.setDead(true);
		//		Node tempNode = currentNode.getPrevious();
		//		currentNode = tempNode;
		return new_Bactrack;
	}





	private void createHead(String loc) 
	{
		//	Creates head
		head = new Node(loc, ENUM_FROM_DIR.HEAD, null);
		//head = tempNode;
		currentNode = head;
//		currentNode.setPrevious(head);
//		Node tempNode = new Node();
//		tempNode.setPrevious(currentNode);
		addMap();
		//updateboundries();
	}



	private String mapBuilder(int x, int y)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		sb.append('~');
		sb.append(y);

		String newPosMapValue = sb.toString();
		return newPosMapValue;

	}

	private void addMap() {
		positionMap.put(currentNode.getLocation(), mapBuilder(row, column));
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
