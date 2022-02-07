package Objects;

import org.json.simple.JSONObject;

public class CheckoutInfo {
    String firstname;
    String lastname;
    String zipcode;

    public CheckoutInfo() {

    }

    public CheckoutInfo(String firstname, String lastname, String zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipcode = zipcode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public CheckoutInfo jsonFormat(JSONObject json) {
        CheckoutInfo checkoutInfo = new CheckoutInfo();
        checkoutInfo.setFirstname(String.valueOf(json.get("firstname")));
        checkoutInfo.setLastname(String.valueOf(json.get("lastname")));
        checkoutInfo.setZipcode(String.valueOf(json.get("zipcode")));
        return checkoutInfo;
    }

    public String toString() {
        return firstname + " " + lastname + " " + zipcode;
    }
}
