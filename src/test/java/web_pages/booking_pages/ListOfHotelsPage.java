package web_pages.booking_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ListOfHotelsPage {

    private static final Logger LOGGER = LogManager.getLogger(ListOfHotelsPage.class);

    private WebDriver driver;
    protected Actions action;

    public ListOfHotelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
    }

    @FindBy(xpath = "//*[@data-id='pri-5']")
    private WebElement maxPriceHotel;

    @FindBy(xpath = "//div[@id='sort_by']/ul/li[3]/a")
    private WebElement sortingStartWithLowCost;

    @FindBy(xpath = "//div[@class='bui-checkbox__label filter_item css-checkbox']")
    private WebElement minPriceHotel;

    @FindBy(xpath = "//a[@data-id='class-3']")
    private WebElement stars3Hotel;

    @FindBy(xpath = "//a[@data-id='class-4']")
    private WebElement stars4Hotel;

    @FindBy(xpath = "//div[contains(@class, 'sr_item_default')][10]")
    private WebElement tenthHotel;

    @FindBy(xpath = "//a[@data-id='pri-5']/label/div/span")
    private WebElement expensivePriceHotelDay;

    @FindBy(xpath = "//div[@class='bui-checkbox__label filter_item css-checkbox']/span")
    private WebElement cheapPriceHotelDay;

    @FindBy(xpath = "//div[2][@class='prco-ltr-right-align-helper']/div")
    private WebElement realPriceDay;

    @FindBy(xpath = "//descendant::div[contains(@class, 'sr_card_address_line')][10]")
    private WebElement addressOfTenthHotel;

    public void chooseMaxPriceHotel() {
        maxPriceHotel.click();
        LOGGER.debug("Hotels with max price are selected");
    }

    public void chooseMinPriceHotel() {
        minPriceHotel.click();
        LOGGER.debug("Hotels with min price are selected");
    }

    public void getSortingStartWithLowCost() throws InterruptedException {
        sortingStartWithLowCost.click();
        LOGGER.debug("Sorting with low cost is selected");
    }

    public void choose3starsHotel() {
        stars3Hotel.click();
        LOGGER.debug("3 stars hotels are selected");
    }

    public void choose4starsHotel() {
        stars4Hotel.click();
        LOGGER.debug("4 stars hotels are selected");
    }

    public void scrollByTheTenthHotel() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);
        LOGGER.debug("Page scrolled to tenth hotel");
    }

    public int getExpensivePriceHotelDay() throws InterruptedException {
        String exphot = maxPriceHotel.getText();
        LOGGER.info(exphot);
        exphot = exphot.replaceAll("[^0-9]+", "");
        int priceHotelDay = Integer.parseInt(exphot);
        LOGGER.info(priceHotelDay);
        LOGGER.debug("Price of hotel is displayed");
        return (priceHotelDay);
    }

    public int getCheapPriceHotelDay() throws InterruptedException {
        chooseMinPriceHotel();
        String cheaphot = minPriceHotel.getText();
        LOGGER.info(cheaphot);
        cheaphot = cheaphot.replaceAll("[^0-9]+", "");
        int priceHotelDay = Integer.parseInt(cheaphot);
        LOGGER.info(priceHotelDay);
        LOGGER.debug("Price of hotel is displayed");
        return priceHotelDay;
    }

    public int getRealPriceDayParisHotel() {
        String priceTextFinal = realPriceDay.getText();
        LOGGER.info(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int priceHotel = Integer.parseInt(priceTextFinal);
        int priceDay = priceHotel / 7;
        LOGGER.info(priceDay);
        LOGGER.debug("Daily price hotel is displayed ");
        return priceDay;
    }

    public int getRealPriceDayMoscowHotel() {
        String priceTextFinal = realPriceDay.getText();
        LOGGER.info(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int priceHotel = Integer.parseInt(priceTextFinal);
        int priceDay = priceHotel / 5;
        LOGGER.info(priceDay);
        LOGGER.debug("Daily price hotel is displayed ");
        return priceDay;
    }

    public void moveCursorToElement() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(addressOfTenthHotel).build().perform();
        TimeUnit.SECONDS.sleep(5);
        LOGGER.debug("Cursor is moved to element ");
    }

    public void changeBackgroundColor() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", addressOfTenthHotel);
        TimeUnit.SECONDS.sleep(5);
        LOGGER.debug("Background color is changed to green");
    }

    public void changeTextColor() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", addressOfTenthHotel);
        TimeUnit.SECONDS.sleep(5);
        LOGGER.debug("Text color is changed to red");
    }

    public void checkParisPriceHotel() throws InterruptedException {
        chooseMaxPriceHotel();
        TimeUnit.SECONDS.sleep(4);
        getSortingStartWithLowCost();
        TimeUnit.SECONDS.sleep(4);
        getExpensivePriceHotelDay();
        getRealPriceDayParisHotel();
        LOGGER.debug("Real price day of hotel >= price of expensive hotel");

    }

    public void checkMoscowPriceHotel() throws InterruptedException {
        chooseMinPriceHotel();
        TimeUnit.SECONDS.sleep(4);
        getCheapPriceHotelDay();
        getRealPriceDayMoscowHotel();
        LOGGER.debug("Real price day of hotel <= price of cheap hotel");
    }

    public void checkChangesInStyleOfAddressHotel() throws InterruptedException {
        choose3starsHotel();
        choose4starsHotel();
        scrollByTheTenthHotel();
        moveCursorToElement();
        changeBackgroundColor();
        changeTextColor();
        LOGGER.debug("Text color and background color are changed");
    }

    public String getTextColor() {
        return addressOfTenthHotel.getCssValue("color");
    }
}
