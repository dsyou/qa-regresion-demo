package tests.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import qa.common.User;
import qa.data.CheckOutBillingAddressData;
import qa.data.ItemData;
import qa.data.SearchData;
import qa.page.ItemPage;
import qa.page.LogInPage;
import qa.page.SearchPage;
import tests.base.BaseTest;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 *
 * 1.Log In User
 * 2.Search HTC Blue One
 * 3.Add To Cart
 * 4. End Test
 */
@Test(description = "Add To Cart Preferred Item")
public class ShoppingCartTest extends BaseTest {

    @Autowired
    private User user;

    @Autowired
    private ItemData itemData;

    @Autowired
    private SearchData searchData;



    private  ItemPage itemPage;

    @Test(description = "1.Log In")
    public void logInUser(){
        LogInPage logInPage = userMenu.pressLogIn();
        logInPage.logIn(user);
    }

    @Test(description = "2.Search for Item and Check Result" , dependsOnMethods = "logInUser")
    public void searchItem(){
       SearchPage searchPage = userMenu.searchItem(searchData);
       searchPage.checkResultSearching(searchData);
       itemPage = searchPage.choiceItem();
    }

    @Test(description = "3.Add To Cart" , dependsOnMethods = "searchItem")
    public void addToCartItem(){
        itemPage.addToCart(itemData.getQuantity());
    }



}
