package awsomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(css = "td[class='product-name'] a")
    private WebElement productNameFld;
    @FindBy(css = "input[type=\"number\"]")
    private WebElement productQtyFld;
    @FindBy(css = ".checkout-button")
    private WebElement proceedToCheckOutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQtyFld))
                .getAttribute("value"));
    }
    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutBtn)).click();
    }
}
