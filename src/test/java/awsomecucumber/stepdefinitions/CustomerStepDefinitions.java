package awsomecucumber.stepdefinitions;

import awsomecucumber.constants.EndPoint;
import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.BillingDetails;
import awsomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {
    private final WebDriver driver;
    private final TestContext context;

    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
        driver= context.driver;
    }
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        new StorePage(driver).load(EndPoint.STORE.url);
    }
    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }
}
