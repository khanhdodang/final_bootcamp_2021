package TestCase;

import Data.Data;
import Objects.Account;
import Pages.LoginPage;
import Utils.Constants;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TestLoginLoop extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void SetUp(@Optional("Chrome") String browserName) {
        super.SetUp(browserName);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void TearDown() {
        super.TearDown();
    }


    @Test
    public void verifyLoginSuccess() {
        String delimiter = ";";
        ArrayList<Account> list_accounts = Data.getAccountsCSV(Constants.ACCOUNT_CSV_FILE, delimiter);
        for (Object object : list_accounts) {
            loginPage.get(Constants.URL);
            loginPage.login((Account) object);
        }
    }
}

