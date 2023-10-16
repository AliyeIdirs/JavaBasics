package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author : user
 * @created : 16.10.2023,14:30
 * @Email :aliyeidiris@gmail.com
 **/
public class ApiStepdefs {
    @Given("a valid username and password")
    public void aValidUsernameAndPassword() {
    }

    @When("the user sends a get request to the customer end point")
    public void theUserSendsAGetRequestToTheCustomerEndPoint() {
    }

    @Then("the api should return {int} response code")
    public void theApiShouldReturnResponseCode(int arg0) {
    }

    @And("the api should return more than one customer")
    public void theApiShouldReturnMoreThanOneCustomer() {
    }

    @When("the user sends a get request to the product end point")
    public void theUserSendsAGetRequestToTheProductEndPoint() {
    }

    @And("the api should return more than one product")
    public void theApiShouldReturnMoreThanOneProduct() {
    }

    @Given("{string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void andAndAndAndAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
    }

    @When("the user sends the post request to the customer endpoint with the payload")
    public void theUserSendsThePostRequestToTheCustomerEndpointWithThePayload() {
    }

    @Then("the api should return {int} response code and create a new customer")
    public void theApiShouldReturnResponseCodeAndCreateANewCustomer(int arg0) {
    }
}
