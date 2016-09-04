package tests.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import qa.data.RegisterData;
import qa.page.RegisterPage;
import tests.base.BaseTest;


/**
 * This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 *
 * 1. go to home
 * 2. go to register
 * 3. fill register
 * 4. end
 */
@Test(description = "Register")
public class RegisterTest extends BaseTest {

    @Autowired
    private RegisterData registerData;

    private RegisterPage registerPage;

    @Test(description = "1. Go to Home Page")
    public void loginUser() {
         registerPage = userMenu.pressRegister();
    }

    @Test(description = "2. Try Register a new User" , dependsOnMethods = {"loginUser"})
    public void registerUser() {
        System.out.println(registerData);
        registerPage.registerUser(registerData);
    }

}
