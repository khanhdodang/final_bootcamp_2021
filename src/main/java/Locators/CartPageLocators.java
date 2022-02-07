package Locators;

import org.openqa.selenium.By;

public class CartPageLocators {
    public static By total_product = By.xpath("//div[@class='cart_item']");
    public static By icon_cart_badge = By.id("shopping_cart_container");
    public static By btn_checkout = By.id("checkout");
    static String cart_item = "//div[@class='cart_list']//div[@class='cart_item'][";

    public static By button_remove(int index) {
        String p2 = "]//button[text()='REMOVE']";
        return By.xpath(cart_item + index + p2);
    }

    public static By label_product_name(int index) {
        String p2 = "]//div[@class='inventory_item_name']";
        return By.xpath(cart_item + index + p2);
    }

    public static By label_product_desc(int index) {
        String p2 = "]//div[@class='inventory_item_desc']";
        return By.xpath(cart_item + index + p2);
    }

    public static By label_product_price(int index) {
        String p2 = "]//div[@class='inventory_item_price']";
        return By.xpath(cart_item + index + p2);
    }

    public static By label_product_quantity(int index) {
        String p2 = "]//div[@class='cart_quantity']";
        return By.xpath(cart_item + index + p2);
    }
}
