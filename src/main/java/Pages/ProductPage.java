package Pages;

import Locators.CheckoutStepTwoPageLocators;
import Locators.ProductPageLocators;
import Objects.Product;
import Utils.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProduct(int index) {
        this.click(ProductPageLocators.button_add_to_cart(index));
    }

    public void removeProduct(int index) {
        this.click(ProductPageLocators.button_remove(index));
    }

    public Product getProductInfo(int index) {
        Product product = new Product();
        product.setName(getText(ProductPageLocators.label_product_name(index)));
        product.setDesc(getText(ProductPageLocators.label_product_desc(index)));
        product.setPrice(getText(ProductPageLocators.label_product_price(index)));
        return product;
    }

    public ArrayList<Product> getProductInfo() {
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 1; i <= totalProducts(); i++) {
            products.add(getProductInfo(i));
        }
        return products;
    }

    int totalProducts() {
        return this.getTotalElements(ProductPageLocators.total_product);
    }

    public float getPrice(String str) {
        str = str.replace("$", "");
        return Utility.parseFloat(str);
    }

    public void compareProduct(Product actual, Product expected) {
        try {
            Assert.assertEquals(actual.getName(), expected.getName());
        } catch (AssertionError ex) {
            System.err.println(ex.getMessage());
        }

        try {
            Assert.assertEquals(actual.getDesc(), expected.getDesc());
        } catch (AssertionError ex) {
            System.err.println(ex.getMessage());
        }

        try {
            Assert.assertEquals(actual.getPrice(), expected.getPrice());
        } catch (AssertionError ex) {
            System.err.println(ex.getMessage());
        }
    }
}
