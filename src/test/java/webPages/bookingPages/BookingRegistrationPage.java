package webPages.bookingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingRegistrationPage {
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
          return true;}
     else {
         return false;
      }
    }


    public void setEmailInput(String email){
        emailInput.sendKeys(email);
        startButton.click();
    }

    public void setPasswordInput(String pass){
        passwordInput.sendKeys(pass);
    }

    public void setConfirmedPasswordInput(String pass2){
        confirmedPasswordInput.sendKeys(pass2);
    }

    public void createAccount(){
        createAccountButton.click();
    }
}

