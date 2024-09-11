package com.mmt.PageObject;

import com.mmt.Setup_BaseClass.Setup_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Setup_BaseClass {


    @FindBy(xpath = "//img[@alt='Make My Trip']")
    private WebElement mmt_Logo;
    @FindBy(xpath = "//li[@class='makeFlex hrtlCenter lhMyTrips']")
    private WebElement myTripsMenu;

    @FindBy(xpath = "//li[@class='makeFlex perfectCenter makeRelative']")
    private WebElement dealsMenu;

    @FindBy(xpath = "//span[normalize-space()='Introducing myBiz']")
    private WebElement featuredOffers;

    @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[text()='Flights']")
    private WebElement flights_Menu;

    @FindBy(xpath = "//a[text()='Hotels']")
    private WebElement hotels_Menu;

    @FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Buses']")
    private WebElement buses_Menu;

    @FindBy(xpath = "//a[@href='https://www.makemytrip.com/railways/']")
    private WebElement trains_Menu;

    @FindBy(xpath = "//a[text()='Search']")
    private WebElement searchMenu;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(Setup_BaseClass.driver, this);
    }
    public boolean headerElements() {
        return flights_Menu.isDisplayed() &&
                trains_Menu.isDisplayed() &&
                hotels_Menu.isDisplayed() &&
                buses_Menu.isDisplayed()  &&
                searchMenu.isDisplayed();
    }
    public boolean menuTags() {
            return mmt_Logo.isDisplayed() &&
                    myTripsMenu.isDisplayed() &&
                    dealsMenu.isDisplayed() &&
                    featuredOffers.isDisplayed() &&
                    loginBtn.isDisplayed();

    }



}
