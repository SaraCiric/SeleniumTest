package Base;

import Pages.LogOUTPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public LogOUTPage logOUTPage;

    @BeforeClass //izvrsava se samo jednom na pocetku
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wdwait);
        logOUTPage = new LogOUTPage(driver, wdwait);
        //to u zagradi je prosledjen konstruktor za posledja dva
    }

    public void visabilityWait (WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    } //metoda koja ceka da se pojavi neki element pre nego sto ga klikne

    public void clicabilityWait (WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }//metoda koja ceka dok se sve sa stranice ne ocita da bi mogla da klikne element koji smo joj zadali

   /* @AfterClass
    public void tearDown (){
        driver.close();
        driver.quit();
    }*/

}
