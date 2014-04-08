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

		Socket connectionSocket = socket.accept();
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		//DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
		System.out.println("Server Connected\n");
		JReader read = new JReader("/Users/stephen/Desktop/MazeTest.txt");
		Maze maze = new Maze(read.getArr());
		//outToClient.writeUTF(maze.getStart());
		outToClient.println(maze.getStart());
		//load maze array path
		// load maz with loading class getArr
		// initialize state 


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


			//byte[] outputBuff = stringToBytesASCII(resultOfMove);
			//outToClient.writeUTF(newMove);
			outToClient.println(newMove);
			outToClient.flush();

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
