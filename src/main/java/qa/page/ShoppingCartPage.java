package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik {@linktourl github.com/dsyou}
 */
public class ShoppingCartPage extends BasePage<ShoppingCartPage> {

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    @FindBy(id = "termsofservice")
    private WebElement agreeTermsCheckBox;

    public WebElement getPageUniqueElement() {
        return checkOutButton;
    }

    public ShoppingCartPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public CheckOutBillingAddressPage checkOUT() {
        isLoaded();

        clickElement(agreeTermsCheckBox);
        clickElement(checkOutButton);

        return new CheckOutBillingAddressPage();
    }

}
