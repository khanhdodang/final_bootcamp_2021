import Data.Data;

import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        String a = "10.40";
        DecimalFormat f = new DecimalFormat("#.00");
        try {
            System.out.println(f.format(Double.parseDouble(a)));
        } catch (Exception ex) {
            System.out.println(0f);
        }

    }
}
