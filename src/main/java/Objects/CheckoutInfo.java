package Objects;

public class CheckoutInfo {
    String firstname;
    String lastname;
    String code;

    public CheckoutInfo() {
    }

    public CheckoutInfo(String firstname, String lastname, String code) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
