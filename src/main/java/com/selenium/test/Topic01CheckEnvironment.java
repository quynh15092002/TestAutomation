package com.selenium.test;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic01CheckEnvironment {

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");
    }

    @Test
    public void TC_01_ValidateCurrentUrl() {
        String abc = "abc";
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://demo.guru99.com/v4/");
    }

    @Test
    public void TC_02_ValidatePageTitle() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
    }

    @Test
    public void TC_03_LoginFormDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
