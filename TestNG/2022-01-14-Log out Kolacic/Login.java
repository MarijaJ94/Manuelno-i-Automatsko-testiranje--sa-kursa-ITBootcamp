import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 3 - Ulogovati se na sajt https://demoqa.com/ preko kolacica,
        // izlogovati se i asertovati da je korisnik izlogovan
        /*Cookie kolacic = new Cookie("naziv kolacica", "vrednost kolacica");
        driver.manage().addCookie(kolacic);*/




        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");

        Thread.sleep(2000);

        Cookie kolacic = new Cookie("userName","Maki");
        driver.manage().addCookie(kolacic);

        /*Cookie kolacic1=new Cookie("userID","a47f6b60-5346-4d94-9c64-95accbcfb147");
        driver.manage().addCookie(kolacic1);*/

       Cookie kolacic2=new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ik1ha2kiLCJwYXNzd29yZCI6IkFuYXZvbGltYWp1MTMxMDE5ODYlIiwiaWF0IjoxNjQyMzM5ODE3fQ.ML7sEmTctahbnNhcnhUksvegRcyV_-L6RahASz3Lrg4");

        driver.manage().addCookie(kolacic2);

        Cookie kolacic3=new Cookie("expires","2022-01-23T13%3A30%3A17.824Z");

        driver.manage().addCookie(kolacic3);

        driver.navigate().refresh();


       WebElement logoutButton= driver.findElement(By.id("submit"));

        logoutButton.click();

        //Provera


        String expectedURL="https://demoqa.com/login";
        String actualURL= driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

        WebElement logingprofilebutton= driver.findElement(By.cssSelector(".btn.btn-primary"));

        Assert.assertTrue(logingprofilebutton.isDisplayed());

        WebElement loginHeader = driver.findElement(By.className("main-header"));

        Assert.assertTrue(loginHeader.isDisplayed());




    }

}
