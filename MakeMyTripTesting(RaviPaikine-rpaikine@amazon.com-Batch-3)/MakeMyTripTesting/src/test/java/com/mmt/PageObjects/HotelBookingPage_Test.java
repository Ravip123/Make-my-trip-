package com.mmt.PageObjects;

import com.mmt.PageObject.HotelBookingPage;
import com.mmt.Setup_BaseClass.Setup_BaseClass;
import com.mmt.Util.ScreenshotHandler;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBookingPage_Test extends Setup_BaseClass {

    private ScreenshotHandler screenshotHandler = new ScreenshotHandler();
    public HotelBookingPage hotelBookingPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        Setup_BaseClass();
        screenshotHandler.setDriver(driver);
        hotelBookingPage = new HotelBookingPage(driver);
    }


    @Test(priority = 1)
    public void searchHotelsTest() throws Exception {
        hotelBookingPage.search_Hotels(driver);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='hotelListingContainer']")).isDisplayed());
        screenshotHandler.captureScreenshot("");

    }


    @Test(priority = 2)
    public void bookHotelTest() throws Exception {
        hotelBookingPage.bookHotel(driver);

        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Payment options']")).isDisplayed());
        screenshotHandler.captureScreenshot("");

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
