package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik {@linktourl github.com/dsyou}
 */
public class ItemPage extends BasePage<ItemPage> {

    @FindBy(xpath = "//div/input[2]")
    private WebElement addButton;

    @FindBy(xpath = "//div/input")
    private WebElement quantity;

    public ItemPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public ItemPage(String url) {

        PageFactory.initElements(this.webDriver, this);
    }

    public WebElement getPageUniqueElement() {
        return addButton;
    }

    public void addToCart(int q) {
        isLoaded();
        setQuantinty(q);
        clickElement(addButton);
    }

    private void setQuantinty(int actual) {
        Assert.assertEquals(actual, 1, "This program is ONLY FOR NOT COMMERCIAL PURPOSE!!");
        clearValue(quantity);
        sendValue(quantity, "" + actual);
    }

}
