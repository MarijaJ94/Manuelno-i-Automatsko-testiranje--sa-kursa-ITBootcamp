import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class DomaciYouTube {
    public static void main(String[] args) throws InterruptedException {


        //Vas domaci zadatak je da otvorite pretrazivac, odete na youtube i pustite Rick Astley-a


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));

        wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".gLFyf.gsfi")));

        searchBox.sendKeys("You Tube");

        searchBox.sendKeys(ENTER);

        WebElement youTube = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));


        wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".LC20lb.MBeuO.DKV0Md")));

        youTube.click();



        wdwait.until(ExpectedConditions.urlToBe("https://www.youtube.com/"));

        WebElement youTubeSearchBox = driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));

        wdwait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")));

        // Znam da ne treba da radimo preko xpath ali meni nije radilo preko id ili clase a ni preko xpath. Jedino sa full xpath


        youTubeSearchBox.sendKeys("Rick Astley");

        youTubeSearchBox.sendKeys(ENTER);


        Thread.sleep(5000);


        WebElement title = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div"));
        title.click();

        //  65 linija nekad hoce, a nekad nece da se izvrsi (mozda je do xpath)

        //Provera

        String expectedURL="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        String actualURL=driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

        // htela sam da proverim i naslov pesme ali nisam se snasla










    }
}
