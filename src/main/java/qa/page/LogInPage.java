package qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.common.User;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik {@linktourl github.com/dsyou}
 */
public class LogInPage extends BasePage<LogInPage> {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement buttonLog_In;

    public LogInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void logIn(User user) {
        isLoaded();

        System.out.println(user.toString());
        setEmail(user.getEmail());
        setPassword(user.getPassword());

        clickElement(buttonLog_In);
        //check page with assertion

    }

    public void setEmail(String email) {
        sendValue(emailField, email);
    }

    public void setPassword(String password) {
        sendValue(passwordField, password);
    }

    public void pressButtonLog_In() {
        clickElement(buttonLog_In);
    }

    @Override
    public WebElement getPageUniqueElement() {
        return buttonLog_In;
    }

}
