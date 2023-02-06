package awsomecucumber.stepdefinitions;

import awsomecucumber.constants.Constants;
import awsomecucumber.constants.EndPoint;
import awsomecucumber.context.TestContext;
import awsomecucumber.domainobjects.BillingDetails;
import awsomecucumber.domainobjects.Product;
import awsomecucumber.pages.CartPage;
import awsomecucumber.pages.CheckOutPage;
import awsomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyStepdefs {
    private final WebDriver driver;
    private BillingDetails billingDetails;

    public MyStepdefs(TestContext context){
       driver= context.driver;
    }




}
