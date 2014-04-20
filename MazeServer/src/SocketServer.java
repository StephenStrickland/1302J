import java.io.*;
import java.net.*;
import java.util.Arrays;

import org.omg.PortableInterceptor.INACTIVE;
import org.apache.commons.lang.ArrayUtils;;

public class SocketServer {

	public static void main(String[] args) throws Exception
	{
		String clientSentence;
		String capitalizedSentence;
		ServerSocket socket = null;
		try
		{
			socket = new ServerSocket(13000);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}

		char[] currentCmd = new char[9];
		
		ServerFrame gui = new ServerFrame();
		JReader read = new JReader("/Users/stephen/GitProjects/1302J/JARS/Maze.txt");
		Maze maze = new Maze(read.getArr());
		gui.b.updateLocation(maze.getCurrentLocation());
		Socket connectionSocket = socket.accept();
		
		
		
		gui.lblClientsConnected.setText("Clients Connected");
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		//DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
		System.out.println("Server Connected\n");

		
		System.out.println("This maze is: " + maze.mazeArr[1].length() +'x' + maze.mazeArr.length);
		
		System.out.println("Starting Maze Spot: "+ maze.getStart());
		
		outToClient.println(maze.getStart());

		String currentState = "";
		int request = 0;
		String incomingCmd;

		while(true)
		{
			request++;

			if(request > 50000)
			{
				System.out.println("50,000 request made, closing socket.");
				String last = "wwwwwwwww";
				//outToClient.writeUTF(last);
				outToClient.println(last);
				connectionSocket.close();
				break;

			}

			//incomingCmd = inFromClient.readLine();
			//int numRead = inFromClient.readUTF(currentCmd);
			currentCmd = inFromClient.readLine().toCharArray();
			int numRead = currentCmd.length;
			System.out.println("\nLength Read: " + numRead);	

			System.out.println("Command []: " + Arrays.toString(currentCmd)+"\n");


			char [] resultOfMove = maze.move(currentCmd);
			
			String newMove = new String(resultOfMove);
		
			
			
			
			//ArrayUtils.t
			System.out.println("New Location: " + newMove);
			
			//~~~~~+++++++++===========
			gui.b.updateLocation(maze.getCurrentLocation());


			//byte[] outputBuff = stringToBytesASCII(resultOfMove);
			//outToClient.writeUTF(newMove);
			if(newMove != "ooooooooo")
			{
			outToClient.println(newMove);
			outToClient.flush();
			}
			else
				System.exit(0);
			
			
			

		}


	}
	public static byte[] stringToBytesASCII(char[] buffer) {


		byte[] b = new byte[buffer.length];

		for (int i = 0; i < b.length; i++) {

			b[i] = (byte) buffer[i];

		}

		return b;

	}


}
