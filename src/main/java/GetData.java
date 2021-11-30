import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetData {
    String objname;

    public GetData(String objname) {
        this.objname = objname;
    }

    public Object[][] getdata() {
        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("src/main/resources/data.json"));
            System.out.println(obj);
            JSONArray dataArray = (JSONArray) obj.get(objname);
            System.out.println(dataArray);
            Object[][] objreturn = new Object[dataArray.size()][1];
            for (int i = 0; i < dataArray.size(); i++) {
                Map<String, String> datamap = new HashMap<String, String>();
                JSONObject objq ;
                objq = (JSONObject) dataArray.get(i);
                for (Object key : objq.keySet()) {
                    //based on you key types
                    String keyStr = (String) key;
                    String keyvalue = objq.get(keyStr).toString();
                    datamap.put(keyStr, keyvalue);
                    //Print key and value
                    System.out.println("key: " + keyStr + " value: " + keyvalue);
                }
                objreturn[i][0] = datamap;

            }
            return objreturn;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}


