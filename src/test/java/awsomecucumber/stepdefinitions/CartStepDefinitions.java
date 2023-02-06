package awsomecucumber.stepdefinitions;

import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.Product;
import awsomecucumber.pages.CartPage;
import awsomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }
    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
      cartPage.checkout();
    }
    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
