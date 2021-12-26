import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class RegisterTest {
    private  WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
@Test
    //Test 3
    public  void registerAccount(){
        driver.findElement(By.cssSelector("a.skip-link.skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Register\"]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Nicolae");
        driver.findElement(By.id("middlename")).sendKeys("C");
        driver.findElement(By.id("lastname")).sendKeys("Razvan");
        driver.findElement(By.id("email_address")).sendKeys("emaildecontrol@gmail.com");
        driver.findElement(By.id("password")).sendKeys("parola2");
        driver.findElement(By.id("confirmation")).sendKeys("parola2");
        driver.findElement(By.cssSelector(".control label")).click();
        driver.findElement(By.cssSelector(".buttons-set button")).click();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }


}
