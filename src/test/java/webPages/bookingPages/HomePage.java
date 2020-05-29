package webPages.bookingPages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.booking.BookingRegistrationTest;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    private WebDriver driver;
    protected Actions action;
    public HomePage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
   }

    @FindBy(name = "ss")
    private WebElement cityName;

    @FindBy(xpath = "//*[@id='frm']//descendant::div[@class='xp__dates xp__group']")
    private WebElement date;

    private String dateOfArriving = "//*[contains(@data-date, '%s')]";
    private String dateOfLeaving = "//*[contains(@data-date, '%s')]";

    @FindBy(xpath = "//*[@id='xp__guests__toggle']")
    private WebElement detailsOfTrip;

    @FindBy(xpath = "//button[2]/span[@class='bui-button__text']")
    private WebElement adult;

    @FindBy(xpath = "//*[@id='group_adults']")
    private WebElement javascriptAdult;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group__field-rooms']/descendant::span[3]")
    private WebElement room;

    @FindBy(xpath = "//descendant::button[4]")
    private WebElement child;

    @FindBy(xpath="//button[@data-sb-id='main']")
    private WebElement priceChecking;

    @FindBy(xpath="//*[@class='sign_in_wrapper']")
    private WebElement registration;

    public void chooseRegistration(){
        registration.click();
        LOGGER.debug("Registration option is selected");

    }

    public void openHomePage(){
        driver.navigate().to("https://booking.com/");
        LOGGER.debug("Home page is opened");
    }

    public void fillCityName(String s) {
        cityName.sendKeys(s);
        LOGGER.debug("Name of city is selected");
    }

    public void openCalendar() {
        date.click();
        LOGGER.debug("Calendar is opened");
    }

    public static String getDateOfArriving(int arriving){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, arriving);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LOGGER.debug("Date of arriving is selected");
        return dateFormat.format(date);

    }

    public static String getDateOfLeaving(int numberOfDays){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LOGGER.debug("Date of leaving is selected");
        return dateFormat.format(date);
    }

    public void chooseDetailsOfTheTrip() {
        detailsOfTrip.click();
        LOGGER.debug("Switched to details of the trip");
    }

    public void chooseNumberOfAdults() {
        adult.click();
    }
    public void chooseNumberOfAdults2(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', 8)", javascriptAdult);
        LOGGER.debug("Number of adults is selected");
    }

    public void chooseNumberOfRooms() {
        room.click();
        LOGGER.debug("Number of rooms is selected");
    }

    public void chooseNumberOfChildren(){
        child.click();
        LOGGER.debug("Number of children is selected");
    }

    public void checkPrice(){
        priceChecking.click();
        LOGGER.debug("Switched to price checking of hotels");
    }

    public void chooseParisTrip(String nameOfCity, int arriving, int numberOfDays){
        fillCityName(nameOfCity);
        openCalendar();
        WebElement arrivingDate = driver.findElement(By.xpath(String.format(dateOfArriving, getDateOfArriving(arriving))));
        arrivingDate.click();
        WebElement leavingDate = driver.findElement(By.xpath(String.format(dateOfLeaving, getDateOfLeaving(numberOfDays))));
        leavingDate.click();
        chooseDetailsOfTheTrip();
        chooseNumberOfAdults();
        chooseNumberOfAdults();
        chooseNumberOfRooms();
        checkPrice();
        LOGGER.debug("Parameters of the trip is selected");
    }

    public void chooseMoscowTrip(String nameOfCity, int arriving, int numberOfDays){

        fillCityName(nameOfCity);
        openCalendar();
        WebElement arrivingDate = driver.findElement(By.xpath(String.format(dateOfArriving, getDateOfArriving(arriving))));
        arrivingDate.click();
        WebElement leavingDate = driver.findElement(By.xpath(String.format(dateOfLeaving, getDateOfLeaving(numberOfDays))));
        leavingDate.click();
        chooseDetailsOfTheTrip();
        action.doubleClick(adult).perform();
        action.click(room).perform();
        checkPrice();
        LOGGER.debug("Parameters of the trip is selected");
    }

    public void chooseOsloTrip(String nameOfCity, int arriving, int numberOfDays){
        fillCityName(nameOfCity);
        openCalendar();
        WebElement arrivingDate = driver.findElement(By.xpath(String.format(dateOfArriving, getDateOfArriving(arriving))));
        arrivingDate.click();
        WebElement leavingDate = driver.findElement(By.xpath(String.format(dateOfLeaving, getDateOfLeaving(numberOfDays))));
        leavingDate.click();
        chooseDetailsOfTheTrip();
        chooseNumberOfChildren();
        checkPrice();
        LOGGER.debug("Parameters of the trip is selected");
    }
    }

