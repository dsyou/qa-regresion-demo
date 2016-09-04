package tests.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import qa.data.ItemData;
import qa.page.ItemPage;
import tests.base.BaseTest;

/**
 *  This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
@Test(description = "Check Item View and adding to Cart with Quantity")
public class ItemViewTest extends BaseTest {

    @Autowired
    private ItemData itemData;

    @Test(description = "1.Add To Cart Item" )
    public void addToCartItem(){
        ItemPage itemPage = new ItemPage(); // Need specify URL to item !!!
        itemPage.addToCart(itemData.getQuantity());
    }
}
