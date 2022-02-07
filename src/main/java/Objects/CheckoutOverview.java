package Objects;

import org.json.simple.JSONObject;

public class CheckoutOverview {
    String payment_info;
    String shipping_info;
    String sub_total;
    String tax;
    String total;

    public String getPayment_info() {
        return payment_info;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }

    public String getShipping_info() {
        return shipping_info;
    }

    public void setShipping_info(String shipping_info) {
        this.shipping_info = shipping_info;
    }

    public String getSub_total() {
        return sub_total;
    }

    public void setSub_total(String sub_total) {
        this.sub_total = sub_total;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public CheckoutOverview jsonFormat(JSONObject json) {
        CheckoutOverview checkoutOverview = new CheckoutOverview();
        checkoutOverview.setPayment_info(String.valueOf(json.get("payment_info")));
        checkoutOverview.setShipping_info(String.valueOf(json.get("shipping_info")));
        checkoutOverview.setSub_total(String.valueOf(json.get("sub_total")));
        checkoutOverview.setTax(String.valueOf(json.get("tax")));
        checkoutOverview.setTotal(String.valueOf(json.get("total")));
        return checkoutOverview;
    }

    public String toString() {
        return payment_info + " " + shipping_info + " " + sub_total + " " + tax + " " + total;
    }
}