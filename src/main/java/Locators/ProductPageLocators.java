package Locators;

import objects.Product;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;

public class ProductPageLocators extends BasePage {
    private static String cart_item = "(//div[@class='inventory_item'])";

    public static By label_product_img(int index) {
        String img = "(//div[@class='inventory_item'])[1]//div[@class='inventory_item_img']";
        return By.xpath(cart_item + index + img));
    }

    public static By label_product_name(int index) {
        String name = "(//div[@class='inventory_item'])[1]//div[@class='inventory_item_name']";
        return By.xpath(cart_item + index + name);
    }

    public static By label_product_desc(int index) {
        String desc = "(//div[@class='inventory_item'])[1]//div[@class='inventory_item_desc']";
        return By.xpath(cart_item + index + desc);
    }

    public static By label_product_price(int index) {
        String price = "(//div[@class='inventory_item'])[1]//div[@class='inventory_item_price']";
        return By.xpath(cart_item + index + price);
    }

    public static By button_add_to_cart(int index) {
        String add_to_cart = "(//div[@class='inventory_item'])[1]//button[text()='Add to cart']";
        return By.xpath(cart_item + index + add_to_cart);
    }

    public static By button_remove_from_cart(int index) {
        String remove_from_cart = "(//div[@class='inventory_item'])[1]//button[text()='Remove']";
        return By.xpath(cart_item + index + remove_from_cart);
    }

    public void removeProduct(int index) {
        this.click(button_remove_from_cart(index));
    }

    public Product getProductInfo(int index) {
        Product product = new Product();
        product.setName(this.getTextFromElement(label_product_name(index)));
        product.setDesc(this.getTextFromElement(label_product_desc(index)));
        product.setPrice(this.getTextFromElement(label_product_price(index)));
        return product;

        /*public ArrayList<Product> getProductInfo() {
            ArrayList<Product> products = new ArrayList<Product>();
            for (int i = 1; i <= totalProducts(); i++) {
                products.add(getProductInfo(i));
            }
            return products;
        }*/

        public void compareProducts(Product actual, Product expected) {
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


    /*public static By label_product_name(int index) {
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
    }*/
}
