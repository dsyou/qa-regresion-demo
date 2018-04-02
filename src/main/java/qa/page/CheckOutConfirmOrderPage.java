package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qa.data.CheckOutConfirmOrderData;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik github.com/dsyou
 */
public class CheckOutConfirmOrderPage extends BasePage<CheckOutConfirmOrderPage> {

    @FindBy(xpath = "//div[@id='confirm-order-buttons-container']/p/a")
    private WebElement backButton;

    @FindBy(css = "input.button-1.confirm-order-next-step-button")
    private WebElement confirmButton;

    public WebElement getPageUniqueElement() {
        return confirmButton;
    }

    public CheckOutConfirmOrderPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public void makeFinalChoice(CheckOutConfirmOrderData data) {
        isLoaded();
        Assert.assertFalse(data.isConfirm(), "This program is not for Commercial purpose, Demo Skills Only");
        // I don't implemented this! why? -> Check Assertion ->Demo Only
    }

}


