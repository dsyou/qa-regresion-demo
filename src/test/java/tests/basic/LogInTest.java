package tests.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import qa.common.User;
import qa.page.LogInPage;
import tests.base.BaseTest;

/**
 * This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 *
 * This Test is checking that user account is Active
 */

@Test(description = "Log In and Log Out")
public class LogInTest extends BaseTest {

    @Autowired
    private User user;

    private LogInPage logInPage;

    @Test(description = "Log In User")
    public void logInUser(){
        logInPage =  userMenu.pressLogIn();
        logInPage.logIn(user);
    }
    @Test(description = "Log Out User", dependsOnMethods = "logInUser")
    public void logOutUSer(){
           userMenu.pressLogOut();
    }


}
