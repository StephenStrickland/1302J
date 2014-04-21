/*//Stephen Strickland
//1302J
// Used googles GSON library for this, and it worked out great.
//I can set up an array like so: [ data, data] and the library will read it straight in as an array. 
//its fast, efficient, and I'm not trying to rewrite the wheel.
//this library can be found at: https://code.google.com/p/google-gson/
*/
import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JReader {
	String[] MazeArr;

	public JReader(String path)
	{
		readFile(path);
	}

	private void readFile(String path) {
		//creates a new gson
		Gson gson = new Gson();

		try {
			System.out.println("Reading file");
			System.out.println("..........");
			//I looked at google's documentation to figure out how to properly set up my "reader"
			JsonReader reader  = new JsonReader(new FileReader(path));
			Type listType = new TypeToken<List<String>>() {}.getType();
			Collection<String> MazeCol = gson.fromJson(reader, listType);
			System.out.println(MazeCol.isEmpty());
			MazeArr = MazeCol.toArray(new String[MazeCol.size()]);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error Reading File");

		}
	}

	public String[] getArr()
	{
		return MazeArr;
	}
}