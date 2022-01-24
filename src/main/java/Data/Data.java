package Data;

import Objects.Account;
import Utils.Constants;
import Utils.Utility;
import java.util.ArrayList;

public class Data {
    public static Account defaultAccount () {
        return new Account(Constants.USERNAME, Constants.PASSWORD);
    }

    public static ArrayList<Account> getAccountsCSV(String file, String delimiter) {
        ArrayList<String> arrayList = Utility.readCSV(file);
        ArrayList<Account> list_accounts = new ArrayList<>();

        for (Object string : arrayList) {
            String [] array = string.toString().split(delimiter);
            list_accounts.add(new Account(array[0], array[1]));
        }
        return list_accounts;
    }
}
