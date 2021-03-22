import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Utils {

    public static JSONObject getOneJSONObject(URL url) throws IOException {
        return new JSONObject(JSONReader(url));
    }

    public static JSONArray getJSONArray(URL url) throws IOException {
        return new JSONArray(JSONReader(url));
    }

    private static String JSONReader(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = in.read()) != -1){
            stringBuilder.append((char)cp);
        }
        return stringBuilder.toString();
    }
}
