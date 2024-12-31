package org.example;

import org.example.RahulShettyAcademy.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalouge extends AbstractComponent {
    WebDriver driver;
    public ProductCatalouge(WebDriver driver) {
      super(driver);
        //initalization
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

//List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css =".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList(){
    waitForElementToAppere(productBy);
    return products;


}
public WebElement  getProductByName(String productName){
    WebElement prod =   getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).
            getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
    return prod;

}
public void addProductToCart(String productName){

    WebElement prod=getProductByName(productName);
prod.findElement(addToCart).click();
waitForElementToAppere(toastMessage);
waitForElementToDisappere(spinner);


    }

}
