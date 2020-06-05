package web_pages.silver_screen_pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.PtopertiesReader;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SilverHomePage {
    private static final Logger LOGGER = LogManager.getLogger(SilverHomePage.class);
    public static String PATH = "/Users/natalliasamarava/Final/SilverScreen.properties";

    private WebDriver driver;
    protected Actions action;

    public SilverHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
    }

    @FindBy(css = "div>#svg-icon-search")
    private WebElement searchIcon;

    @FindBy(xpath = "//*[@poster]/../..")
    private WebElement movieItem;

    @FindBy(xpath = "//*[contains(@placeholder, 'Поиск')]")
    private WebElement searchInput;

    @FindBy(css = "[type~=reset]")
    private WebElement searchButton;

    @FindBy(xpath = "//div/span/div[2]/span")
    private WebElement loginOption;

    @FindBy(xpath = "//*[contains(@type, 'email')]")
    private WebElement emailField;

    @FindBy(xpath = "//*[contains(@type, 'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement loginButton;

    @FindBy(css = "#svg-icon-rcc")
    private WebElement redCarpetClubLevel;

    @FindBy(xpath="//span[contains(text(), 'Пользователь не найден')]")
    private WebElement wrongLoginMessage;

    public boolean searchWordInTitleAndDescription(String word) {
        List<WebElement> movieTitleWithWord =
                driver.findElements(By.xpath("//*[@poster]/../div/a/span[contains(text(), 'Girl')]"));
        List<WebElement> movieDescriptionWithWord =
                driver.findElements(By.xpath("//*[@poster]/../div/div/div[contains(text(), 'Girl')]"));
        movieTitleWithWord.size();
        movieDescriptionWithWord.size();

        List<WebElement> movieTitle = driver.findElements(By.xpath("//*[@poster]/../div/a"));
        movieTitle.size();
        List<WebElement> movieDescription = driver.findElements(By.xpath("//*[@poster]/../div/div"));
        movieDescription.size();
        if (movieTitle.size() == movieTitleWithWord.size()
                || movieDescription.size() == movieDescriptionWithWord.size()) {
            LOGGER.info("All movie items have search word");
            return true;

        } else {
            LOGGER.info("Not all movie items have search word");
            return false;
        }
    }

    public void openSilverHomePage() {
        driver.navigate().to("https://silverscreen.by");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void searchMovieByWord(String word) throws InterruptedException {
        searchIcon.click();
        searchInput.sendKeys(PtopertiesReader.getValueProperty("SEARCH_WORD", PATH));
        searchButton.click();
        Thread.sleep(5);
        LOGGER.info("I sent my request to find movie");
    }

    public void moveCursorToElement() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(loginOption).build().perform();
        TimeUnit.SECONDS.sleep(5);
        LOGGER.debug("Cursor is moved to element ");
    }

    public void loginToSilverScreen() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.moveCursorToElement();
        emailField.click();
        emailField.sendKeys(PtopertiesReader.getValueProperty("EMAIL", PATH));
        passwordField.click();
        passwordField.sendKeys(PtopertiesReader.getValueProperty("PASSWORD", PATH));
        loginButton.click();
        Thread.sleep(10);
    }

    public boolean isRedCarpetRedLevelDisplayed() {
        return redCarpetClubLevel.isDisplayed();
    }

    public boolean isWarningMessageDisplayed(){
        return wrongLoginMessage.isDisplayed();
    }

    public void loginWithWrongCreds() throws InterruptedException {
        SilverHomePage silverHomePage = new SilverHomePage(driver);
        silverHomePage.moveCursorToElement();
        emailField.click();
        emailField.sendKeys(PtopertiesReader.getValueProperty("WRONG_EMAIL", PATH));
        passwordField.click();
        passwordField.sendKeys(PtopertiesReader.getValueProperty("WRONG_PASSWORD", PATH));
        loginButton.click();
        Thread.sleep(10);
    }
}

