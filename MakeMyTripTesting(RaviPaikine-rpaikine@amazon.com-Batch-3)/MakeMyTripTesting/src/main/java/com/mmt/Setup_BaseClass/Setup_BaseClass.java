package com.mmt.Setup_BaseClass;

import com.mmt.Util.ScreenshotHandler;
import com.mmt.Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Setup_BaseClass {

    public static WebDriver driver;

    public void Setup_BaseClass() throws InterruptedException {
        String url = "https://www.makemytrip.com/";
        String browserName = "chrome";

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.get(url);
            Thread.sleep(12000);

            WebElement selectFrame = driver.findElement(By.xpath("//section[@class='modalMain tcnFooter']"));
            selectFrame.click();
            Thread.sleep(10000);

            // Locate the login window's close button
            WebElement closeButton = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
            Thread.sleep(10000);

            // Close the login window
            closeButton.click();
            Thread.sleep(10000);

            // Switch back to the main context
            driver.switchTo().defaultContent();

        } else {
            System.out.println("Driver not initialized!");
        }

    }



}
