package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qa.data.CheckOutPaymentTypeData;

/**
 *  This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
public class CheckOutPaymentTypePage extends BasePage<CheckOutPaymentTypePage> {

    @FindBy(id="paymentmethod_0")
    private WebElement checkOrder_checkBox;

    @FindBy(id="paymentmethod_1")
    private WebElement creditCart_checkBox;

    @FindBy(id="paymentmethod_2")
    private WebElement purchase_checkBox;

    @FindBy(css="input.button-1.payment-method-next-step-button")
    private  WebElement continue_Button;

//############################################################################################################
//### METHODS ################################################################################################
//############################################################################################################
    protected CheckOutPaymentTypePage() {
        PageFactory.initElements(this.webDriver, this);
    }

    public WebElement getPageUniqueElement() {
        return creditCart_checkBox;
    }


    public CheckOutPaymentsInformationPage setPaymentMethod(CheckOutPaymentTypeData data){
        isLoaded();

        Assert.assertFalse(data.isCheck_Order(),"DEMO ONLY");
        Assert.assertFalse(data.isPurchase_Order(),"DEMO ONLY");
        if (data.isCreditCard_Order()){
            setCreditCart_checkBox();
        }

        clickElement(continue_Button);

        return new CheckOutPaymentsInformationPage();
    }

    public void setCreditCart_checkBox(){
        clickElement(creditCart_checkBox);
    }

}
