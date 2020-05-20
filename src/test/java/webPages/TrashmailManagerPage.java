package webPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrashmailManagerPage {
    private WebDriver driver;

    public TrashmailManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@id='fe-add-btnInnerEl']")
    private WebElement addingEmailAddressButton;


     String disposableName =
            String.valueOf(driver.findElement(By.xpath("//*[contains(@class,'disposable-name')]/div")).getText());
     String domain =
            String.valueOf(driver.findElement(By.xpath("//*[contains(@class,'disposable-domain')]/div))")).getText());
     String trashEmailAddress = disposableName + domain;

    public void addEmailAddress(){
        addingEmailAddressButton.click();
    }

    public String getTrashEmailAddress(String disposableName, String domain){
        return trashEmailAddress = disposableName + domain;
    }


}
