//Stephen Strickland
//The mains for the Server

//I based the sockets off of a tutorial online: http://systembash.com/content/a-simple-java-tcp-server-and-tcp-client/
//it was easy to read and it just works, I did modify a few of the name variables and I am using a PrinterWriter instead of a BufferedWriter
import java.io.*;
import java.net.*;
import java.util.Arrays;;

public class SocketServer {

	public static void main(String[] args) throws Exception
	{
		//create our socket
		ServerSocket socket = null;
		try
		{
			//try to open out socket
			socket = new ServerSocket(13000);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		//this holds our command
		char[] currentCmd = new char[9];
		//this is the main GUI
		ServerFrame gui = new ServerFrame();
		//Reads in the specified maze text file
		JReader read = new JReader("./Maze.txt");
		//create maze and load in the JReader Array
		Maze maze = new Maze(read.getArr());
		gui.b.updateLocation(maze.getCurrentLocation());
		//waits till socket connected
		Socket connectionSocket = socket.accept();
		//once connected it updates the rats position and open up the reader and writer
		gui.lblClientsConnected.setText("Client Connected");
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
		System.out.println("Server Connected\n");

		System.out.println("This maze is: " + maze.mazeArr[1].length() +'x' + maze.mazeArr.length);

		System.out.println("Starting Maze Spot: "+ maze.getStart());

		outToClient.println(maze.getStart());

		int request = 0;
		while(true)
		{
			request++;
			//counter for request made, of 50,000 made it closes the socket
			if(request > 50000)
			{
				System.out.println("50,000 request made, closing socket.");
				gui.lblClientsConnected.setText("50,000 request made, closing socket.");
				String last = "wwwwwwwww";
				//outToClient.writeUTF(last);
				outToClient.println(last);
				connectionSocket.close();
				break;
			}

			currentCmd = inFromClient.readLine().toCharArray();
			int numRead = currentCmd.length;
			System.out.println("\nLength Read: " + numRead);	
			System.out.println("Command []: " + Arrays.toString(currentCmd)+"\n");
			char [] resultOfMove = maze.move(currentCmd);

			String newMove = new String(resultOfMove);
			System.out.println("New Location: " + newMove);

			//update the rats current position
			gui.b.updateLocation(maze.getCurrentLocation());
			outToClient.println(newMove);
			outToClient.flush();

		
			//System.exit(0);

		}
		gui.lblClientsConnected.setText("Client Disconnected");
		inFromClient.close();
		outToClient.close();
		connectionSocket.close();
	}
}
