
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class Listener {
	
	
	public Listener(int portNum)
	{
		try {
			Listen(portNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Listen(int port) throws IOException
	{
	ServerSocket listener = new ServerSocket(port);
	
    try {
        while (true) {
            Socket socket = listener.accept();
            InputStreamReader IR =  new InputStreamReader(socket.getInputStream());
            BufferedReader BR =  new BufferedReader(IR);
            
            System.out.println("Client Connected: " + socket.getLocalAddress().getHostName());
            
            Scanner scan = new Scanner(socket.getInputStream());
            
            while(scan.hasNextLine())
            {
            	System.out.println(scan.nextLine());
            }
            
            
//            MazeReturn return = new MazeReturn(socket);
//            
//            Thread thred = new Thread(return);
//            thred.start();
            
            
//            String location = BR.readLine();
//            
//            if ((location != null) && (location.length() == 9))
//            {
//           
//                PrintStream PS = new PrintStream(socket.getOutputStream());
//                PS.println(new Date().toString());
//           
//            }
        }
    }
    catch (Exception e) {
    	e.printStackTrace();
        
    }
	
	}
}
