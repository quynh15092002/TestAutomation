package com.selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCoincome {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://pm-dev-jp.makersfarminc.com/?login=error&redirect=%2Fmypage%2Fnotificatio");

    }
    @Test
    public void TC_01_ValidateCurrenUrl() {
        String abc = "abc";
        String bcd = "abc";
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://pm-dev-jp.makersfarminc.com/?login=error&redirect=%2Fmypage%2Fnotificatio");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    }

