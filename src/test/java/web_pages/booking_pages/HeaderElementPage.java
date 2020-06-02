package web_pages.booking_pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderElementPage {
    private static final Logger LOGGER = LogManager.getLogger(HeaderElementPage.class);
    private WebDriver driver;

    public HeaderElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='logo_no_globe_new_logo']")
    private WebElement logo;

    @FindBy(xpath = "//*[@class='xpb__link selected']")
    private WebElement homeIcon;

    @FindBy(xpath = "//*[@data-decider-header='flights']")
    private WebElement flightsIcon;

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[2]")
    private WebElement carRentalsIcon;

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[3]")
    private WebElement attractionsIcon;

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[4]")
    private WebElement airportTaxisIcon;

    @FindBy(xpath = "//*[contains(@data-title, 'Choose your currency')]")
    private WebElement currencyIcon;

    @FindBy(xpath = "//*[contains(@data-title, 'Select your language')]")
    private WebElement languageIcon;

    @FindBy(xpath = "//*[contains(@data-title, 'View')]")
    private WebElement emailIcon;

    @FindBy(xpath = "//*[contains(@class, 'uc_helpcenter')]")
    private WebElement questionIcon;

    @FindBy(xpath = "//*[contains(@class, 'add-property__button')]")
    private WebElement propertyListIcon;

    @FindBy(xpath = "//*[contains(@alt, 'Profile')]")
    private WebElement avatarIcon;

    @FindBy(xpath = "//*[contains(@class, 'header_name')]")
    private WebElement yourAccount;

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }

    public boolean isHomeIconDisplayed(){
        return homeIcon.isDisplayed();
    }

    public boolean isFlightsIconDisplayed(){
        return flightsIcon.isDisplayed();
    }

    public boolean isCarRentalsIconDisplayed(){
        return carRentalsIcon.isDisplayed();
    }

    public boolean isAttractionsIconDisplayed(){
        return attractionsIcon.isDisplayed();
    }

    public boolean isAirportTaxisIconDisplayed(){
        return airportTaxisIcon.isDisplayed();
    }

    public boolean isCurrencyIconDisplayed(){
        return currencyIcon.isDisplayed();
    }

    public boolean isLanguageIconDisplayed(){
        return languageIcon.isDisplayed();
    }

    public boolean isEmailIconDisplayed(){
        return emailIcon.isDisplayed();
    }

    public boolean isQuestionIconDisplayed(){
        return questionIcon.isDisplayed();
    }

    public boolean isPropertyListIconDisplayed(){
        return propertyListIcon.isDisplayed();
    }

    public boolean isAvatarIconDisplayed(){
        return avatarIcon.isDisplayed();
    }

    public boolean isYourAccountDisplayed(){
        return yourAccount.isDisplayed();
    }
}
