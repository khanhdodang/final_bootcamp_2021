package Objects;

import org.json.simple.JSONObject;

public class CheckoutOverview {
    String payment_info;
    String shiping_info;
    String sub_total;
    String tax;
    String total;

    public String getPayment_info() {
        return payment_info;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }

    public String getShiping_info() {
        return shiping_info;
    }

    public void setShiping_info(String shiping_info) {
        this.shiping_info = shiping_info;
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
        checkoutOverview.setShiping_info(String.valueOf(json.get("shiping_info")));
        checkoutOverview.setSub_total(String.valueOf(json.get("sub_total")));
        checkoutOverview.setTax(String.valueOf(json.get("tax")));
        checkoutOverview.setTotal(String.valueOf(json.get("total")));
        return checkoutOverview;
    }

    public String toString() {
        return payment_info + " " + shiping_info + " " + sub_total + " " + tax + " " + total;
    }
}