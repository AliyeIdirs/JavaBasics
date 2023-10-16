package regressionsuit.restassuredapi;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

import static io.restassured.RestAssured.given;

public class CustomerPostPutIntegration {
    DataBase db;
    String responseBody;
    int customerId;
    CustomerPayload  customerPayload;
    @BeforeClass
    public void setUp(){
        db =new DataBase();
        RestAssured.baseURI=db.api_host;
        RestAssured.port=db.api_port;
        RestAssured.authentication=RestAssured.basic(db.api_username,db.api_password);
    }
    @Test
    public void addCustomerApiTest(){
        customerPayload=new CustomerPayload(db.email,db.customerTitle(),db.firstName,db.lastName,0,db.phone,1,"en-GB",db.ipAddress,
                1);
        Response response= given().contentType(ContentType.JSON).and().body(customerPayload)
                .when().post("/customer").then().assertThat().statusCode(200).extract().response();
        customerId=response.jsonPath().getInt("id");
        response.getBody().prettyPrint();
        responseBody=response.getBody().asPrettyString();

        Assert.assertEquals(response.jsonPath().getString("email"),customerPayload.getEmail());


    }
    @Test(description = "update according to response body",dependsOnMethods = "addCustomerApiTest")
    public void updateCustomerApiTest(){

        String newName= Faker.instance().name().firstName();
        System.out.println("Value to be updated: "+newName);
        customerPayload.setFirstName(newName);

        given().contentType(ContentType.JSON).and().body(customerPayload).when()
                .put("/customer/"+customerId).then().assertThat().statusCode(204);

        /*given().contentType(ContentType.JSON)
                .and().body(PayloadUtility.updatePayload(responseBody,"firstName",newName))
                .when().put("/customer/"+customerId).then().assertThat().statusCode(204);*/

        System.out.println("After Update:");
        Assert.assertTrue(given().when().get("/customer/" + customerId).prettyPrint().contains(newName));
    }
}
