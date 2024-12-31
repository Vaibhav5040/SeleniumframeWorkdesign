

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;'v'
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


        List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
        WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        WebElement prod =   products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));//wait until the toast message is visible().
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));//wait until the toast message is disappered().
       driver.findElement(By.cssSelector("[routerlink*= 'cart']")).click(); //To validate the product in cart we have to click on cart icon

driver.findElement(By.xpath("//button[text()='Checkout'] ")).click();




    }
}
