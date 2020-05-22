package webPages.trashMailPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.MainSteps;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashmailManagerPage {

    public static String PATH = "/Users/natalliasamarava/Final/property.properties";
    private WebDriver driver;

    public TrashmailManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@id='fe-add-btnInnerEl']")
    private WebElement addingEmailAddressButton;

     @FindBy(xpath="//*[contains(@class,'disposable-name')]/div")
     private WebElement disposableName;

     @FindBy(xpath="//*[contains(@class,'disposable-domain')]/div")
     private WebElement domain;

     @FindBy(xpath="//*[@id='fe-save']")
     private WebElement saveAddressButton;

     public void saveAddress(){
         saveAddressButton.click();
     }
    public void addEmailAddress(){
        addingEmailAddressButton.click();
    }

    public String getTrashEmailAddress(){
        String.valueOf(disposableName.getText());
        String.valueOf(domain.getText());
        String trashEmailAddress = disposableName.getText() + domain.getText();
        return trashEmailAddress;
    }

    public String createTempEmail() throws InterruptedException, IOException {
        Properties prop = MainSteps.getProperties("PATH");
        TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);
        trashMailRegistrationPage.openHomePage();
        trashMailRegistrationPage.openLoginPage();
        TimeUnit.SECONDS.sleep(2);
        trashMailRegistrationPage.setExistingUserName(prop.getProperty("TRASHMAIL_USER"));
        TimeUnit.SECONDS.sleep(2);
        trashMailRegistrationPage.setExistingPassword(prop.getProperty("PASSWORD"));
        TimeUnit.SECONDS.sleep(2);
        trashMailRegistrationPage.loginToTrashmail();
        TimeUnit.SECONDS.sleep(3);
        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        trashmailManagerPage.addEmailAddress();
        trashmailManagerPage.saveAddress();
        return (trashmailManagerPage.getTrashEmailAddress());




    }


}
