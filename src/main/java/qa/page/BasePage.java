package qa.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 *  This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
import static org.testng.Assert.assertTrue;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected static WebDriver webDriver;

    private WebDriverWait defaultWait;

    abstract public WebElement getPageUniqueElement();

    protected BasePage() {
        super();
    }

    //    public BasePage(WebDriver webDriver) {
    //        this.webDriver = webDriver;
    //    }


    @Override
    protected void load() {
        this.defaultWait = new WebDriverWait(webDriver, 3);
        defaultWait.until(ExpectedConditions.visibilityOf(getPageUniqueElement()));
    }

    @Override
    protected void isLoaded() throws Error {
        load();
        assertTrue(getPageUniqueElement().isDisplayed(), " URL:" + webDriver.getCurrentUrl());
    }

    protected void clickElement(WebElement webElement) {
        webElement.click();
    }

    protected void sendValue(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    protected void clearValue(WebElement webElement) {
        webElement.clear();
    }

    protected void selectByIndex(WebElement webElement, int index) {
        new Select(webElement).selectByIndex(index);
    }

    protected void selectByVisibleText(WebElement webElement, String text) {
        new Select(webElement).selectByVisibleText(text);
    }

    protected void selectByValue(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

    protected void checkResult(String phrase, String cssSelector) {
        System.out.println("Check" + cssSelector);
        List<WebElement> results = webDriver.findElements(By.cssSelector(cssSelector));
        Assert.assertFalse(results.isEmpty());

        for (int i = 0; i < results.size(); i++) {
            Assert.assertTrue(results.get(i).getText().contains(phrase), "Search result validation failed at instance" + "[" + i + "]");
        }
    }


}
