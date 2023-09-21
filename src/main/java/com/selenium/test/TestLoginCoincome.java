package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestLoginCoincome {

    String URL_login = "https://pm-dev-jp.makersfarminc.com/sign-in?automationtest=1";
    String URL_dashBoard = "https://pm-dev-jp.makersfarminc.com/";
    String user_login = "account";
    String user_pass = "password";
    String submitBtn = "btn-submit-default";
    WebDriver driver;

    public void login(String account, String password) {
        driver.findElement(By.id(user_login)).sendKeys(account);
        driver.findElement(By.id(user_pass)).sendKeys(password);
        driver.findElement(By.className(submitBtn)).click();
    }

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(URL_login);
    }
    //Check space
    @Test
    public void TC01_LoginFailWithBlankField() {
        login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login);
    }
    //Check validate email
    @Test
    public void TC02_LoginSuccesful() {
        login("tu.nguyen@tomosia.com", "12345678");
        driver.get(URL_dashBoard);
        Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard);
    }



    @AfterClass
    public void afterClass() {

        driver.quit();
    }


}

