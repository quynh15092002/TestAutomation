package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Check1 {
    public static void main(String[] arStrings) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Hello Selenium Webdriver");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
