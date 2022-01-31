package DomaciLoginSaucedemo.pomTest.pomBasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import DomaciLoginSaucedemo.pomTest.pomLoginPage.LoginPage;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginpage;
    public Cookie kolacic;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginpage = new LoginPage(driver,wdwait,kolacic);


    }
    @AfterClass
    public void tearDown(){
       /* driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();*/
    }


}
