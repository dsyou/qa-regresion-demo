package qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.data.RegisterData;

import java.util.Date;

/**
 *  This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
public class RegisterPage extends BasePage<RegisterPage> {

    //Gender Type
    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @FindBy(id = "gender-female")
    private WebElement genderFemale;

    //Personal Details
    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;


    @FindBy(name = "DateOfBirthDay")
    private WebElement birthDay;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement birthMonth;

    @FindBy(name = "DateOfBirthYear")
    private WebElement birthYear;


    @FindBy(id = "Email")
    private WebElement email;

    //Company Details Area
    @FindBy(id = "Company")
    private WebElement nameCompany;

    @FindBy(id = "Newsletter")
    private WebElement newsletter;

    //Your Password Area
    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    //Button Register
    @FindBy(id = "register-button")
    private WebElement buttonRegister;

    //Button Register Continue !!!
    @FindBy(xpath = "//input[@name='register-continue']")
    private WebElement buttonRegisterContinue;


//    private WebDriver webDriver;

//############################################################################################################
//### HEAD METHODS ############################################################################################
//############################################################################################################

    public RegisterPage(WebDriver webDriver) {
//        this.webDriver  = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    @Override
    public WebElement getPageUniqueElement() {
        return buttonRegister;
    }
    public void registerUser(RegisterData data) {
        isLoaded();

        setGender(data.isGender());
        setFirstName(data.getFirstName());
        setLastName(data.getLastName());

        setDateOfBirth(data.getDate());

        setEmail(data.getEmail());
        setCompanyName(data.getCompanyName());
        setNewsletter(data.isNewsletter());

        //Password
        setPassword(data.getPassword());
        setConfirmPassword(data.getConfirmPassword());

        clickElement(buttonRegister);
        clickElement(buttonRegisterContinue);
    }

//############################################################################################################
//### SET METHODS ############################################################################################
//############################################################################################################
    protected void setGender(boolean t) {
        if (t) {
            clickElement(genderMale);
        } else {
            clickElement(genderFemale);
        }
    }

    protected void setFirstName(String text) {
        sendValue(firstName, text);
    }

    protected void setLastName(String text) {
        sendValue(lastName, text);
    }

    protected void setEmail(String text) {
        sendValue(email, text);
    }

    protected void setDateOfBirth(Date date) {
        System.out.println("Data= " + date);

        setBirthDay(date.getDay());
        setBirthMonth(date.getMonth());
        setBirthYear(date.getYear());
    }

    protected void setBirthDay(int day) {

        clickElement(birthDay);
        selectByIndex(birthDay, day);
    }

    protected void setBirthMonth(int month) {

        clickElement(birthMonth);
        selectByIndex(birthMonth, month);

    }

    protected void setBirthYear(Integer year) {
        clickElement(birthYear);
        selectByValue(birthYear,year.toString());
    }

    protected void setCompanyName(String companyName) {
        sendValue(nameCompany, companyName);
    }

    protected void setNewsletter(boolean t) {
        if (t) {
            clickElement(newsletter);
        } else {
            clickElement(newsletter);
        }

    }

    protected void setPassword(String pass) {
        sendValue(password, pass);
    }

    protected void setConfirmPassword(String pass) {
        sendValue(confirmPassword, pass);
    }



}
