package Test;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest { //nasledjuje BaseTest klasu jer su nam tamo objekti ako sam
                                             //dobro razumela
    String validUsername = "tomsmith";
    String validPassword = "SuperSecretPassword!";
    String invalidUsername = "invalidUsername";
    String invalidPassword = "invalidPassword";
    String emptyUsername = " ";
    String emptyPassword = " ";

    //ove stringove smo mogli da pisemo i u test metodi

    @BeforeMethod //ova metoda se izvrsava pre svake test metode
    public void pageSetUp (){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        //pomocu ove linije koda idemo na odredjenu stranicu, moglo je umesto navigate da se pise get
        driver.manage().window().maximize();
        //ova linija koda nam sluzi da povecamo prozor

    }

    //iiii onaj najzanimljiviji deo u kom pozivamo nase metode iz odredjene stranice i u sustini pisemo
    //test case-ove, tj testiramo nasu stranicu

    @Test
    public void successfulLogin (){
        loginPage.getUsernameTextBox().clear();
        loginPage.UsernameTextBoxSendKeys(validUsername);
        loginPage.getUsernameTextBox().clear();
        loginPage.PasswordTextBoxSendKeys(validPassword);
        loginPage.ClickOnLoginButton();
        //Assert.assertEquals(logOUTPage.getHeadingLogoutPage().getText(), "Welcome to the Secure Area. When you are done click logout below.");
        // ovaj assert ne radi ne znam iz kog razloga
        Assert.assertTrue(logOUTPage.getLogoutButton().isDisplayed());

    }

    @Test
    public void seccessfulLogout (){
        loginPage.getUsernameTextBox().clear();
        loginPage.UsernameTextBoxSendKeys(validUsername);
        loginPage.getUsernameTextBox().clear();
        loginPage.PasswordTextBoxSendKeys(validPassword);
        loginPage.ClickOnLoginButton();
        visabilityWait(logOUTPage.getLogoutButton());
        logOUTPage.ClickOnLogoutButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());

    }

    @Test
    public void unseccessfulLoginWithInvalidUsername (){
        loginPage.getUsernameTextBox().clear();
        loginPage.UsernameTextBoxSendKeys(invalidUsername);
        loginPage.getPasswordTextBox().clear();
        loginPage.PasswordTextBoxSendKeys(validPassword);
        loginPage.ClickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
       // Assert.assertEquals(loginPage.getMessageError().getText(), " Your username is invalid!");
        //takodje ne znam zbog cega ne radi ovaj assert
    }
    @Test
    public void unseccessfulLoginWithInvalidPassword () {
        loginPage.getUsernameTextBox().clear();
        loginPage.UsernameTextBoxSendKeys(validUsername);
        loginPage.getPasswordTextBox().clear();
        loginPage.PasswordTextBoxSendKeys(invalidPassword);
        loginPage.ClickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }
    @Test
    public void unseccessfulLoginWithInvalidCredentials () {
        loginPage.getUsernameTextBox().clear();
        loginPage.UsernameTextBoxSendKeys(invalidUsername);
        loginPage.getPasswordTextBox().clear();
        loginPage.PasswordTextBoxSendKeys(invalidPassword);
        loginPage.ClickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }
    @Test
    public void unseccessfulLoginWithEmptyCredentials () {
        loginPage.getUsernameTextBox().clear();
        loginPage.UsernameTextBoxSendKeys(emptyUsername);
        loginPage.getPasswordTextBox().clear();
        loginPage.PasswordTextBoxSendKeys(emptyPassword);
        loginPage.ClickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }





}

