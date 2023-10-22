package regressionsuit.cucumberframework.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import regressionsuit.restassuredapi.CategoryPayload;
import regressionsuit.restassuredapi.PayloadUtility;
import regressionsuit.testngproject.TestData;

import static io.restassured.RestAssured.given;

/**
 * @author : user
 * @created : 22.10.2023,18:07
 * @Email :aliyeidiris@gmail.com
 **/
public class CategoryApiSteps {
    String apiHost; int apiPort; String apiUsername; String apiPassword;
    Response response;
    CategoryPayload payload;
    String newCatName;
    @Given("admin user has the authentication information to connect to the Api")
    public void adminUserHasTheAuthenticationInformationToConnectToTheApi() {
        apiHost= TestData.api_host;
        apiPort=TestData.api_port;
        apiUsername=TestData.api_username;
        apiPassword=TestData.api_password;
    }

    @Given("admin user connected to the Api")
    public void adminUserConnectedToTheApi() {
        RestAssured.baseURI=apiHost;
        RestAssured.port=apiPort;
        RestAssured.authentication=RestAssured.basic(apiUsername,apiPassword);
    }

    @When("admin user fills out the {string} and {string}")
    public void adminUserFillsOutTheAnd(String catName, String catDescription) {
        payload=new CategoryPayload(catName,catDescription);
    }

    @And("admin user sends a post request to create a new category via the Api")
    public void adminUserSendsAPostRequestToCreateANewCategoryViaTheApi() {
        response=given().contentType(ContentType.JSON).and().body(payload).when().post("/category")
                .then().extract().response();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code) {
        Assert.assertEquals(response.getStatusCode(),code);
    }

    @And("a new category should be created successfully")
    public void aNewCategoryShouldBeCreatedSuccessfully() {
        System.out.println("New category is created.");
        response.prettyPrint();
    }

    @And("admin user has a category id <{int}> to be updated")
    public void adminUserHasACategoryIdToBeUpdated(int catId) {
        newCatName= Faker.instance().commerce().department();
        response=given().when().get("/category/"+catId).then().extract().response();
        System.out.println("Before update: ");
        response.prettyPrint();
    }
    @When("admin user sends a put request to update the category with id <{int}>")
    public void adminUserSendsAPutRequestToUpdateTheCategoryWithId(int catId) {
        response=given().when().contentType(ContentType.JSON).and().
                body(PayloadUtility.updatePayload(response.asPrettyString(),"catName",newCatName))
                .put("/category/"+catId).then().extract().response();
    }
    @And("user verify the category <{int}> updated successfully")
    public void userVerifyTheCategoryUpdatedSuccessfully(int catId) {
        response=given().when().get("/category/"+catId).then().extract().response();
        System.out.println("After update: ");
        response.prettyPrint();
    }
}
