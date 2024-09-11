package com.mmt.PageObjects;

import com.mmt.PageObject.TrainBookingPage;
import com.mmt.Setup_BaseClass.Setup_BaseClass;
import com.mmt.Util.ScreenshotHandler;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrainBookingPage_Test extends Setup_BaseClass {

    private ScreenshotHandler screenshotHandler = new ScreenshotHandler();
   public TrainBookingPage trainBookingPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        Setup_BaseClass();
        screenshotHandler.setDriver(driver);
        trainBookingPage = new TrainBookingPage(driver);
    }

    @Test(priority = 1)
    public void searchTrainsTest() throws Exception {
        TrainBookingPage location = new TrainBookingPage(driver);
        trainBookingPage.search_Trains();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Select Travellers']")).isDisplayed());
        screenshotHandler.captureScreenshot("searchTrain");

    }

    @Test(priority = 2)
    public void selectTrainAndConfirmRouteTest() throws Exception {
        trainBookingPage.search_Trains();
        trainBookingPage.select_Train.click();
        Thread.sleep(2000);
        trainBookingPage.confirm_Route.click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Passenger Details']")).isDisplayed());
        screenshotHandler.captureScreenshot("selectTrainAndConfirmRoute");

    }





    @AfterMethod
    public void tearDown(){
            driver.quit();
    }
}
