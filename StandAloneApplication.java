

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class standAloneTest {
    public static void main(String[] args){
         //   WebDriverManager.chromedriver().setup();
        String productName = "ADIDAS ORIGINAL";
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/");



        driver.findElement(By.id("userEmail")).sendKeys("vaibhavsah20@gmail.com", Keys.ENTER);
        driver.findElement(By.id("userPassword")).sendKeys("Rahul@123", Keys.ENTER);
        driver.findElement(By.id("login")).click();

        WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        wait.until(ExpectedConditions.invisibilityOf((WebElement) By.cssSelector(".ng-animating")));
        List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod =   products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
            prod.click();
            prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       wait.until(ExpectedConditions.invisibilityOf(driver.findElement( By.cssSelector(".ng-animating"))));


         driver.findElement(By.cssSelector("[routerlink*= 'cart']")).click();
         //Tp validate the product in cart

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean matchs =  cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(matchs);

        driver.findElement(By.cssSelector(".totalRow button")).click();

        driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("Ind");
       List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted"));
       WebElement coun = (WebElement) countries.stream().filter(country->country.findElement(By.cssSelector(".ta-results.list-group.ng-star-inserted")).getText().equalsIgnoreCase("India"));
       coun.click();





// Id- for the toste message .ng-animating



    }



}
