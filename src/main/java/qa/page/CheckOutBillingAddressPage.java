package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import qa.data.CheckOutBillingAddressData;


/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik github.com/dsyou
 */
public class CheckOutBillingAddressPage extends BasePage<CheckOutBillingAddressPage> {

    @FindBy(id = "ShipToSameAddress")
    private WebElement shipCheckBox;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryId;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityName;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    private WebElement stateId;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address_1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(css = "input.button-1.new-address-next-step-button")
    private WebElement continueButton;

    public WebElement getPageUniqueElement() {
        return continueButton;
    }

    public CheckOutBillingAddressPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public CheckOutShippingAddressPage fillBillingAddress(CheckOutBillingAddressData data) {
        isLoaded();

        Assert.assertTrue(data.isShipTheSameAddressCheckBox(), "This is only Demo Purpose Test");
        setCountry(data.getCountryId());
        setState(data.getStateId());
        setCity(data.getCity());
        setAddress_1(data.getAddress_1());
        setZipCode(data.getPostalCode());
        setPhoneNumber(data.getPhoneNumber());

        clickElement(continueButton);

        return new CheckOutShippingAddressPage();
    }

    private void setCountry(String name) {
        clickElement(countryId);

        selectByVisibleText(countryId, name);
    }

    private void setState(String name) {
        clickElement(stateId);
        selectByVisibleText(stateId, name);
    }

    private void setCity(String city) {
        sendValue(cityName, city);
    }

    private void setAddress_1(String address) {
        sendValue(address_1, address);
    }

    private void setZipCode(String code) {
        sendValue(zipCode, code);
    }

    private void setPhoneNumber(String number) {
        sendValue(phoneNumber, number);
    }


}
