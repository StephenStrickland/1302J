
import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JReader {
	String[] MazeArr;

	public JReader(String path)
	{
		readFile(path);
	}
	
		private void readFile(String path) {
			
			Gson gson = new Gson();
			
			try {
				System.out.println("Reading file");
				System.out.println("..........");
				
				
				JsonReader reader  = new JsonReader(new FileReader(path));
				Type listType = new TypeToken<List<String>>() {}.getType();
				Collection<String> MazeCol = gson.fromJson(reader, listType);
				
				System.out.println(MazeCol.isEmpty());
				System.out.println(MazeCol.toString());
				MazeArr = MazeCol.toArray(new String[MazeCol.size()]);
				
				System.out.println(Arrays.toString(MazeArr));
				
				

		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
		
	public String[] getArr()
	{
		return MazeArr;
	}


	}


