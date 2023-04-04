package com.freecrm.base;

import atu.testrecorder.ATUTestRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static ChromeOptions options;
    public static Properties prop;
    public static ATUTestRecorder recorder;
    public TestBase() throws IOException {
         prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\user\\IdeaProjects\\FreeCRMApplication\\src\\test\\java\\com\\freecrm\\config\\config.properties");
        prop.load(fis);
    }
    public void initialization(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("URL"));
    }
}
