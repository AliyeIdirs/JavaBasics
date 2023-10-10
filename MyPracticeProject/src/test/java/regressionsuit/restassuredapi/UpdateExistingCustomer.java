package regressionsuit.restassuredapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

import java.util.List;
import java.util.Random;

public class UpdateExistingCustomer {
    DataBase db;
    String path;
    List<Integer> customerIds;
    int randomId;
    RequestSpecification specification;
    String responseBody;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        path=db.api_host+":"+ db.api_port+"/";
        specification=given().auth().basic(db.api_username,db.api_password);
    }
    @Test(description = "get all customer's id into a list")
    public void getAllCustomerIds() {
        String responseBody = specification.when().get(path + "customers")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        customerIds = jsonPath.getList("id");
    }
    @Test(description = "randomly pick up a customer id from the list and print")
    public void getRandomCustomer() {
        Random random = new Random();
        randomId = customerIds.get(random.nextInt(customerIds.size()));
        Response response = specification.when().get(path + "customer/" + randomId);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Before Update:");
        response.getBody().prettyPrint();
        responseBody=response.getBody().asPrettyString();
    }
    @Test(description = "update selected customer's info and print")
    public void updateCustomerInfo(){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode customer= null;
        try {
            customer = mapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonToken editToken=( (ObjectNode) customer).put("email",db.email).asToken();
        System.out.println("Value to be updated: "+db.email);

       Response putResponse= RestAssured.given().headers("Content-Type","application/json")
                .and().body(customer).auth().basic(db.api_username,db.api_password)
                .when().put(path+"customer/"+randomId).then()
                .extract().response();
       Assert.assertEquals(putResponse.getStatusCode(),204);
        System.out.println("After Update:");specification.when().get(path + "customer/" + randomId).prettyPrint();
    }
}
