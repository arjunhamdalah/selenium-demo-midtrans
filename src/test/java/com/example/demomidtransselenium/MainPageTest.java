package com.example.demomidtransselenium;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private Faker faker = new Faker();

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium");
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
        List<String> args = Arrays.asList("--disable-infobars", "--headless", "--no-sandbox", "--disable-gpu", "--disable-setuid-sandbox", "--disable-dev-shm-usage");
        options.addArguments(args);
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.midtrans.com/");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkout() {
        mainPage.buyNowButton.click();
        mainPage.inputName.clear();
        mainPage.inputName.sendKeys(faker.name().name());
        mainPage.inputEmail.clear();
        mainPage.inputEmail.sendKeys(faker.internet().emailAddress());
        mainPage.inputPhone.clear();
        mainPage.inputPhone.sendKeys(faker.phoneNumber().phoneNumber());
        mainPage.inputCity.clear();
        mainPage.inputCity.sendKeys(faker.address().cityName());
        mainPage.inputAddress.clear();
        mainPage.inputAddress.sendKeys(faker.address().fullAddress());
        mainPage.inputPostalCode.clear();
        mainPage.inputPostalCode.sendKeys(faker.address().zipCode());
        mainPage.checkoutButton.click();
        assertEquals(mainPage.iframeCheckout.isDisplayed(), true);
    }
    @Test
    public void payment() throws InterruptedException {
        this.checkout();
        driver.switchTo().frame(0);
        mainPage.creditCardButton.click();
        mainPage.inputCreditCardNumber.sendKeys("5211111111111117");
        mainPage.inputCardExpiry.sendKeys("1230");
        mainPage.inputCardCCV.sendKeys("123");
        mainPage.payNowButton.click();
        Thread.sleep(3000);
        driver.switchTo().frame(mainPage.iframe3ds);
        Thread.sleep(3000);
        mainPage.inputOTP.sendKeys("112233");
        mainPage.okButton.click();
        Thread.sleep(5000);
        assertEquals(mainPage.statusSuccessLabel.isDisplayed(), true);
    }
}
