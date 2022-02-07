package Pages;

import Locators.CartPageLocators;
import Objects.Product;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void go_to_cart_page() {
        click(CartPageLocators.icon_cart_badge);
    }

    public void click_checkout() {
        click(CartPageLocators.btn_checkout);
    }

    public void remove_product(int index) {
        click(CartPageLocators.button_remove(index));
    }

    public Product getProductInfo(int index) {
        Product product = new Product();
        product.setName(getText(CartPageLocators.label_product_name(index)));
        product.setDesc(getText(CartPageLocators.label_product_desc(index)));
        product.setPrice(getText(CartPageLocators.label_product_price(index)));
        product.setQuantity(Integer.parseInt(getText(CartPageLocators.label_product_quantity(index))));
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
        return getTotalElements(CartPageLocators.total_product);
    }
}
