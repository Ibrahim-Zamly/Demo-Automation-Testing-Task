package com.freecrm.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginPageTest extends TestBase {


    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp(Method method) throws ATUTestRecorderException {

        initialization();
        recorder = new ATUTestRecorder("C:\\Users\\user\\IdeaProjects\\FreeCRMApplication\\VideoRecorder",method.getName(),false);
        recorder.start();
    }

    @AfterMethod
    public void turnDown() throws ATUTestRecorderException {
        recorder.stop();
        driver.quit();

    }

    @Test(priority = 1)
    public void titleTest(Method method) throws IOException {
        String expextedResult = "Free CRM - CRM software for customer relationship management, sales, and support.";
        String actualResult = driver.getTitle();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expextedResult);
        TestUtils.takePicture(method.getName());
    }
    @Test (priority = 2)
    public void urlCheck(Method method) throws IOException {
        String expextedResult = "https://classic.crmpro.com/index.html";
        String actualResult = driver.getCurrentUrl();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expextedResult);
        TestUtils.takePicture(method.getName());
    }

    @Test (priority = 3)
    public void logoTest(Method method) throws IOException {
        WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
        boolean expextedResult = true;
        boolean actualResult = logo.isDisplayed();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expextedResult);
        TestUtils.takePicture(method.getName());
    }

    @Test (priority = 4)
    public void loginTest(Method method) throws IOException {
        WebElement loginTextBox = driver.findElement(By.name("username"));
        WebElement passwordTextBox = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value= 'Login']"));

        loginTextBox.sendKeys(prop.getProperty("userName"));
        passwordTextBox.sendKeys(prop.getProperty("password"));
        loginButton.click();

        String expextedResult = "CRMPRO";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expextedResult);
        TestUtils.takePicture(method.getName());

    }

}
