package org.example.RahulShettyAcademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;

    }

    public void waitForElementToAppere(By findBy ){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    }

    public void waitForElementToDisappere(WebElement ele){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.invisibilityOf(ele));

    }



}
