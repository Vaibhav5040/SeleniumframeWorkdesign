package org.example.RahulShettyAcademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/news/india/");
        driver.findElement(By.id(""));
    }
}
