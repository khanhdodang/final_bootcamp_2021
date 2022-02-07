package Pages;

import Locators.CheckoutStepTwoPageLocators;
import Objects.CheckoutOverview;
import Objects.Product;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public Product getProductInfo(int index) {
        Product product = new Product();
        product.setName(getText(CheckoutStepTwoPageLocators.label_product_name(index)));
        product.setDesc(getText(CheckoutStepTwoPageLocators.label_product_desc(index)));
        product.setPrice(getText(CheckoutStepTwoPageLocators.label_product_price(index)));
        product.setQuantity(Integer.parseInt(getText(CheckoutStepTwoPageLocators.label_product_quantity(index))));
        return product;
    }

    public ArrayList<Product> getProductInfo() {
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 1; i <= totalProducts(); i++) {
            products.add(getProductInfo(i));
        }
        return products;
    }

    public int totalProducts() {
        return getTotalElements(CheckoutStepTwoPageLocators.total_product);
    }

    public CheckoutOverview get_checkout_overview() {
        CheckoutOverview checkoutOverview = new CheckoutOverview();
        checkoutOverview.setPayment_info(getText(CheckoutStepTwoPageLocators.label_payment_info));
        checkoutOverview.setShiping_info(getText(CheckoutStepTwoPageLocators.label_shipping_info));
        checkoutOverview.setSub_total(getText(CheckoutStepTwoPageLocators.label_sub_total));
        checkoutOverview.setTax(getText(CheckoutStepTwoPageLocators.label_tax));
        checkoutOverview.setTotal(getText(CheckoutStepTwoPageLocators.label_total));
        return checkoutOverview;
    }

    public void clickFinish() {
        this.click(CheckoutStepTwoPageLocators.button_Finish);
    }

    public void clickCancel() {
        this.click(CheckoutStepTwoPageLocators.button_Cancel);
    }

    public void compareCheckoutOverview(CheckoutOverview actual, CheckoutOverview expected) {
        Assert.assertEquals(actual.getPayment_info(), expected.getPayment_info());
        Assert.assertEquals(actual.getShiping_info(), expected.getShiping_info());
        Assert.assertEquals(actual.getSub_total(), expected.getSub_total());
        Assert.assertEquals(actual.getTax(), expected.getTax());
        Assert.assertEquals(actual.getTotal(), expected.getTotal());
    }
}
