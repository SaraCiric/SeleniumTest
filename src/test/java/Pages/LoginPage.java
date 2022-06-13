package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement usernameTextBox;
    WebElement passwordTextBox;
    WebElement loginButton;
    WebElement headingLoginPage;
    WebElement messageError;

    //=============================================
    //KONSTRUKTOR (samo za driver i wdwait jer nam za web elemente ne treba jer i ne prosledjujemo)

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    //===========================================
    //GETERI (za veb elemente da bi mogli da ih pozivamo u metodama)

    public WebElement getUsernameTextBox() {
        return driver.findElement(By.id("username"));
        //ubacili smo lokator u geter da skratimo kod,
        //ovde sam imala srece i nasla lokator po ID-u koji je prvi po prioritetu
    }

    public WebElement getPasswordTextBox() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        //Kad imamo lokator koji je class i ima razmake, onda se pise da se trazi po css selektoru i
        //umesto razmaka se stavljaju tacke i jedna tacka pre celog teksta
    }

    public WebElement getDescriptionLoginPage() {
        return driver.findElement(By.className("subheader"));
    }//ovo sam ubacila zbog asserta

    public WebElement getMessageError (){
        return driver.findElement(By.cssSelector(".flash.error"));
    }//i ovo sam ubacila zbog asserta da nadje ovaj element kod neuspesog logina


    //===========================================
    //METODE

    public void UsernameTextBoxSendKeys (String username) {
        getUsernameTextBox().sendKeys(username);
    }

    public void PasswordTextBoxSendKeys (String password) {
        getPasswordTextBox().sendKeys(password);
    }

    public void ClickOnLoginButton (){
        getLoginButton().click();
    }


}
