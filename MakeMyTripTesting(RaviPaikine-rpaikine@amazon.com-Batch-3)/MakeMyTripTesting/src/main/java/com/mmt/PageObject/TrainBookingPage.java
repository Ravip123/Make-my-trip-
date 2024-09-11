package com.mmt.PageObject;

import com.mmt.Setup_BaseClass.Setup_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrainBookingPage extends Setup_BaseClass {


    @FindBy(xpath = "//a[@href='https://www.makemytrip.com/railways/']")
    private WebElement trainsBtn;

    @FindBy(xpath = "//label[@for='fromCity']")
    private WebElement from_City;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement txt_FromCity;


    @FindBy(xpath = "//span[normalize-space()='To']")
    private WebElement to_City;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement txt_ToCity;

    @FindBy(xpath = "//input[@id='travelDate']")
    private WebElement check_TravelDate;

    @FindBy(xpath = "//div[@aria-label='Sat Dec 30 2023']")
    private WebElement select_TravelDate;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    private WebElement searchTrainsBtn;

    //select train
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]")
    private WebElement select_Class;

    @FindBy(xpath = "//div[@id='train_options_30-12-2023_0']")
    public WebElement select_Train;

    @FindBy(xpath = "//div[@class='railInfo toolTipWrap']")
    private WebElement check_Route;

    @FindBy(xpath = "//div[@class='latoBold font16 deepskyBlueText textRight appendTop100 pointerCursor']")
    public WebElement confirm_Route;

    @FindBy(xpath = "//label[contains(text(),'Zero cancellation charges when the ticket is cance')]")
    private WebElement cancellation;

    @FindBy(xpath = "//a[@class='makeFlex spaceBetween hrtlCenter']")
    private WebElement add_Travellers;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='age']")
    private WebElement age;

    @FindBy(xpath = "//div[contains(@class,'formField genderField makeFlex column appendRight20')]//p[contains(@class,'selectedQuota close cursorPointer latoBold font12 makeFlex')]")
    private WebElement gender;

    @FindBy(xpath = "//div[@class='formField genderField makeFlex column appendRight20']//li[1]")
    private WebElement select_Gender;

    @FindBy(xpath = " //label[normalize-space()='Nationality']")
    private WebElement select_Nationality;

    @FindBy(xpath = "//label[normalize-space()='Berth Preference']")
    private WebElement berth_Preference;

    @FindBy(xpath = "//label[normalize-space()='Meal Preference']")
    private WebElement meal_Preference;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement click_Add;

    @FindBy(xpath = "//input[@id='contactEmail']")
    private WebElement enter_Email;

    @FindBy(xpath = "//input[@id='mobileNumber']")
    private WebElement enter_MobileNumber;

    @FindBy(xpath = "//label[@for='tvlIns1']")
    private WebElement travel_Insurance;

    @FindBy(xpath = "//span[@class='checkboxWpr']//b")
    private WebElement confirm_BillingDetails;

    @FindBy(xpath = "//span[normalize-space()='Pay & Book Now']")
    private WebElement click_PayNow;






    public TrainBookingPage(WebDriver driver) {
        PageFactory.initElements(Setup_BaseClass.driver, this);
    }

    public String search_Trains() throws InterruptedException {
        trainsBtn.click();
        Thread.sleep(8000);
        from_City.click();
        Thread.sleep(2000);
        txt_FromCity.sendKeys("Mumbai");
        Thread.sleep(5000);
        List<WebElement> dynamicList1 = driver.findElements(By.cssSelector("p[class='searchedResult font14 darkText']"));

        for (int i = 0; i < dynamicList1.size(); i++) {
            String text = dynamicList1.get(i).getText();
            System.out.println("From " + text);
            if (text.contains("Mumbai")) {
                dynamicList1.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        to_City.click();
        Thread.sleep(2000);
        txt_ToCity.sendKeys("Delhi");
        Thread.sleep(5000);
        List<WebElement> dynamicList2 = driver.findElements(By.cssSelector("p[class='searchedResult font14 darkText']"));

        for (int i = 0; i < dynamicList2.size(); i++) {
            String text = dynamicList2.get(i).getText();
            System.out.println("To " + text);
            if (text.contains("Delhi")) {
                dynamicList2.get(i).click();
                break;
            }
        }

        Thread.sleep(5000);
        check_TravelDate.click();
        Thread.sleep(2000);
        select_TravelDate.click();
        Thread.sleep(3000);
        searchTrainsBtn.click();
        Thread.sleep(10000);

        Actions actions = new Actions(Setup_BaseClass.driver);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//p[normalize-space()='Journey Class Filters']"))).perform();
        Thread.sleep(2000);

        select_Class.click();
        Thread.sleep(3000);
        select_Train.click();
        Thread.sleep(2000);
        check_Route.isDisplayed();
        Thread.sleep(2000);
        confirm_Route.click();
        Thread.sleep(2000);
        cancellation.click();
        Thread.sleep(3000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//p[@class='font20 latoBlack blackText appendBottom20']"))).perform();
        Thread.sleep(2000);
        add_Travellers.click();
        Thread.sleep(2000);
        name.sendKeys("John Doe");
        Thread.sleep(2000);
        age.sendKeys("28");
        Thread.sleep(2000);
        gender.click();
        Thread.sleep(5000);
        select_Gender.click();
        Thread.sleep(5000);
        select_Nationality.isDisplayed();
        Thread.sleep(2000);
        berth_Preference.isDisplayed();
        Thread.sleep(2000);
        meal_Preference.isDisplayed();
        Thread.sleep(2000);
        click_Add.click();
        Thread.sleep(2000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//span[normalize-space()='Email Id']"))).perform();
        Thread.sleep(3000);
        enter_Email.sendKeys("john.doe@hotmail.com");
        Thread.sleep(3000);
        enter_MobileNumber.sendKeys("1234567890");
        Thread.sleep(3000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath(" //label[@for='tvlIns1']"))).perform();
        Thread.sleep(3000);
        confirm_BillingDetails.click();
        Thread.sleep(3000);
        click_PayNow.click();
        Thread.sleep(3000);
        return null;

    }

}