package TestCases;

import Data.Data;
import Pages.LoginPage;
import Utils.Constants;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin extends BaseTest {
    LoginPage loginPage;


    @BeforeClass
    @Parameters ({"browserName"})
    public void SetUp (@Optional("Chrome") String browserName) {
        super.SetUp(browserName);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void TearDown() {
        super.TearDown();
    }



    @Test (groups = { "smoketest", "regressiontest" }, priority = 1,
            description = "This is a login test case 01")
    public void verifyLoginSuccess () {
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
        String getLoginURL = loginPage.getLoginURL();
        Assert.assertTrue(getLoginURL.contains(Constants.LOGIN_URL));
    }

    @Test (groups = { "ui", "smoketest" }, priority = 1,
            description = "This is a login test case 02")
    public void verifyLogin2 () {
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
        String getLoginURL = loginPage.getLoginURL();
        Assert.assertTrue(getLoginURL.contains(Constants.LOGIN_URL));
    }
}
