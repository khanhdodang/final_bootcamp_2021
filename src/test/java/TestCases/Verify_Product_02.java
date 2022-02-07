package TestCases;

import Data.Data;
import Objects.Product;
import Pages.*;
import Utils.Constants;
import Utils.Utility;
import org.testng.annotations.*;

import java.util.ArrayList;

public class Verify_Product_02 extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void SetUp(@Optional("Chrome") String browserName) {
        super.SetUp(browserName);
        loginPage = new LoginPage(driver);
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
    }

    @Test(priority = 0, description = "Test E2E")
    public void test_e2e() {
        float total_price = 0;

        ProductPage productPage = new ProductPage(driver);

        ArrayList<Product> productsDB = Data.productArrayList();
        ArrayList<Product> productsUI = productPage.getProductInfo();
        int productsUISize = productsUI.size();

        for (int i = 0; i < productsUISize; i++) {
            productPage.addProduct(i + 1);
            String price = productsUI.get(i).getPrice().replace("$", "");
            float _price = Utility.parseFloat(price);
            total_price += _price;
        }

        CartPage cartPage = new CartPage(driver);
        cartPage.go_to_cart_page();

        for (int i = 1; i <= productsUISize; i++) {
            productPage.compareProduct(cartPage.getProductInfo(i), productsDB.get(i - 1));
        }
        cartPage.click_checkout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.addUserInfo(Data.checkoutInfo());

        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        for (int i = 1; i <= productsUISize; i++) {
            productPage.compareProduct(checkoutStepTwoPage.getProductInfo(i), productsUI.get(i - 1));
        }

        checkoutStepTwoPage.verify_summary(total_price);
        checkoutStepTwoPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.verify_results();
    }

    @AfterClass
    public void TearDown() {
        super.TearDown();
    }
}