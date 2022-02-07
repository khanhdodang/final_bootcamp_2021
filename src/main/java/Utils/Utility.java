package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Utility {
    /**
     * Get CSV data
     *
     * @param filePath
     * @return
     */
    public static ArrayList readCSV(String filePath) {
        String line;
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     * Get JSON data
     *
     * @param filePath
     * @return
     */
    public static JSONObject readJSON(String filePath) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try (InputStream is = Utility.class.getResource(filePath).openStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            try {
                jsonObject = (JSONObject) jsonParser.parse(reader);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static float parseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception ex) {
            return 0f;
        }
    }

    /**
     * Format decimal #.00
     * @param pattern
     * @param number
     * @return
     */
    public static String formatDecimal(String pattern, float number) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }
}
