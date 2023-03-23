import java.io.File;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class manage {
    public static String readFile(String fileName){
        String data = new String();
        try{
            File f = new File(fileName);
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                data += reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Starts not aligned");
            e.printStackTrace();
        }
        return data;
    }

    public static JSONObject jsonFileConvert(String fileName){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject(); 
        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader(fileName));
        } catch (Exception e) {
            System.out.println("Error: Starts not aligned");
            e.printStackTrace();
            assert false;
        }
        return jsonObject;
    }
    /*
    public static JSONObject parse(String jsonData){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = (JSONObject) jsonParser.parse(jsonData)
        } catch (Exception e) {
            // TODO: handle exception
        }
    }*/
}
