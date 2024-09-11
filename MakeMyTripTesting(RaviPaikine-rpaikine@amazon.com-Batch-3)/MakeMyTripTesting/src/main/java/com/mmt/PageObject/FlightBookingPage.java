package com.mmt.PageObject;

import com.mmt.Setup_BaseClass.Setup_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightBookingPage extends Setup_BaseClass {


    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    private WebElement select_Trip;

    @FindBy(xpath = "//span[normalize-space()='From']")
    private WebElement from_City;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement txt_FromCity;

    @FindBy(xpath = "//span[normalize-space()='To']")
    private WebElement to_City;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement txt_ToCity;

    @FindBy(xpath = "//span[normalize-space()='Departure']")
    private WebElement check_DepartureDate;

    @FindBy(xpath = "//div[@aria-label='Mon Dec 25 2023']//p[contains(text(),'25')]")
    private WebElement select_DepartureDate;

    @FindBy(xpath = "//span[normalize-space()='Return']")
    private WebElement check_ReturnDate;

    @FindBy(xpath = "//div[@aria-label='Sat Dec 30 2023']//p[contains(text(),'30')]")
    private WebElement select_ReturnDate;

    @FindBy(xpath = "//label[@for='travellers']")
    private WebElement select_Class;

    @FindBy(xpath = "//li[normalize-space()='Economy/Premium Economy']")
    private WebElement typeOfClass;

    @FindBy(xpath = "//button[normalize-space()='APPLY']")
    private WebElement click_Apply;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    private WebElement click_SearchBtn;

    @FindBy(xpath = "//button[normalize-space()='Book Now']")
    private WebElement click_BookNow;

    @FindBy(xpath = "//p[normalize-space()='Comfort']")
    private WebElement select_Fare;

    @FindBy(xpath = "//div[@class='multifareFooter']//button[@id='bookbutton-RKEY:7ec427bc-1b86-4d62-b706-612666d18171:6_0~~~RKEY:7ec427bc-1b86-4d62-b706-612666d18171:139_0']")
    private WebElement click_Continue;

    @FindBy(xpath = "//input[@id='zc-fdc-checkbox']")
    private WebElement select_ZeroCancellation;

    @FindBy(xpath = "//div[@class='insRadioSection appendBottom8 checked']//span[@class='darkText lightFont fontSize14']")
    private WebElement select_SecureTrip;

    @FindBy(xpath = "//button[normalize-space()='+ ADD NEW ADULT']")
    private WebElement click_AddAdult;

    @FindBy(xpath = "//div[@class='AdultFormWrapper collapse show']//input[@placeholder='First & Middle Name']")
    private WebElement enter_FirstNMidName;

    @FindBy(xpath = "//div[@class='AdultFormWrapper collapse show']//input[@placeholder='Last Name']")
    private WebElement enter_LastName;
    @FindBy(xpath = "//*[@id='wrapper_ADULT']/div[3]/div[2]/div[2]/div/div/div[1]/div[3]/div/div/label[1]")
    private WebElement select_Gender;

    @FindBy(xpath = "//input[@placeholder='Mobile No']")
    private WebElement enter_MobileNo;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement enter_Email;

    @FindBy(xpath = "//input[@id='pincode_gst_info']")
    private WebElement enter_Pincode;

    @FindBy(xpath = "//input[@id='address_gst_info']")
    private WebElement enter_Address;

    @FindBy(xpath = "//span[@class='checkboxWpr']//b")
    private WebElement check_Confirm;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement confirm_Continue;


    public FlightBookingPage(WebDriver driver) {
        PageFactory.initElements(Setup_BaseClass.driver, this);
    }

    public void search_Flights(WebDriver driver) throws InterruptedException {
        select_Trip.click();
        Thread.sleep(3000);
        from_City.click();
        Thread.sleep(3000);
        txt_FromCity.sendKeys("Mumbai");
        Thread.sleep(5000);

        List<WebElement> dynamicList1 = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));

        for (WebElement element1 : dynamicList1) {
            String list1 = element1.getText();
            if (list1.contains("Mumbai")) {
                element1.click();
                break;
            }
        }
        Thread.sleep(2000);
        to_City.click();
        Thread.sleep(3000);
        txt_ToCity.sendKeys("Delhi");
        Thread.sleep(5000);
        List<WebElement> dynamicList2 = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));

        for (WebElement element2 : dynamicList2) {
            String list2 = element2.getText();
            if (list2.contains("Delhi")) {
                element2.click();
                break;
            }
        }
        Thread.sleep(2000);
        check_DepartureDate.click();
        Thread.sleep(3000);
        select_DepartureDate.click();
        Thread.sleep(3000);
        check_ReturnDate.click();
        Thread.sleep(3000);
        select_ReturnDate.click();
        Thread.sleep(3000);
        select_Class.click();
        Thread.sleep(3000);
        typeOfClass.click();
        Thread.sleep(3000);
        click_Apply.click();
        Thread.sleep(3000);
        click_SearchBtn.click();
        Thread.sleep(10000);
        List<WebElement> flightList1 = driver.findElements(By.xpath("//div[@class='listingCardWrap']//label"));

        for(WebElement fl1:flightList1){
            String text1 = fl1.getText();
            if (text1.contains("flightCard-0")){
                fl1.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]")).click();
        Thread.sleep(3000);
        List<WebElement> flightList2 = driver.findElements(By.xpath("//div[@class='listingCardWrap']//label"));

        for(WebElement fl2:flightList2){
            String text2 = fl2.getText();
            if (text2.contains("flightCard-0")){
                fl2.click();
                break;
            }
        }


        click_BookNow.click();
        Thread.sleep(3000);
        select_Fare.click();
        Thread.sleep(3000);
        click_Continue.click();
    }

    public void book_Flight(WebDriver driver) throws InterruptedException {

        driver.get("https://www.makemytrip.com/flight/reviewDetails/?itineraryId=306cd1abad838d756da2b73e9892a901b3a757cd&crId=1b9b3c8a-ceb1-451c-bc04-57d2f8618787&cur=INR&rKey=RKEY:7ec427bc-1b86-4d62-b706-612666d18171:6_0~~~RKEY:7ec427bc-1b86-4d62-b706-612666d18171:139_0&ccde=IN&xflt=eyJjIjoiRSIsInAiOiJBLTFfQy0wX0ktMCIsInQiOiIiLCJzIjoiQk9NLURFTC0yMDIzMTIyNSRERUwtQk9NLTIwMjMxMjMwIiwiSXRpbmVyYXJ5SWQiOiJCT00tREVMLTI1LzEyLzIwMjNfREVMLUJPTS0zMC8xMi8yMDIzIiwiVHJpcFR5cGUiOiJSIiwiUGF4VHlwZSI6IkEtMV9DLTBfSS0wIiwiSW50bCI6ZmFsc2UsIkNhYmluQ2xhc3MiOiJFIiwiQ2NkZSI6ImluIiwiUGZ0IjoiIiwiUGFmcyI6IiIsIkZvcndhcmRGbG93UmVxdWlyZWQiOnRydWUsIkNtcElkIjoiIn0=");
        Thread.sleep(5000);

        Actions actions = new Actions(Setup_BaseClass.driver);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//h3[normalize-space()='Unsure of your travel plans?']"))).perform();
        Thread.sleep(3000);
        select_ZeroCancellation.click();
        Thread.sleep(5000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//span[normalize-space()='Trip Secure']"))).perform();
        Thread.sleep(3000);
        select_SecureTrip.click();
        Thread.sleep(3000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath(" //h2[normalize-space()='Traveller Details']"))).perform();
        Thread.sleep(3000);
        click_AddAdult.click();
        Thread.sleep(3000);
        click_AddAdult.click();
        Thread.sleep(3000);
        enter_FirstNMidName.sendKeys("John Will");
        Thread.sleep(3000);
        enter_LastName.sendKeys("Doe");
        Thread.sleep(3000);
        select_Gender.click();
        Thread.sleep(3000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//p[@class='fontSize14 boldFont appendBottom15']"))).perform();
        Thread.sleep(3000);
        enter_MobileNo.sendKeys("1234567890");
        Thread.sleep(3000);
        enter_Email.sendKeys("john.doe@hotmail.com");
        Thread.sleep(3000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//h2[normalize-space()='Your pincode and state']"))).perform();
        Thread.sleep(3000);
        enter_Pincode.sendKeys("0");
        Thread.sleep(3000);

        //Using JavaSExecutor to avoiding clicking overlay element
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('dt_state_gst_info').click()");

        Thread.sleep(3000);

        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='dropdownListWpr']//li"));
        for (WebElement ele : element) {
            String states = ele.getText();
            if (states.contains("Maharashtra")) {
                ele.click();
                break;
            }
        }
        Thread.sleep(2000);
        enter_Address.sendKeys("Pune");
        Thread.sleep(2000);
        check_Confirm.click();
        Thread.sleep(3000);
        confirm_Continue.click();

    }

}