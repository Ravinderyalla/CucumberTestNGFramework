package awsomecucumber.stepdefinitions;

import awsomecucumber.context.TestContext;
import awsomecucumber.pages.CheckOutPage;
import awsomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckOutStepDefinitions {

    private final CheckOutPage checkOutPage;
    private TestContext context;

    public CheckOutStepDefinitions(TestContext context) {
        checkOutPage = PageFactoryManager.getCheckOutPage(context.driver);
         this.context =context;
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {

        checkOutPage.setBillingDetails(context.billingDetails);
    }

    @And("i place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        checkOutPage.clickPlaceOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
        Assert.assertEquals("Thank you. Your order has been received.", checkOutPage.getNotice());
    }

}
