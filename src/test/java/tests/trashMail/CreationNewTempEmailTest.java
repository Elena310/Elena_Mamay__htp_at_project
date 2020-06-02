package tests.trashMail;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilites.PtopertiesReader;
import web_driver.Driver;
import web_pages.trashmail_pages.TrashMailRegistrationPage;
import web_pages.trashmail_pages.TrashmailManagerPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreationNewTempEmailTest {
    public static String PATH = "/Users/natalliasamarava/Final/main.properties";
    WebDriver driver = Driver.getDriver();
    TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);

    @Test
    public void createNewTempEmail() throws InterruptedException, IOException {
        driver.navigate().to("https://trashmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        trashMailRegistrationPage.openLoginPage();
        trashMailRegistrationPage.setExistingUserName(PtopertiesReader.getValueProperty("TRASHMAIL_USER", PATH));
        trashMailRegistrationPage.setExistingPassword(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        trashMailRegistrationPage.loginToTrashmail();
        TrashmailManagerPage trashmailManagerPage = new TrashmailManagerPage(driver);
        trashmailManagerPage.addEmailAddress();
        System.out.println(trashmailManagerPage.getTrashEmailAddress());
    }
}
