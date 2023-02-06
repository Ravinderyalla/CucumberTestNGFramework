package awsomecucumber.stepdefinitions;

import awsomecucumber.constants.Constants;
import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.Product;
import awsomecucumber.pages.PageFactoryManager;
import awsomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;

    public StoreStepDefinitions(TestContext context) {
        storePage= PageFactoryManager.getStorePage(context.driver);
    }
    @Given("I'm on the store page")
    public void iMOnTheStorePage() {
       storePage.load(Constants.STORE);
    }
    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
      storePage.addToCart(product.getName());
    }
    @When("I have a product in the cart")
    public void iHaveAProductInTheCart() {
      storePage.addToCart("Blue Shoes");
    }
}
