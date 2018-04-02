package qa.data;

/**
 * This program is not for Commercial purpose.
 * Demo Skills Only
 * DEMO Version ONLY required FIELD are implemented !!!
 *
 * @author Dawid Janik {github.com/dsyou}
 */
public class CheckOutBillingAddressData {

    private boolean shipTheSameAddressCheckBox;

    private String city;
    private String address_1;

    private String countryId;
    private String stateId;

    private String postalCode;
    private String phoneNumber;

    public boolean isShipTheSameAddressCheckBox() {
        return shipTheSameAddressCheckBox;
    }

    public void setShipTheSameAddressCheckBox(boolean shipTheSameAddressCheckBox) {
        this.shipTheSameAddressCheckBox = shipTheSameAddressCheckBox;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
