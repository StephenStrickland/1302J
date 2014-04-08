import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.Arrays;

class TCPClient
{
 public static void main(String argv[]) throws Exception
 {
	 
	  String sentence;
	  String modifiedSentence;
	  BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
	  Socket clientSocket = new Socket("localhost", 13000);
	  //DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  //DataInputStream dataIn  = new DataInputStream(clientSocket.getInputStream());
	  PrintWriter writeToServer = new PrintWriter(clientSocket.getOutputStream(), true);
	  boolean done = false;
	 while (!done)
	 {
		 String serverResponse;
		 
		  sentence = inFromUser.readLine().trim();
		  //outToServer.writeUTF(sentence);
		  //int length = inFromServer.read(serverResponse);
		  //serverResponse = dataIn.readUTF();
		  writeToServer.println(sentence);
		  inFromServer.ready();
		  serverResponse = inFromServer.readLine().toString();
		  
		  
		  System.out.println("FROM SERVER: " + serverResponse);
	 }
  clientSocket.close();
 }
 

}