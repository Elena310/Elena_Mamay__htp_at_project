package webPages.yandexPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.MainSteps;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginToEmaiYandexPage {

    public static String URL_YANDEX = "/Users/natalliasamarava/Final/property.properties";
    private WebDriver driver;

    public LoginToEmaiYandexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[contains(@class, 'desk-notif-card__card')]/a")
    private WebElement emailSection;

    @FindBy(xpath="//*[@id='passp-field-login']")
    private WebElement loginInput;

    @FindBy(xpath="//*[contains(@type, 'submit')]")
    private WebElement loginSubmitButton;

    @FindBy(xpath="//*[@id='passp-field-passwd']")
    private WebElement passwordInput;

    @FindBy(xpath="//*[@type='submit']")
    private WebElement passwordSubmitButton;

    @FindBy(xpath="//*[@title='One click to confirm']")
    private WebElement emailVerification;

    @FindBy(xpath="//*[contains(@class, 'button-inner')]")
    private WebElement confirmationLink;

    public void openYandexPage(){
        driver.navigate().to("https://www.yandex.by");
    }

    public void goToEmailBox(){
        emailSection.click();
    }

    public void fillTheEmailField(String login){
        loginInput.click();
        loginInput.sendKeys(login);
        loginSubmitButton.click();
    }

    public void fillThePasswordField(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
        passwordSubmitButton.click();
    }

    public void verifyEmail(){
        emailVerification.click();
        confirmationLink.click();
    }

    public void verifyEmailRegistration() throws IOException, InterruptedException {
        openYandexPage();
        Properties prop = MainSteps.getProperties(URL_YANDEX);
        TimeUnit.SECONDS.sleep(5);
        LoginToEmaiYandexPage loginToEmaiYandexPage = new LoginToEmaiYandexPage(driver);
        loginToEmaiYandexPage.goToEmailBox();
        loginToEmaiYandexPage.fillTheEmailField(prop.getProperty("YANDEX_EMAIL"));
        TimeUnit.SECONDS.sleep(5);
        loginToEmaiYandexPage.fillThePasswordField(prop.getProperty("YANDEX_PASSWORD"));
        loginToEmaiYandexPage.verifyEmail();
    }
}
