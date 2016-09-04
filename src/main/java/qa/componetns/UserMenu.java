package qa.componetns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.data.SearchData;
import qa.page.*;

/**
 *  This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
public class UserMenu extends BasePage{

    @FindBy(id = "customerCurrency")
    private WebElement currency;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement register;

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    private WebElement logIn;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logOUT;

    @FindBy(xpath = "//a/span")
    private WebElement wishlist;

    @FindBy(xpath = "//li[@id='topcartlink']/a/span")
    private WebElement shoppingCart;

    @FindBy(id = "small-searchterms")
    private WebElement searchField;

    @FindBy (xpath = "//input[@value='Search']")
    private WebElement searchButton;

    //private WebDriver webDriver;

//############################################################################################################
//### METHODS ############################################################################################
//############################################################################################################

    public UserMenu(WebDriver webDriver){
        this.webDriver  = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }
    public WebElement getPageUniqueElement() {
        return shoppingCart;
    }

    public void setCurrency(){
    }


    public LogInPage pressLogIn(){
            clickElement(logIn);
        return new LogInPage(this.webDriver);
    }

    public void pressWishlist(){
        clickElement(wishlist);
    }

    public RegisterPage pressRegister(){
        clickElement(register);
        return new RegisterPage(this.webDriver);
    }

    public ShoppingCartPage pressShoppingCart(){
        clickElement(shoppingCart);
        return  new ShoppingCartPage();
    }

    public void pressLogOut() {
        clickElement(logOUT);
    }

    public SearchPage searchItem(SearchData searchData){
        sendValue(searchField,searchData.getSearchPhrase());
        clickElement(searchButton);

        return  new SearchPage();
    }

}
