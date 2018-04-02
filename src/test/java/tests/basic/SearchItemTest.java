package tests.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import qa.data.SearchData;
import qa.page.SearchPage;
import tests.base.BaseTest;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * <p>
 * This test is uesd to check that search action is working properly
 *
 * @author Dawid Janik github.com/dsyou
 */

@Test(description = "Serach Iteam Test")
public class SearchItemTest extends BaseTest {

    @Autowired
    private SearchData searchData;

    private SearchPage searchPage;

    @Test(description = "Check searching")
    public void searchItemAction() {
        searchPage = userMenu.searchItem(searchData);
    }

    @Test(description = "Check search result", dependsOnMethods = "searchItemAction")
    public void checkSearchResult() {
//            searchPage.useAdvancedSearch();
        searchPage.checkResultSearching(searchData);
    }
}
