package web_pages.trashmail_pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.PtopertiesReader;
import java.io.IOException;


public class TrashMailRegistrationPage {

    public static String PATH = "/Users/natalliasamarava/Final/main.properties";
    private WebDriver driver;

    public TrashMailRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#tab-mob-register']")
    private WebElement newUser;

    @FindBy(xpath="//*[@id='tab-mob-register']/form/div[1]/input")
    private WebElement userNameField;

    @FindBy(xpath="//*[@id='tab-mob-register']/form/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath="//*[@id='tab-mob-register']/form/div[3]/input")
    private WebElement confirmPasswordField;

    @FindBy(xpath="//*[@id='tab-mob-register']/form/div[4]/input")
    private WebElement realEmailAddressField;

    @FindBy(xpath="//*[@id='tab-mob-register']/form/div[6]/button")
    private WebElement registrationButton;

    @FindBy(xpath="//div[@class='tm-error-message-mobile']")
    private WebElement failedRegistration;

    @FindBy(xpath="//div[@class='alert ng-scope top am-fade alert-info']")
    private WebElement successfullRegistration;

    @FindBy(xpath="//a[@href='#tab-mob-manager']")
    private WebElement addressManagerTab;

    @FindBy(xpath="//*[@id='tab-mob-manager']/form/div[1]/input")
    private WebElement existingUserName;

    @FindBy(xpath="//*[@id='tab-mob-manager']/form/div[2]/input")
    private WebElement existingPassword;

    @FindBy(xpath="//*[@id='tab-mob-manager']/form/div[4]/button")
    private WebElement loginButton;

    public void openHomePage(){
        driver.navigate().to("https://trashmail.com");
    }

    public void openRegistration(){
        newUser.click();
    }

    public TrashMailRegistrationPage setUserName(String userName){
        userNameField.click();
        userNameField.sendKeys(userName);
        return this;
    }

    public TrashMailRegistrationPage setPassword(String password){
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public TrashMailRegistrationPage setConfirmPassword(String password2){
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(password2);
        return this;
    }

    public TrashMailRegistrationPage setEmail(String email){
        realEmailAddressField.click();
        realEmailAddressField.sendKeys(email);
        return this;
    }

    public void submitRegistration(){
        registrationButton.click();
    }

    public boolean successfullTextMessageIsDisplayed() {
       if(successfullRegistration.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void setEmailWithValidAllFields(String username, String password, String password2, String email ) {
        TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);
        trashMailRegistrationPage.setUserName(username).setPassword(password).setConfirmPassword(password2).
                setEmail(email);
    }

    public void openLoginPage(){
        addressManagerTab.click();
    }

    public void setExistingUserName(String s){
        existingUserName.click();
        existingUserName.sendKeys(s);

    }

    public void setExistingPassword(String p){
        existingPassword.click();
        existingPassword.sendKeys(p);
    }

    public void loginToTrashmail(){
        loginButton.click();
    }


    public void RegisterNewUser(){
        openHomePage();
        TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);
        trashMailRegistrationPage.openRegistration();
        trashMailRegistrationPage.setEmailWithValidAllFields("lex310", "muzprosvet",
                "muzprosvet", "ElenaMamay310@yandex.by");
        trashMailRegistrationPage.submitRegistration();

    }

    public void loginWithExistingUser() throws IOException {
        openHomePage();
        TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);
        trashMailRegistrationPage.openLoginPage();
        trashMailRegistrationPage.setExistingUserName(PtopertiesReader.getValueProperty("TRASHMAIL_USER", PATH));
        trashMailRegistrationPage.setExistingPassword(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        trashMailRegistrationPage.loginToTrashmail();
    }
}




