package com.mmt.PageObject;

import com.mmt.Setup_BaseClass.Setup_BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class oginPage extends Setup_BaseClass {

    @FindBy(xpath = "//*[@id='SW']/div[1]/div[1]/ul/li[4]")
    private WebElement createAccBtn;

    @FindBy(xpath = "//li[@class='active']")
    private WebElement personalAccBtn;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailOrMobileInput;

    @FindBy(xpath = "//button[@data-cy='continueBtn']")
    private WebElement continueButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(String url) {
        driver.get(url);
    }

    public void clickLoginOrCreateAccount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(createAccBtn)).click();
        } catch (Exception e) {
            // If element not clickable, try scrolling into view and clicking
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", createAccBtn);
            createAccBtn.click();
        }
    }

    public void clickPersonalAccount() {
        personalAccBtn.click();
    }

    public void enterLoginDetails(String login) {
        emailOrMobileInput.sendKeys(login);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
