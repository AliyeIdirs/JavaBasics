package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import regressionsuit.cucumberframework.ApiResponseHolder;
import regressionsuit.restassuredapi.CustomerPayload;
import regressionsuit.testngproject.TestData;

/**
 * @author : user
 * @created : 16.10.2023,14:30
 * @Email :aliyeidiris@gmail.com
 **/
public class ApiStepdefs {
    Scenario scenario;
    TestData td = new TestData();
    Response response;
    CustomerPayload customerPayload;

    @Before
    public void beforeStepInCucumber(Scenario scenario) {
        this.scenario = scenario;
        RestAssured.baseURI = td.api_host;
        RestAssured.port = td.api_port;
        RestAssured.authentication = RestAssured.basic(td.api_username, td.api_password);

    }

    @Given("a valid username and password")
    public void aValidUsernameAndPassword() {
        scenario.log("Api username: " + td.api_username);
        scenario.log("Api password: " + td.api_password);
    }

    @When("the user sends a get request to the customer end point")
    public void theUserSendsAGetRequestToTheCustomerEndPoint() {
        response = RestAssured.given().when().get("/customers").then().extract().response();
        response.prettyPrint();
        ApiResponseHolder.setGetResponseCode(response.getStatusCode());
        ApiResponseHolder.setTotalResponseSize(response.jsonPath().getList("id").size());
    }

    @Then("the api should return {int} response code")
    public void theApiShouldReturnResponseCode(int arg0) {
        arg0 = 200;
        Assert.assertEquals(ApiResponseHolder.getGetResponseCode(), arg0);
    }

    @And("the api should return more than one customer")
    public void theApiShouldReturnMoreThanOneCustomer() {
        Assert.assertTrue(ApiResponseHolder.getTotalResponseSize() > 1);
    }

    @When("the user sends a get request to the product end point")
    public void theUserSendsAGetRequestToTheProductEndPoint() {
        response = RestAssured.given().when().get("/products").then().extract().response();
        response.prettyPrint();
        ApiResponseHolder.setTotalResponseSize(response.jsonPath().getList("id").size());
    }

    @And("the api should return more than one product")
    public void theApiShouldReturnMoreThanOneProduct() {
        Assert.assertTrue(ApiResponseHolder.getTotalResponseSize() > 1);
    }

    @Given("customerPayload {string} {string} {string} {string} {int} {string}  {int}  {string} {string} {int}")
    public void customerpayload(String arg0, String arg1, String arg2, String arg3, int arg4, String arg5,
                                int arg6, String arg7, String arg8, int arg9) {
        customerPayload = new CustomerPayload(arg0, arg1, arg2, arg3,
                arg4, arg5, arg6, arg7, arg8,arg9);
    }

    @When("the user sends the post request to the customer endpoint with the payload")
    public void theUserSendsThePostRequestToTheCustomerEndpointWithThePayload() {
        response=RestAssured.given().when().contentType(ContentType.JSON).and().body(customerPayload).post("/customer").then()
                .extract().response();
        ApiResponseHolder.setPostResponseCode(response.getStatusCode());
        scenario.log("Customer Id: "+response.jsonPath().getInt("id"));
        ApiResponseHolder.setCustomerId(response.jsonPath().getInt("id"));
        response.prettyPrint();
    }

    @Then("the api should return {int} response code and create a new customer")
    public void theApiShouldReturnResponseCodeAndCreateANewCustomer(int arg0) {
        arg0=200;
        Assert.assertEquals(ApiResponseHolder.getPostResponseCode(),arg0);
        Assert.assertTrue(ApiResponseHolder.getCustomerId()>1);

    }


}
