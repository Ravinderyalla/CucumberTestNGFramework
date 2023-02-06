package awsomecucumber.pages;

import awsomecucumber.domainobjects.BillingDetails;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameFld;
    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddressFld;
    @FindBy(id = "billing_city")
    private WebElement billingCity;
    @FindBy(id = "billing_state")
    private WebElement billingState;
    @FindBy(id = "billing_postcode")
    private WebElement billingZip;
    @FindBy(id = "billing_email")
    private WebElement billingEmail;
    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeMsg;

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public CheckOutPage enterFirstName(String firstname){
      WebElement e=  wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
      e.clear();
      e.sendKeys(firstname);
      return this;
    }
    public CheckOutPage enterLastName(String lastname){
       WebElement e= wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
       e.clear();
       e.sendKeys(lastname);
       return this;
    }
    public CheckOutPage enterBillingAddress(String address){
        WebElement e=  wait.until(ExpectedConditions.visibilityOf(billingAddressFld));
        e.sendKeys(address);
        return this;
    }
    public CheckOutPage enterCity(String city){
        WebElement e=   wait.until(ExpectedConditions.visibilityOf(billingCity));
        e.sendKeys(city);
        return this;
    }
    public CheckOutPage selectBillingState(String state){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingState)));
        select.selectByVisibleText(state);
        return this;
    }
    public CheckOutPage enterZip(String zip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZip));
        e.clear();
        e.sendKeys(zip);
        return this;
    }
    public CheckOutPage enterEmail(String email){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmail));
        e.clear();
        e.sendKeys(email);
        return this;
    }
    public CheckOutPage setBillingDetails(BillingDetails billingDetails){
        return enterFirstName(billingDetails.getFirstname())
                .enterLastName(billingDetails.getLastname())
                .enterBillingAddress(billingDetails.getAddress_line1())
                .enterCity(billingDetails.getCity())
                .selectBillingState(billingDetails.getState())
                .enterZip(billingDetails.getZip())
                .enterEmail(billingDetails.getEmail());
    }
    public CheckOutPage clickPlaceOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }
    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeMsg)).getText();
    }
}
