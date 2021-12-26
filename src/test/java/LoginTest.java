import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest {
    private  WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    //Test 3
    public  void loginTest(){
        driver.findElement(By.cssSelector("a.skip-link.skip-account")).click();
        driver.findElement(By.cssSelector(".links [title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("emaildecontrol@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola2");
        driver.findElement(By.cssSelector(".buttons-set button")).click();
        String actualText = driver.findElement(By.cssSelector(".hello")).getText();
        String expectedText = "Hello, Nicolae C Razvan!";
        Assert.assertEquals(expectedText,actualText);
    }
@Test
    //Test4
    public void changePass(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector(".skip-active .first a")).click();
        driver.findElement(By.id("email")).sendKeys("emaildecontrol@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola2");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".box-content p a")).click();
        driver.findElement(By.id("current_password")).sendKeys("parola2");
        driver.findElement(By.id("password")).sendKeys("parola2");
        driver.findElement(By.id("confirmation")).sendKeys("parola2");
        driver.findElement(By.cssSelector(".buttons-set button")).click();
        String actualText = driver.findElement(By.cssSelector(".success-msg span")).getText();
        String expectedText = "The account information has been saved.";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    //Test 5
    public void modifyAccountInfo(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector(".skip-active .first a")).click();
        driver.findElement(By.id("email")).sendKeys("emaildecontrol@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola2");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".box-title [href*=\"account/edit/\"]")).click();
        driver.findElement(By.id("firstname")).sendKeys("x");
        driver.findElement(By.id("middlename")).sendKeys("y");
        driver.findElement(By.id("lastname")).sendKeys("z");
        driver.findElement(By.id("current_password")).sendKeys("parola2");
        driver.findElement(By.cssSelector(".buttons-set button")).click();
        String actualText = driver.findElement(By.cssSelector(".success-msg span")).getText();
        String expectedText = "The account information has been saved.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
