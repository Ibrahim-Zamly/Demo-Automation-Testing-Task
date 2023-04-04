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

public class HomePage extends TestBase {

    public HomePage() throws IOException {
        super();
    }

    @BeforeMethod
    public void login(Method method) throws ATUTestRecorderException {
        initialization();

        WebElement loginTextBox = driver.findElement(By.name("username"));
        WebElement passwordTextBox = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value= 'Login']"));

        loginTextBox.sendKeys(prop.getProperty("userName"));
        passwordTextBox.sendKeys(prop.getProperty("password"));
        loginButton.click();

        recorder = new ATUTestRecorder("C:\\Users\\user\\IdeaProjects\\FreeCRMApplication\\VideoRecorder",method.getName(),false);
        recorder.start();
    }

    @Test (priority = 5)
    public void clickOnContactsTest(Method method) throws IOException {
        driver.switchTo().frame("mainpanel");
        WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
        contacts.click();
        WebElement statusLable = driver.findElement(By.xpath("//td[text()='Status']"));
        boolean actualResult = statusLable.isDisplayed();
        Assert.assertTrue(actualResult,"the status lable is not displayed");
        TestUtils.takePicture(method.getName());
    }

    @Test (priority = 6)
    public void clickOnDealsTest(Method method) throws IOException {
        driver.switchTo().frame("mainpanel");
        WebElement deals = driver.findElement(By.xpath("//a[text()='Deals']"));
        deals.click();
        WebElement statuslabel = driver.findElement(By.xpath("//td[text()='Keyword']"));
        boolean actualResult = statuslabel.isDisplayed();
        Assert.assertTrue(actualResult,"the keyword lable is not displayed");
        TestUtils.takePicture(method.getName());
    }

    @Test (priority = 7)
    public void clickOnTasksTest(Method method) throws IOException {
        driver.switchTo().frame("mainpanel");
        WebElement tasks = driver.findElement(By.xpath("//a[text()='Tasks']"));
        tasks.click();
        WebElement statuslabel = driver.findElement(By.xpath("//td[text()='Keyword']"));
        boolean actualResult = statuslabel.isDisplayed();
        Assert.assertTrue(actualResult,"the keyword lable is not displayed");
        TestUtils.takePicture(method.getName());
    }
    @AfterMethod
    public void turnDown() throws ATUTestRecorderException {
        recorder.stop();
        driver.quit();
    }
}
