package Locators;

import org.openqa.selenium.By;

public class CheckoutStepTwoPageLocators {
    public static String cart_item = "//div[@class='cart_list']//div[@class='cart_item'][";
    public static By button_Cancel = By.xpath("//div[@class='cart_footer']/a[text()='CANCEL']");
    public static By button_Finish = By.xpath("//div[@class='cart_footer']/a[text()='FINISH']");
    public static By label_payment_info = By.xpath("//div[@class='summary_value_label'][1]");
    public static By label_shipping_info = By.xpath("//div[@class='summary_value_label'][2]");
    public static By label_sub_total = By.xpath("//div[@class='summary_subtotal_label']");
    public static By label_total = By.xpath("//div[@class='summary_total_label']");
    public static By label_tax = By.xpath("//div[@class='summary_tax_label']");
    public static By total_product = By.xpath("//div[@class='cart_item']");

    public static By label_product_quantity(int index) {
        String p2 = "]//div[@class='cart_quantity']";
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
}
