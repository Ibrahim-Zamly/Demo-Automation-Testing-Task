package com.freecrm.util;

import com.freecrm.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtils extends TestBase {
    public TestUtils() throws IOException {
        super();
    }


    public static void takePicture(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("C:\\Users\\user\\IdeaProjects\\FreeCRMApplication\\Snapshots\\"+name+".png"));
    }

}
