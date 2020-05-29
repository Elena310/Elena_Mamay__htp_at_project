package webPages.bookingPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingRegistrationPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingRegistrationPage.class);
    private WebDriver driver;

    public BookingRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='login_name_register']")
    private WebElement emailInput;

    @FindBy(xpath="//button[@class='bui-button bui-button--large bui-button--wide']")
    private WebElement startButton;

    @FindBy(xpath="//* [@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath="//* [@id='confirmed_password']")
    private WebElement confirmedPasswordInput;

    @FindBy(xpath="//* [@type='submit']")
    private WebElement createAccountButton;

    @FindBy(xpath="//*[contains(@aria-modal, 'true')]")
    private WebElement modalWelcome;

    public boolean modalIsDisplayed(){
      if(modalWelcome.isDisplayed()){
          LOGGER.debug("Registration is successful");
          return true;}
     else {
         LOGGER.debug("Registration is failed");
         return false;
      }
    }

    public void setEmailInput(String email){
        emailInput.sendKeys(email);
        startButton.click();
        LOGGER.debug("Email is entered to email field and start button is clicked");
    }

    public void setPasswordInput(String pass){
        passwordInput.sendKeys(pass);
        LOGGER.debug("Password is entered to password field");
    }

    public void setConfirmedPasswordInput(String pass2){
        confirmedPasswordInput.sendKeys(pass2);
        LOGGER.debug("Password is confirmed in confirm password field");
    }

    public void createAccount(){
        createAccountButton.click();
        LOGGER.debug("Create account button is clicked");
    }
}

