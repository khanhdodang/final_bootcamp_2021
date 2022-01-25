package Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPageLocators {
    public static By label_product_name(int index) {
    	return By.xpath("(//div[@class='inventory_item'])[" + index + "]//div[@class='inventory_item_name']");
    }

    public static By label_product_desc(int index) {
    	return By.xpath("(//div[@class='inventory_item'])[" + index + "]//div[@class='inventory_item_desc']");
    }

    public static By label_product_price(int index) {
    	return By.xpath("(//div[@class='inventory_item'])[" + index + "]//div[@class='inventory_item_price']");
    }

     public static By button_add_to_cart(int index) {
    	return By.xpath("(//div[@class='inventory_item'])[" + index + "]//button[text()='Add to cart']");
    }

    public static By button_remove(int index) {
    	return By.xpath("(//div[@class='inventory_item'])[" + index + "]//button[text()='Remove']");
    }
    public String quantity = driver.findElement(By.xpath("//*[@id='shopping_cart_container']//span")).getText();
    System.out.println(quantity);
}
