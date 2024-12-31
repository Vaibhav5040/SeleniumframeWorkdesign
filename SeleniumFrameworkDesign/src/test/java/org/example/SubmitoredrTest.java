package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubmitoredrTest {
    public static void main(String[] args){
        String productName = "ADIDAS ORIGINAL";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginApplication("vaibhavsah20@gmail.com", "Rahul@123");
        ProductCatalouge productCatalouge = new ProductCatalouge(driver);
        List<WebElement>   products =  productCatalouge.getProductList();
        productCatalouge.addProductToCart(productName);






//        WebElement prod =   products.stream().filter(product->product.findElement(By.cssSelector("b")).
//                getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//        prod.click();

//        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement( By.cssSelector(".ng-animating"))));

//         driver.findElement(By.xpath("(//button[@style ='margin-top: -10px;'])[2]")).click();
////       Thread.sleep(2000);
//         driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
////
//
////        Id- for the toste message .ng-animating
//
////
//             driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input[1]")).sendKeys("234", Keys.ENTER);

    }


}
