package tests.trashMail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.yandex_pages.LoginToEmaiYandexPage;
import java.io.IOException;

public class EmailVerificationTest {
    WebDriver driver = Driver.getDriver();

    @Test
    public void verifyEmail() throws InterruptedException, IOException {
        LoginToEmaiYandexPage loginToEmaiYandexPage = new LoginToEmaiYandexPage(driver);
        loginToEmaiYandexPage.verifyEmailRegistration();
    }

    @After
    public void closeDriver(){
        Driver.closeDriver();
    }
}
