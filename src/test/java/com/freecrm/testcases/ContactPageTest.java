package com.freecrm.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class ContactPageTest extends TestBase {

    public ContactPageTest() throws IOException {
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

    @Test (priority = 8)
    public void addContact(Method method) throws IOException {
    driver.switchTo().frame("mainpanel");
    WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
    Actions action = new Actions(driver);
    action.moveToElement(contacts).build().perform();
    WebElement newContacts = driver.findElement(By.xpath("//a[text()='New Contact']"));
    newContacts.click();

    WebElement firstName = driver.findElement(By.id("first_name"));
    WebElement lastName = driver.findElement(By.id("surname"));
    WebElement company = driver.findElement(By.name("client_lookup"));
    WebElement department = driver.findElement(By.id("department"));
    WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit']"));

    firstName.sendKeys("Ibrahim");
    lastName.sendKeys("Elzamly");
    company.sendKeys("ABCD CORP");
    department.sendKeys("Software Department");
    saveButton.click();

        TestUtils.takePicture(method.getName());
    }
    @AfterMethod
    public void turnDown() throws ATUTestRecorderException {
        recorder.stop();
        driver.quit();
    }

}
