package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.data.CheckOutPaymentInformationData;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik {@linktourl github.com/dsyou}
 */
public class CheckOutPaymentsInformationPage extends BasePage<CheckOutPaymentsInformationPage> {

    @FindBy(id = "CreditCardType")
    private WebElement crediCardType_SelectBox;

    @FindBy(id = "CardholderName")
    private WebElement cardHolderName;

    @FindBy(id = "CardNumber")
    private WebElement cardNumber;

    @FindBy(id = "ExpireMonth")
    private WebElement cardExpireMonth_SelectBox;

    @FindBy(id = "ExpireYear")
    private WebElement cardExpireYear_SelectBox;

    @FindBy(id = "CardCode")
    private WebElement cardCode;

    @FindBy(css = "input.button-1.payment-info-next-step-button")
    private WebElement continueButton;

    public WebElement getPageUniqueElement() {
        return cardHolderName;
    }

    public CheckOutPaymentsInformationPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public CheckOutConfirmOrderPage setCardCredentials(CheckOutPaymentInformationData data) {
        isLoaded();

        setCardType(data.getCreditCardType());
        setCardholderName(data.getCardholderName());
        setCardNumber(data.getCardNumber());
        setExpirationDate(data.getExpirationMonth(), data.getExpirationYear());
        setCardCode(data.getCardCode());

        clickElement(continueButton);

        return new CheckOutConfirmOrderPage();
    }

    private void setCardCode(String code) {
        sendValue(cardCode, code);
    }

    private void setExpirationDate(String month, String year) {
        selectByVisibleText(cardExpireMonth_SelectBox, month);
        selectByVisibleText(cardExpireYear_SelectBox, year);
    }

    private void setCardNumber(String number) {
        sendValue(cardNumber, number);
    }

    private void setCardType(String type) {

    }

    private void setCardholderName(String name) {
        sendValue(cardHolderName, name);
    }


}
