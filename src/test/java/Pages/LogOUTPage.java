package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOUTPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement logoutButton;
    WebElement headingLogoutPage;

    //===============================
    //KONSTRUKTOR

    public LogOUTPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    //================================
    //GETER

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    public WebElement getHeadingLogoutPage() {
        return driver.findElement(By.id("subheader"));
    }
    //=================================
    //METODA

    public void ClickOnLogoutButton (){
        getLogoutButton().click();
    }
}
