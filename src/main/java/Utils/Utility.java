package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utility {
    /**
     * Get CSV data
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
            arrayList.remove(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
