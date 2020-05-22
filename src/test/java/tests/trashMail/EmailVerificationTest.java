package tests.trashMail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webDriver.Config;
import webDriver.Driver;
import webPages.yandexPages.LoginToEmaiYandexPage;
import java.io.IOException;

public class EmailVerificationTest {
    WebDriver driver = Driver.getDriver(Config.CHROME);

    @Test
    public void verifyEmail() throws InterruptedException, IOException {
        LoginToEmaiYandexPage loginToEmaiYandexPage = new LoginToEmaiYandexPage(driver);
        loginToEmaiYandexPage.verifyEmailRegistration();
    }

    @After
    public void close(){
        driver.close();
        driver.quit();
    }
}
