package com.example.demomidtransselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://demo.midtrans.com/
public class MainPage {
    @FindBy(xpath="//*[@data-reactid='.0.0.0.2.0.0.5']")
    public WebElement buyNowButton;
    @FindBy(xpath="//*[@data-reactid='.0.0.1.0.3.0.0.0.1.0']")
    public WebElement inputName;
    @FindBy(xpath="//*[@data-reactid='.0.0.1.0.3.0.0.1.1.0']")
    public WebElement inputEmail;
    @FindBy(xpath="//*[@data-reactid='.0.0.1.0.3.0.0.2.1.0']")
    public WebElement inputPhone;
    @FindBy(xpath="//*[@data-reactid='.0.0.1.0.3.0.0.3.1.0']")
    public WebElement inputCity;
    @FindBy(xpath="//*[@data-reactid='.0.0.1.0.3.0.0.4.1.0']")
    public WebElement inputAddress;
    @FindBy(xpath="//*[@data-reactid='.0.0.1.0.3.0.0.5.1.0']")
    public WebElement inputPostalCode;
    @FindBy(css=".cart-checkout")
    public WebElement checkoutButton;
    @FindBy(css="#snap-midtrans")
    public WebElement iframeCheckout;
    @FindBy(xpath="//a[@href='#/credit-card']")
    public WebElement creditCardButton;
    @FindBy(xpath="//*[@class='card-number-input-container']/input")
    public WebElement inputCreditCardNumber;
    @FindBy(xpath="//*[@id='card-expiry']")
    public WebElement inputCardExpiry;
    @FindBy(xpath="//*[@id='card-cvv']")
    public WebElement inputCardCCV;
    @FindBy(xpath="//*[@class='card-pay-button-part']/button")
    public WebElement payNowButton;
    @FindBy(xpath="//*[@id='otp']")
    public WebElement inputOTP;
    @FindBy(xpath="//*[@name='ok']")
    public WebElement okButton;
    @FindBy(xpath="//*[@class='trans-status trans-success']")
    public WebElement statusSuccessLabel;
    @FindBy(xpath = "//*[@class='iframe-3ds']")
    public WebElement iframe3ds;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
