package webPages.bookingPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
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

    @FindBy(xpath = "//*[@id='b_tt_holder_1']")
    private WebElement currencyIcon;

    @FindBy(xpath = "//*[@id='b_tt_holder_2']")
    private WebElement languageIcon;

    @FindBy(xpath = "//*[@id='b_tt_holder_3']")
    private WebElement emailIcon;

    @FindBy(xpath = "//*[@id='b_tt_holder_4']")
    private WebElement questionIcon;

    @FindBy(xpath = "//*[contains(@class, 'add-property__button')]")
    private WebElement propertyListIcon;

    @FindBy(xpath = "//*[contains(@alt, 'Profile')]")
    private WebElement avatarIcon;

    @FindBy(xpath = "//*[contains(@class, 'header_name')]")
    private WebElement yourAccount;
}