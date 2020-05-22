package webPages.bookingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingLoginPage {

    public static String PATH = "/Users/natalliasamarava/Final/property.properties";
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
    }

    public void fillEmailInput(String emailAddress) {
        email.click();
        email.sendKeys(emailAddress);
        nextButton.click();
    }

    public void fillPasswordInput(String pass) {
        password.click();
        password.sendKeys(pass);
        signInButton.click();
    }
}
