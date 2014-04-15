import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.Arrays;

class TCPClient
{
	/*public static void main(String argv[]) throws Exception
	{
		String sentence;
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 13000); 

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter writeToServer = new PrintWriter(clientSocket.getOutputStream(), true);

		String serverResponse;
		
		try
		{

			//DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

			// print starting location
			serverResponse = inFromServer.readLine();
			System.out.println("FROM SERVER: " + serverResponse);

			
			while (true)
			{
				
				

				sentence = inFromUser.readLine().trim();
				//outToServer.writeUTF(sentence);
				//int length = inFromServer.read(serverResponse);
				//serverResponse = dataIn.readUTF();
				writeToServer.println(sentence);
				//inFromServer.ready();
				serverResponse = inFromServer.readLine();


				System.out.println("FROM SERVER: " + serverResponse);
			}
		}
		finally
		{
			clientSocket.close();
		}
	}*/


}