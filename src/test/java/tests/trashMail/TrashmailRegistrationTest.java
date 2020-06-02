package tests.trashMail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;
import web_pages.trashmail_pages.TrashMailRegistrationPage;

import java.util.concurrent.TimeUnit;

public class TrashmailRegistrationTest {
    WebDriver driver = Driver.getDriver();
    TrashMailRegistrationPage trashMailRegistrationPage = new TrashMailRegistrationPage(driver);

    @Test
    public void CreateNewUser(){
        driver.navigate().to("https://trashmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        trashMailRegistrationPage.openRegistration();
        trashMailRegistrationPage.setEmailWithValidAllFields("lex300", "muzprosvet",
                "muzprosvet", "scotty_wehner71@0box.eu");
        trashMailRegistrationPage.submitRegistration();
        Assert.assertTrue("Registration is failed", trashMailRegistrationPage.successfullTextMessageIsDisplayed());

    }

    @After
    public void close(){
        driver.close();
        driver.quit();
    }
}
