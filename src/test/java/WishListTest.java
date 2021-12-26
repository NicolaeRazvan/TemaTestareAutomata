
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WishListTest {
    private  WebDriver driver;

    @Before
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

@Test
    //Test 1
    public  void addToCart(){
        WebElement accountLink = driver.findElement(By.cssSelector(".nav-5"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title=\"View Details\"]")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons")).click();
    }
@Test
    //Test2
    public void addToWishlist(){
        WebElement accountLink = driver.findElement(By.cssSelector(".nav-5"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title=\"View Details\"]")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
    }
@Test
    //Test6
    public void addToCompare(){
        WebElement accountLink = driver.findElement(By.cssSelector(".nav-5"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title=\"View Details\"]")).click();
        driver.findElement(By.cssSelector(".link-compare")).click();
        String actualText = driver.findElement(By.cssSelector(".success-msg")).getText();
        String expectedText = "The product Slim fit Dobby Oxford Shirt has been added to comparison list.";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    //Test 7
    public void modifyQuantity(){
        WebElement accountLink = driver.findElement(By.cssSelector(".nav-5"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title=\"View Details\"]")).click();
        driver.findElement(By.id("qty")).sendKeys(Keys.BACK_SPACE.toString());
        driver.findElement(By.id("qty")).sendKeys("4");
        String actual = driver.findElement(By.id("qty")).getAttribute("value");
        String expected = "4";
        Assert.assertEquals(expected,actual);

    }
    @Test
    //Test8
    public void emptyCart(){
        driver.findElement(By.cssSelector("[alt*=\"Knit\"]")).click();
        driver.findElement(By.cssSelector("[alt=\"Red\"]")).click();
        driver.findElement(By.id("swatch79")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons")).click();
        driver.findElement(By.cssSelector(".large")).click();
        driver.findElement(By.cssSelector("[alt*=\"Chelsea\"]")).click();
        driver.findElement(By.cssSelector("[alt=\"Blue\"]")).click();
        driver.findElement(By.cssSelector(".option-m")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons")).click();
        driver.findElement(By.cssSelector("div.header-minicart")).click();
        driver.findElement(By.cssSelector(".btn-empty")).click();
        String actualText = driver.findElement(By.cssSelector(".page-title")).getText();
        String expectedText = "SHOPPING CART IS EMPTY";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    //Test9
    public void fromWishlistToCart(){
        driver.findElement(By.cssSelector("[alt*=\"Knit\"]")).click();
        driver.findElement(By.cssSelector("[alt=\"Red\"]")).click();
        driver.findElement(By.id("swatch79")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        driver.findElement(By.cssSelector(".large")).click();
        driver.findElement(By.cssSelector("[alt*=\"Chelsea\"]")).click();
        driver.findElement(By.cssSelector("[alt=\"Blue\"]")).click();
        driver.findElement(By.cssSelector(".option-m")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        driver.findElement(By.cssSelector("button.btn-add")).click();
        String actualText = driver.findElement(By.cssSelector(".success-msg")).getText();
        String expectedText = "2 product(s) have been added to shopping cart: \"Elizabeth Knit Top\", \"Chelsea Tee\".";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    //Test 10
    public void reviewAnItem(){
        driver.findElement(By.cssSelector("[alt*=\"Travel\"]")).click();
        driver.findElement(By.id("product-collection-image-370")).click();
        driver.findElement(By.cssSelector(".rating-links :last-child")).click();
        driver.findElement(By.id("Value_1")).click();
        driver.findElement(By.id("Quality_4")).click();
        driver.findElement(By.id("Price_2")).click();
        driver.findElement(By.id("review_field")).sendKeys("weweqqw");
        driver.findElement(By.id("summary_field")).sendKeys("wewqeqe");
        driver.findElement(By.id("nickname_field")).sendKeys("nick");
        String actualText = driver.findElement(By.cssSelector(".success-msg")).getText();
        String expectedText = "Your review has been accepted for moderation.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
