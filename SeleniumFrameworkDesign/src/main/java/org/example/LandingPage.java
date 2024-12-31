package org.example;

import org.example.RahulShettyAcademy.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    public LandingPage(WebDriver driver) {
       super(driver);
        //initalization
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //WebElement userEmail = driver.findElement(By.id("userEmail"));
    //Pagefactory

        @FindBy(id ="userEmail")
                WebElement userEmail;
    @FindBy(id ="userPassword")
    WebElement passwordEle;

    @FindBy(id ="login")
    WebElement submit;

    public void loginApplication(String email, String password){
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");



    }


}

