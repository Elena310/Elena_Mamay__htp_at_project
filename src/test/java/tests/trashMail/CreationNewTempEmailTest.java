package tests.trashMail;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import settings.MainSteps;
import webDriver.Config;
import webDriver.Driver;
import webPages.trashMailPages.TrashMailRegistrationPage;
import webPages.trashMailPages.TrashmailManagerPage;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CreationNewTempEmailTest {
    public static String PATH = "/Users/natalliasamarava/Final/property.properties";
    WebDriver driver = Driver.getDriver(Config.CHROME);
    TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);


    @Test
    public void createNewTempEmail() throws InterruptedException, IOException {
        Properties prop = MainSteps.getProperties(PATH);
        driver.navigate().to("https://trashmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        trashMailRegistrationPage.openLoginPage();
        trashMailRegistrationPage.setExistingUserName(prop.getProperty("TRASHMAIL_USER"));
        trashMailRegistrationPage.setExistingPassword(prop.getProperty("PASSWORD"));
        trashMailRegistrationPage.loginToTrashmail();
        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        trashmailManagerPage.addEmailAddress();
        System.out.println(trashmailManagerPage.getTrashEmailAddress());
    }
}
