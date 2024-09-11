package com.mmt.PageObjects;

import com.mmt.PageObject.FlightBookingPage;
import com.mmt.Setup_BaseClass.Setup_BaseClass;
import com.mmt.Util.ScreenshotHandler;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlightBookingPage_Test extends Setup_BaseClass {

    private ScreenshotHandler screenshotHandler = new ScreenshotHandler();
    public FlightBookingPage flightBookingPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        Setup_BaseClass();
        screenshotHandler.setDriver(driver);
        flightBookingPage = new FlightBookingPage(driver);
    }


    @Test(priority = 1)
    public void searchFlightsTest() throws Exception {
        flightBookingPage.search_Flights(driver);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='multifareFooter']//button[@id='bookbutton-RKEY:7ec427bc-1b86-4d62-b706-612666d18171:6_0~~~RKEY:7ec427bc-1b86-4d62-b706-612666d18171:139_0']")).isDisplayed());
        screenshotHandler.captureScreenshot("searchFlights");

    }

    @Test(priority = 2)
    public void bookFlightTest() throws Exception {
        flightBookingPage.book_Flight(driver);

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Complete your booking']")).isDisplayed());
        screenshotHandler.captureScreenshot("bookFlight");



    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
