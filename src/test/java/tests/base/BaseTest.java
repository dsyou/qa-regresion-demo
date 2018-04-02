package tests.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import qa.componetns.UserMenu;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This program is not for Commercial purpose.
 *
 * @author Dawid Janik {@linktourl github.com/dsyou}
 */
@Listeners(TestListener.class)
@ContextConfiguration(locations = {"classpath:Spring-test-config.xml"})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    protected WebDriver webDriver;

    protected UserMenu userMenu;

    protected static String testName;

    @Autowired
    private BeanFactory beanFactory;

    @Value(value = "${browser.type}")
    protected String browserType;

    @Value("#{new Long('${default.browser.implicitlyWait.secs}')}")
    protected Long implicitlyWaitInSecs; //3s

    @Value(value = "${app.url.start}")
    protected String homeURL;       //= "http://demo.nopcommerce.com";

    @Value(value = "${chrome.browser.driver}")
    private String pathChromeDRIVER;  //= "

    @Value(value = "${default.browser.width}")
    protected int browserWindowHeight;

    @Value(value = "${default.browser.height}")
    protected int browserWindowWidth;

    @Value(value = "${screenshots.path}")
    protected String screenFilePath;

    @BeforeClass(alwaysRun = true)
    public void setUP() {

        switch (browserType) {
            case ("chrome"):
                System.setProperty("webdriver.chrome.driver", pathChromeDRIVER);
                webDriver = new ChromeDriver();
                break;
            case ("firefox"):
                webDriver = new FirefoxDriver();
                break;
            default:
                webDriver = new FirefoxDriver();
                break;
        }
        webDriver.manage().window().setSize(new Dimension(browserWindowWidth, browserWindowHeight));
        webDriver.get(homeURL);

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @BeforeMethod(alwaysRun = true)
    public void iniHomePage() {
        userMenu = new UserMenu(webDriver);
        System.out.println("Before " + beanFactory.getBean("registerData"));
    }
//    @BeforeMethod
//    public void handleTestMethodName(Method method){
//         this.testName = method.getName();
//        System.out.println("TEST NAME" + testName);
//    }

    @AfterMethod(alwaysRun = true)
    public void implicitWait() {
        webDriver.manage().timeouts().implicitlyWait(implicitlyWaitInSecs, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {

        if (iTestResult.getStatus() == ITestResult.FAILURE) { //Make ScreenShot
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            System.out.println("Foto:" + testName);
            //The below method will save the screen shot in drive with test method name
            FileUtils.copyFile(scrFile, new File(screenFilePath + testName + ".png"));
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeWebDriver() throws InterruptedException {
        Thread.sleep(10000); //10s
        webDriver.quit(); //Quits this driver, closing every associated window.
    }

}
