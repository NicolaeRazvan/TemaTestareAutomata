import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest {
    public static void main(String[] args) {

    }

    //cerinta 11
    public static void cerinta11(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("emaildecontrol@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("parola2");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();


        driver.close();
    }

}
