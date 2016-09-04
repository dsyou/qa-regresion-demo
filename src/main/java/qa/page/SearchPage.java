package qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.data.SearchData;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
public class SearchPage extends BasePage<SearchPage>{


    @FindBy (id = "adv")
    private WebElement searchAdvancedButton;

    @FindBy(css = "h2.product-title > a")
    private WebElement linkToTheItem;

    private final static String cssSelector = ".product-title";


//############################################################################################################
//### METHODS ############################################################################################
//############################################################################################################


    public  SearchPage() {
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public WebElement getPageUniqueElement() {
        return searchAdvancedButton;
    }


    public void checkResultSearching(SearchData searchDate){
        isLoaded();
        checkResult(searchDate.getSearchPhrase(),cssSelector);
    }
    public ItemPage choiceItem(){
        clickElement(linkToTheItem);
        return new ItemPage();
    }



    public void useAdvancedSearch(){
     clickElement(searchAdvancedButton);
    }


}
