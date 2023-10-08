package regressionsuit.restassuredapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

public class CCApiAutomation {
    DataBase db;
    String path;
    @BeforeClass
    public void setUp(){
        db =new DataBase();
        path= db.api_host+":"+ db.api_port+"/";
    }
    @Test(description = "Authorized user should be able to get all customers")
    public void getAllCustomersTest(){
        //send request-get response
        Response response= RestAssured.given().auth().basic(db.api_username, db.api_password)
                .when().get(path+"customers");
        response.getBody().prettyPrint();
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
    @Test(description = "Authorized user should be able to get all categories")
    public void getAllCategoriesTest(){
        RestAssured.given().auth().basic(db.api_username, db.api_password)
                .when().get(path+"categories").then().assertThat().statusCode(200);
    }
    @Test(description = "Authorized user should be able to get all products")
    public void getAllProducts(){
        Response response=RestAssured.given().auth().basic(db.api_username, db.api_password)
                .when().get(path+"products");
        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
