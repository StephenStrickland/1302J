1302J
=====

Creator: Stephen Strickland <br>
Professor: John Vande Ven

#####Purpose:

To create a Maze server and a Rat Client to communicate over TCP/IP and solve a maze.

The Rat only knows the initial surrounding cells. Visually this is repesented in a grid: <br>

ooo <br>
wrw <br>
wpw <br>

Where 
  o = outside of the maze <br>
  w = walls <br>
  p = available paths <br>
  r = the current location of the rat <br>
  
This grid then translates to a 9 character String(ooowrwwpw)that is sent to and from the server/client.

When the rat moves it updates the location of the rat (r) in the string and sends it to the server.

The server then recieves this updated strings, updates the rats new position and sends the new surrounding cells to the rat.

The size of this maze is a 100x100 cells.

Plan of Action
-----

My orginal thought was to create a tree with all possible moves(10,000) and brute force my way through the maze.

That way if one direction was not possible, the tree could remove all subsequent children.

This method would be very fast, especially with this scale of a maze.

Not that there really is any true AI out there, but I wanted to make my rat "smart".

So I have created a Node that represents each of the rats locations.

Classes
------

###Node
```java
  public class Node{
	Node left, right, up, down, previous;
	Boolean deadEnd, walked;
	String location;
	ENUM_FROM_DIR fromDir;
```

As you can see I have 5 nodes attached to each node, one for each direction and one for the previous node.
I have two booleans for status updates to see if this node has been traverse and if it and/or its children are dead ends. 

The string holds its location and finally an enum. 

This enum tells me which direction the current node is a child of. If the enum is right, then I know that the previous' right child is my node and in order to back track I need to go left.

###JReader
I use googles GSON library to handle reading in a JSON array that is in a text file, its fast and easy and keeps me and my code from making a mistake. I just point the reader to the appropriate file and boom, I have a maze I can work with.
```
JsonReader reader  = new JsonReader(new FileReader(path));
```

###Socket Server

This handles the Socket(port 13000) and updating the rat's location.

It opens a socket
```
socket = new ServerSocket(13000);
```

And waits for a connection.

Once a client connects it initializes a BufferedReader and a Printwriter.

JReader then reads in the maze from the JSON array. 

The Server then finds the start and end locations of the maze and then sends the starting location to the Client.

The Server waits for an updated position string from the Client. It takes the string finds the location of the char 'r' and updates the rats current position. Then it creates a string with the surrounding cells of the new position and send it to the Client.


###ENUM
Just the file that contains the enums for the nodes.(not much to explain)


###Rat Client

This the "brains" of the rat.

#####Order of Operations

Rat recieves String,Creates the node and Finds available branches. 

Creates the Node: <br>
After the rat moves, it does not know the next String until the new position comes back from the Server. So it sets the new string to the currentNode.setLocation(). It initializes the node(clean slate) and sets the tempNode.setPrevious() to the currentNode.
```Java
public void createNode(String serverResponse)
{
tempNode = new Node();
tempNode.setPrevious(currentNode);
currentNode.setLocation(serverResponse);
}
```
Finds Branches: <br>
If branch is available[at index(x)] it initializes the Node on the tempNode(.right, .left), sets the enum for that node(RIGHT, LEFT, UP, DOWN), and updates the rats current position.
```Java
if((newMove.charAt(3) == 'p'))
{
if(tempNode.left == null)
tempNode.createNode(3);
tempNode.left.setENUM(ENUM_FROM_DIR.LEFT);
branches++;
}
```

