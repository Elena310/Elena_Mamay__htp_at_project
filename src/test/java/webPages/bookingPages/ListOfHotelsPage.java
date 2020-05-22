package webPages.bookingPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ListOfHotelsPage {

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
    }

    public void chooseMinPriceHotel() {
        minPriceHotel.click();
    }

    public void getSortingStartWithLowCost() throws InterruptedException {
        sortingStartWithLowCost.click();

    }

    public void choose3starsHotel() {
        stars3Hotel.click();
    }

    public void choose4starsHotel() {
        stars4Hotel.click();
    }

    public void scrollByTheTenthHotel() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);
    }

    public int getExpensivePriceHotelDay() throws InterruptedException {
        String exphot = maxPriceHotel.getText();
        System.out.println(exphot);
        exphot = exphot.replaceAll("[^0-9]+", "");
        int priceHotelDay = Integer.parseInt(exphot);
        System.out.println(priceHotelDay);
        return (priceHotelDay);
    }

    public int getCheapPriceHotelDay() throws InterruptedException {
        chooseMinPriceHotel();
        String cheaphot = minPriceHotel.getText();
        System.out.println(cheaphot);
        cheaphot = cheaphot.replaceAll("[^0-9]+", "");
        int priceHotelDay = Integer.parseInt(cheaphot);
        System.out.println(priceHotelDay);
        return priceHotelDay;
    }

    public int getRealPriceDayParisHotel() {
        String priceTextFinal = realPriceDay.getText();
        System.out.println(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int priceHotel = Integer.parseInt(priceTextFinal);
        int priceDay = priceHotel / 7;
        System.out.println(priceDay);
        return priceDay;
    }


    public int getRealPriceDayMoscowHotel() {
        String priceTextFinal = realPriceDay.getText();
        System.out.println(priceTextFinal);
        priceTextFinal = priceTextFinal.replaceAll("[^0-9]+", "");
        int priceHotel = Integer.parseInt(priceTextFinal);
        int priceDay = priceHotel / 5;
        System.out.println(priceDay);
        return priceDay;
    }

    public void moveCursorToElement() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(addressOfTenthHotel).build().perform();
        TimeUnit.SECONDS.sleep(5);
    }

    public void changeBackgroundColor() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", addressOfTenthHotel);
        TimeUnit.SECONDS.sleep(5);
    }

    public void changeTextColor() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", addressOfTenthHotel);
        TimeUnit.SECONDS.sleep(5);
    }

    public void checkParisPriceHotel() throws InterruptedException {
        chooseMaxPriceHotel();
        getSortingStartWithLowCost();
        getExpensivePriceHotelDay();
        getRealPriceDayParisHotel();

    }

    public void checkMoscowPriceHotel() throws InterruptedException {
        chooseMinPriceHotel();
        getCheapPriceHotelDay();
        getRealPriceDayMoscowHotel();
    }

    public void checkChangesInStyleOfAddressHotel() throws InterruptedException {
        choose3starsHotel();
        choose4starsHotel();
        scrollByTheTenthHotel();
        moveCursorToElement();
        changeBackgroundColor();
        changeTextColor();
    }

    public String getTextColor() {
        return addressOfTenthHotel.getCssValue("color");
    }
}
