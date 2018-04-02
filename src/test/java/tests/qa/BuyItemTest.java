package tests.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import qa.common.User;
import qa.data.*;
import qa.page.*;
import tests.base.BaseTest;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 *
 * Go through Credentials Order
 */
@Test(description = "Checkout Order and Buy")
public class BuyItemTest extends BaseTest{

    @Autowired
    private User user;

    @Autowired
    private CheckOutBillingAddressData billingData;

    @Autowired
    private CheckOutShippingAddressData shippingData;

    @Autowired
    private CheckOutPaymentTypeData paymentData;

    @Autowired
    private CheckOutPaymentInformationData paymentInformationData;

    @Autowired
    private CheckOutConfirmOrderData checkOutConfirmData;

    private CheckOutBillingAddressPage checkOutBillingAddressPage;

    @Test(description = "1.Log In")
    public void logInUser(){
        LogInPage logInPage = userMenu.pressLogIn();
        logInPage.logIn(user);
    }

    @Test(description = "2. Checkout Order",dependsOnMethods = "logInUser")
    public void checkOutOrder() {
        ShoppingCartPage shoppingCartPage = userMenu.pressShoppingCart();
        checkOutBillingAddressPage = shoppingCartPage.checkOUT();
    }

    @Test(description = "4.Make CheckOut Process Complete", dependsOnMethods = "checkOutOrder")
    public void makeCheckOutComplete(){
        //Billing address
        CheckOutShippingAddressPage checkOutShippingAddressPage = checkOutBillingAddressPage.fillBillingAddress(billingData);
        //Shipping
        CheckOutPaymentTypePage checkOutPaymentTypePage = checkOutShippingAddressPage.setShippingMethod(shippingData);
        //Payment
        CheckOutPaymentsInformationPage checkOutPaymentsInformationPage = checkOutPaymentTypePage.setPaymentMethod(paymentData);
        //Payment information
        CheckOutConfirmOrderPage checkOutConfirmOrderPage = checkOutPaymentsInformationPage.setCardCredentials(paymentInformationData);
        //Confirm Order
        checkOutConfirmOrderPage.makeFinalChoice(checkOutConfirmData);
    }

}

