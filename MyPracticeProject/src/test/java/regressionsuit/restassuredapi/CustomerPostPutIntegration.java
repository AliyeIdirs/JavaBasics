package regressionsuit.restassuredapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

import static io.restassured.RestAssured.given;

public class CustomerPostPutIntegration {
    DataBase db;
    String path;
    String responseBody;
    int customerId;
    @BeforeClass
    public void setUp(){
        db =new DataBase();
        path= db.api_host+":"+ db.api_port+"/";
    }
    @Test
    public void addCustomerApiTest(){
        CustomerPayload  customerPayload=new CustomerPayload(db.email,db.customerTitle(),db.firstName,db.lastName,0,db.phone,1,"en-GB",db.ipAddress,
                1);
        Response response= given().headers("Content-Type","application/json")
                .and().body(PayloadUtility.getCustomerPayload(customerPayload)).auth().basic(db.api_username,db.api_password)
                .when().post(path+"customer").then().extract().response();

        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("email"),customerPayload.getEmail());
        responseBody=response.getBody().asPrettyString();
        customerId=response.jsonPath().getInt("id");
    }
    @Test(description = "update according to response body")
    public void updateCustomerApiTest(){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode customer;
        try {
            customer = mapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String newName= Faker.instance().name().firstName();
        JsonToken editToken=( (ObjectNode) customer).put("firstName",newName).asToken();
        System.out.println("Value to be updated: "+newName);

        Response putResponse= given().headers("Content-Type","application/json")
                .and().body(customer).auth().basic(db.api_username,db.api_password)
                .when().put(path+"customer/"+customerId).then()
                .extract().response();
        Assert.assertEquals(putResponse.getStatusCode(),204);
        System.out.println("After Update:");
        Assert.assertTrue(given().when().get(path + "customer/" + customerId).prettyPrint().contains(newName));
    }
}
