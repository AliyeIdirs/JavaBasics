package regressionsuit.restassuredapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

import java.util.List;
import java.util.Random;

public class UpdateExistingCustomer {
    DataBase db;
    List<Integer> customerIds;
    int randomId;
    String responseBody;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        RestAssured.baseURI=db.api_host;
        RestAssured.port=db.api_port;
        RestAssured.authentication=RestAssured.basic(db.api_username,db.api_password);
    }
    @Test(description = "get all customer's id into a list")
    public void getAllCustomerIds() {
        String responseBody = given().when().get("/customers")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        customerIds = jsonPath.getList("id");
    }
    @Test(description = "randomly pick up a customer id from the list and print")
    public void getRandomCustomer() {
        Random random = new Random();
        randomId = customerIds.get(random.nextInt(customerIds.size()));
        System.out.println("Before Update:");
        responseBody = given().when().get( "/customer/" + randomId)
                .then().assertThat().statusCode(200).extract().response().prettyPrint();
    }
    @Test(description = "update selected customer's info and print")
    public void updateCustomerInfo(){
        System.out.println("Value to be updated: "+db.email);
        given().contentType(ContentType.JSON)
                .and().body(PayloadUtility.updatePayload(responseBody,"email",db.email))
                .when().put("/customer/"+randomId).then().assertThat().statusCode(204);

        System.out.println("After Update:");
        given().when().get("/customer/" + randomId).prettyPrint();
    }
}
