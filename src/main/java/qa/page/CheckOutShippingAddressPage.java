package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.data.CheckOutShippingAddressData;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik {@linktourl github.com/dsyou}
 */
public class CheckOutShippingAddressPage extends BasePage<CheckOutShippingAddressPage> {

    @FindBy(id = "shippingoption_0")
    private WebElement groundShipping;

    @FindBy(id = "shippingoption_1")
    private WebElement nextDayAirShipping;

    @FindBy(id = "shippingoption_2")
    private WebElement secondDayAirShipping;

    @FindBy(css = "input.button-1.shipping-method-next-step-button") //
    private WebElement continueButton;

    public CheckOutShippingAddressPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public WebElement getPageUniqueElement() {
        return groundShipping;
    }

    public CheckOutPaymentTypePage setShippingMethod(CheckOutShippingAddressData data) {
        isLoaded();

        if (data.isGround_shipping_checkBox())
            setShippingMethod_Ground();
        if (data.isNextDay_shipping_checkBox())
            setShippingMethod_nextDayAir();
        if (data.isSecondDay_shipping_checkBox())
            setShippingMethod_secondDayAir();

        clickElement(continueButton);

        return new CheckOutPaymentTypePage();
    }

    private void setShippingMethod_Ground() {
        clickElement(groundShipping);
    }

    private void setShippingMethod_nextDayAir() {
        clickElement(nextDayAirShipping);
    }

    private void setShippingMethod_secondDayAir() {
        clickElement(secondDayAirShipping);
    }

}
