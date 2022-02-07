package TestCases;

import Data.Data;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.Constants;
import org.testng.annotations.*;

public class Verify_Product_01 extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void SetUp(@Optional("Chrome") String browserName) {
        super.SetUp(browserName);
        loginPage = new LoginPage(driver);
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
    }

    @Test(priority = 0, description = "Verify products display correctly")
    public void test_products_display_correctly() {
        ProductPage productPage = new ProductPage(driver);
        for (int i = 1; i <= Data.productArrayList().size(); i++) {
            productPage.addProduct(i);
            productPage.removeProduct(i);
            productPage.compareProduct(productPage.getProductInfo(i), Data.productArrayList().get(i - 1));
        }
    }

    @AfterClass
    public void TearDown() {
        super.TearDown();
    }
}