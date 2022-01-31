package DomaciLoginSaucedemo.pomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import DomaciLoginSaucedemo.pomTest.pomBasePage.BasePage;

public class TestLogin extends BasePage {


    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void successfulLogIn(){

        String validUsername = "standard_user";
        String validPasswor = "secret_sauce";

        loginpage.enterUsername(validUsername);
        loginpage.enterPassword(validPasswor);
        loginpage.clickOnLoginButton();

        WebElement logo = driver.findElement(By.className("app_logo"));
        Assert.assertTrue(logo.isDisplayed());

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);

        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));

        Assert.assertTrue(logoutButton.isDisplayed()); // ovde se desi da nekad padne test (ocekivao je true a nasao false)

    }
   /* @Test
    public void loginPrekoKolacica() throws InterruptedException {
        Thread.sleep(2000);
        loginpage.logovanjePrekoKolacica();
        loginpage.clickOnLoginButton();

    }*/

}
