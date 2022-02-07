package Data;

import Objects.Account;
import Objects.CheckoutInfo;
import Objects.CheckoutOverview;
import Objects.Product;
import Utils.Constants;
import Utils.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Data {
    public static Account defaultAccount() {
        return new Account(Constants.USERNAME, Constants.PASSWORD);
    }

    /**
     * Set default information
     *
     * @return
     */
    public static CheckoutInfo defaultInfo() {
        return new CheckoutInfo(Constants.FIRSTNAME, Constants.LASTNAME, Constants.ZIPCODE);
    }

    public static ArrayList<Account> getAccountsCSV(String file, String delimiter) {
        ArrayList<String> arrayList = Utility.readCSV(file);
        ArrayList<Account> list_accounts = new ArrayList<>();

        for (Object string : arrayList) {
            String[] array = string.toString().split(delimiter);
            list_accounts.add(new Account(array[0], array[1]));
        }
        return list_accounts;
    }

    public static ArrayList<Product> productArrayList() {
        JSONObject jsonObject = Utility.readJSON(Constants.DATA_TEST);
        ArrayList<Product> products = new ArrayList<Product>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("product");
        for (Object obj : jsonArray) {
            Product product = new Product();
            products.add(product.jsonFormat((JSONObject) obj));
        }
        return products;
    }

    public static CheckoutInfo checkoutInfo() {
        JSONObject jsonObject = Utility.readJSON(Constants.DATA_TEST);
        JSONObject object = (JSONObject) jsonObject.get("checkout");
        CheckoutInfo checkoutInfo = new CheckoutInfo();
        return checkoutInfo.jsonFormat(object);
    }

    public static CheckoutOverview checkoutOverview() {
        JSONObject jsonObject = Utility.readJSON(Constants.DATA_TEST);
        JSONObject object = (JSONObject) jsonObject.get("checkout_overview");
        CheckoutOverview checkoutOverview = new CheckoutOverview();
        return checkoutOverview.jsonFormat(object);
    }
}
