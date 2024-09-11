package com.mmt.PageObject;

import com.mmt.Setup_BaseClass.Setup_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBookingPage extends Setup_BaseClass {

    @FindBy(xpath = "//a[@href='https://www.makemytrip.com/hotels/']")
    private WebElement hotelsBtn;

    @FindBy(xpath = "//label[@for='city']")
    private WebElement search_Location;

    @FindBy(xpath = "//input[@placeholder='Where do you want to stay?']")
    private WebElement txt_SearchCity;

    @FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='clickable']")
    private WebElement get_City;

    @FindBy(xpath = "//input[@id='checkin']")
    private WebElement checkInBtn;

    @FindBy(xpath = "//div[@aria-label='Wed Dec 20 2023']")
    private WebElement select_CheckInDate;

    @FindBy(xpath = "//span[normalize-space()='Select Checkout Date']")
    private WebElement checkOutBtn;

    @FindBy(xpath = "//div[@aria-label='Sat Dec 30 2023']")
    private WebElement select_CheckOutDate;

    @FindBy(xpath = "//input[@id='guest']")
    private WebElement get_RoomsAndGuest;

    @FindBy(xpath = "//button[normalize-space()='Apply']")
    private WebElement click_Apply;

    @FindBy(xpath = "//span[normalize-space()='Price per Night']")
    private WebElement pricePerNightBtn;

    @FindBy(xpath = "//li[contains(text(),'₹1500-₹2500')]")
    private WebElement get_PricePerNight;

    @FindBy(xpath = "//button[@id='hsw_search_button']")
    private WebElement click_SearchBtn;

    //Select hotel to stay
    @FindBy(xpath = "//span[normalize-space()='Popular']")
    private WebElement sortBy_Popularity;

    @FindBy(xpath = "//body/div[@id='root']/div/div[@id='_Hlisting_area']/div[contains(@class,'container makeFlex spaceBetween')]/div[@id='hotelListingContainer']/div/div/div[contains(@class,'infinite-scroll-component')]/div[2]/div[1]/a[1]/div[1]/div[1]/div[1]")
    private WebElement get_Hotel;

    //Fill the details
    @FindBy(xpath = "//a[normalize-space()='BOOK THIS NOW']")
    private WebElement bookNow;
    @FindBy(xpath = "//select[@id='title']")
    private WebElement title;

    @FindBy(xpath = "//input[@id='fName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailID;

    @FindBy(xpath = "//input[@id='mNo']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//a[normalize-space()='Pay Now']")
    private WebElement paynowBtn;

    public HotelBookingPage(WebDriver driver){
        PageFactory.initElements(Setup_BaseClass.driver, this);
    }

    public void search_Hotels(WebDriver driver) throws InterruptedException {

        Thread.sleep(3000);
        hotelsBtn.click();
        Thread.sleep(10000);
        search_Location.click();
        Thread.sleep(3000);
        txt_SearchCity.sendKeys("pune");
        Thread.sleep(2000);
        get_City.click();
        Thread.sleep(2000);
        checkInBtn.click();
        Thread.sleep(2000);
        select_CheckInDate.click();
        Thread.sleep(2000);
        checkOutBtn.click();
        Thread.sleep(2000);
        select_CheckOutDate.click();
        Thread.sleep(2000);
        get_RoomsAndGuest.click();
        Thread.sleep(2000);
        click_Apply.click();
        Thread.sleep(2000);
        pricePerNightBtn.click();
        Thread.sleep(2000);
        get_PricePerNight.click();
        Thread.sleep(2000);
        click_SearchBtn.click();
        Thread.sleep(5000);
        sortBy_Popularity.click();
        Thread.sleep(2000);
        get_Hotel.isDisplayed();
        Thread.sleep(2000);

    }

    public void bookHotel(WebDriver driver) throws InterruptedException {
        driver.get("https://www.makemytrip.com/hotels/hotel-details/?hotelId=201605161134261041&_uCurrency=INR&checkin=12202023&checkout=12302023&city=CTPNQ&country=IN&filterData=HOTEL_PRICE_BUCKET%7C1500-2500&lat=18.54584&lng=73.90128&locusId=CTPNQ&locusType=city&rank=1&regionNearByExp=3&roomStayQualifier=2e0e&rsc=1e2e0e&searchText=Pune&mtkeys=-8429254285149925196");
        Thread.sleep(5000);

        WebElement checkImageButton = Setup_BaseClass.driver.findElement(By.xpath("//div[@class='slick-slider slickReset slickWarp1 imageSldr__Carosl slick-initialized']//div[@class='slick-arrow slick-next']"));
        for (int i=0; i<5; i++){
            checkImageButton.click();
            Thread.sleep(2000);
        }
        Thread.sleep(5000);
        bookNow.click();
        Thread.sleep(10000);

        Actions actions = new Actions(Setup_BaseClass.driver);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//h4[normalize-space()='Guest Details']"))).perform();
        Thread.sleep(2000);
        title.click();
        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        emailID.sendKeys("john.doe@gmail.com");
        mobileNumber.sendKeys("1234567890");
        Thread.sleep(2000);
        actions.moveToElement(Setup_BaseClass.driver.findElement(By.xpath("//a[normalize-space()='Pay Now']"))).perform();
        Thread.sleep(3000);
        paynowBtn.click();
        Thread.sleep(3000);

    }

}