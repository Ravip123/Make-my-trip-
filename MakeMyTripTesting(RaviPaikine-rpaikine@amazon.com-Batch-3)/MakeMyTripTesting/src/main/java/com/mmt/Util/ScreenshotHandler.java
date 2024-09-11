package com.mmt.Util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class ScreenshotHandler {

    private WebDriver driver;

    public ScreenshotHandler() {
    }

    public void captureScreenshot(String fileName) throws Exception {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(System.getProperty("C:\\Users\\rv_itachi\\Desktop\\Youtube Codes\\MakeMyTripTesting\\TestData") + "/screenshots/" + fileName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to capture screenshot");
        }
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver; // Assign the passed WebDriver instance
    }
}

