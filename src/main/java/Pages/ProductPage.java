package pages;

import locators.ProductPageLocators;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Basepage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getQuantity() {
        return getText(ProductPageLocators.quantity);
    }
    public void AddToCart() {
        click(ProductPageLocators.button_add_to_cart(2));
    }
    public void Remove() {
        click(ProductPageLocators.button_remove(2));
    }
    public void LabelProductName() {
        click(ProductPageLocators.label_product_name(2));
    }
    public void LabelProductDecs() {
        click(ProductPageLocators.label_product_desc(2));
    }
    public void LabelProductPrice() {
        click(ProductPageLocators.label_product_price(2));
    }
}
