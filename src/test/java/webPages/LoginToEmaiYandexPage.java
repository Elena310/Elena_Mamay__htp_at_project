package webPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToEmaiYandexPage {
    private WebDriver driver;

    public LoginToEmaiYandexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[contains(@class, 'desk-notif-card__card')]/a")
    private WebElement emailSection;

    @FindBy(xpath="//*[id='passp-field-login']")
    private WebElement loginInput;

    @FindBy(xpath="//*[contains(@type, 'submit')]")
    private WebElement loginSubmitButton;

    @FindBy(xpath="//*[@id='passp-field-passwd']")
    private WebElement passwordInput;

    @FindBy(xpath="//*[@type='submit']")
    private WebElement passwordSubmitButton;

    @FindBy(xpath="//*[@class='mail-MessageSnippet-Wrapper'][1]")
    private WebElement emailVerification;

    @FindBy(xpath="//*[contains(@href, 'confirm_email')]")
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
}
