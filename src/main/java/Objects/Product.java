package Objects;

import org.json.simple.JSONObject;

public class Product {
    String name;
    String desc;
    String price;
    int quantity = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return name + " " + desc + " " + price + " " + quantity;
    }

    public Product jsonFormat(JSONObject json) {
        Product product = new Product();
        product.setName(String.valueOf(json.get("name")));
        product.setDesc(String.valueOf(json.get("desc")));
        product.setPrice(String.valueOf(json.get("price")));
        return product;
    }
}