package com.mmt.PageObjects;

import com.mmt.PageObject.HomePage;
import com.mmt.Setup_BaseClass.Setup_BaseClass;
import com.mmt.Util.ScreenshotHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends Setup_BaseClass {

    private ScreenshotHandler screenshotHandler = new ScreenshotHandler();
    public HomePage homePage;

    @BeforeClass
    public void setup() throws InterruptedException {
        Setup_BaseClass();
        screenshotHandler.setDriver(driver);
        homePage = new HomePage(driver);
    }


    @Test(priority = 1)
    public void validateWebsiteTitle() throws Exception {
        String actualTitle = driver.getTitle();
        String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";

        Assert.assertEquals(actualTitle, expectedTitle, "Page Title Mismatch");
        screenshotHandler.captureScreenshot("validateWebsiteTitle");

    }


    @Test(priority = 2)
    public void validateHeaderElements() throws Exception {
       boolean homePage_Header_Elements = homePage.headerElements();

        Assert.assertTrue(homePage_Header_Elements, "Header Elements are not matching");
        screenshotHandler.captureScreenshot("validateHeader");
    }

    @Test(priority = 3)
    public void validateMenuElements() throws Exception {
        boolean homePage_Menu_Elements = homePage.menuTags();

        Assert.assertTrue(homePage_Menu_Elements, "Menu Elements are not matching");
        screenshotHandler.captureScreenshot("validateMenu");

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
