package pageTests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class VirtualConversationsTest extends BaseTest{
    @Test
    public void virtualConvPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn(username,password);



    }
}
