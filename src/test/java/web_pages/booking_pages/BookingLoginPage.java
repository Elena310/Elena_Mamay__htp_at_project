package web_pages.booking_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.PtopertiesReader;

import java.util.concurrent.TimeUnit;

public class BookingLoginPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingLoginPage.class);

    public static String PATH = "/Users/natalliasamarava/Final/main.properties";
    private WebDriver driver;

    public BookingLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@data-priority, '2')][2]")
    private WebElement login;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement email;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement signInButton;

    public void goToLoginPage(){
        login.click();
        LOGGER.debug("Login page is opened");
    }

    public void fillEmailInput(String emailField) {
        email.click();
        email.sendKeys(emailField);
        nextButton.click();
        LOGGER.debug("Email is entered to email field and next button is clicked");
    }

    public void fillPasswordInput(String pass) {
        password.click();
        password.sendKeys(pass);
        signInButton.click();
        LOGGER.debug("Password is entered to password field and sign in button is clicked");
    }

    public void loginToBooking() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        bookingLoginPage.goToLoginPage();
        TimeUnit.SECONDS.sleep(3);
        bookingLoginPage.fillEmailInput(PtopertiesReader.getValueProperty("TRASHMAIL_EMAIL", PATH));
        bookingLoginPage.fillPasswordInput(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        TimeUnit.SECONDS.sleep(5);
    }
}
