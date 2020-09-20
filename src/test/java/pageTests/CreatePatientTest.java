package pageTests;

import helper.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;


public class CreatePatientTest extends BaseTest{

    @Test
    public void createPatientTest(){
        String name = TestDataGenerator.randomString(8);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn(username,password);
        String patientId = mainPage.createPatient(name);
        Assert.assertTrue(mainPage.isPatientExist(patientId, name));
    }
    @Test
    public void renamePlaylistTest(){
        String name = TestDataGenerator.randomString(8);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn(username,password);
        String patientId = mainPage.createPatient(name);

        String newName = TestDataGenerator.randomString(8);
//        mainPage.renamePlaylist(patientId, newName);

        Assert.assertTrue(mainPage.isPatientExist(patientId, newName));


    }
}
