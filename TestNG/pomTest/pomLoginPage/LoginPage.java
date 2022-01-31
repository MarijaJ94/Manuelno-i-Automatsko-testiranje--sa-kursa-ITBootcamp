package DomaciLoginSaucedemo.pomTest.pomLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement username;
    WebElement password;
    WebElement loginButton;
    WebElement errorMessage;
    public Cookie kolacic;


    public LoginPage(WebDriver driver, WebDriverWait wdwait,Cookie kolacic) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.kolacic=new Cookie("session-username","standard_user");
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container.error"));
    }
    //kolacic

    public Cookie getKolacic() {
        return kolacic;
    }
    public void logovanjePrekoKolacica(){

        driver.manage().addCookie(getKolacic());
        driver.navigate().refresh();
    }


    //METODE........................

    public void enterUsername(String username){
        this.getUsername().clear();
        this.getUsername().sendKeys(username);

    }

    public void enterPassword(String password){
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
    }

    public void clickOnLoginButton(){
        this.getLoginButton().click();
    }

    public String getErrorMessageText(){
        return this.getErrorMessage().getText();
    }



}
