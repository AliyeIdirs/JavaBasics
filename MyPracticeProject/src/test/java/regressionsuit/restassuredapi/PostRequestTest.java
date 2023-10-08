package regressionsuit.restassuredapi;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

public class PostRequestTest {
    DataBase db;
    String path;
    @BeforeClass
    public void setUp(){
        db =new DataBase();
        path= db.api_host+":"+ db.api_port+"/";
    }
    @Test(description = "Authorized user should be able to add customer")
    public void addCustomerTest(){
        CustomerPayload customerPayload=new CustomerPayload(db.email,db.customerTitle(),db.firstName,db.lastName,0,db.phone,1,"en-GB",db.ipAddress,
                1);
        Response response= RestAssured.given().headers("Content-Type","application/json")
                .and().body(PayloadUtility.getCustomerPayload(customerPayload)).auth().basic(db.api_username,db.api_password)
                        .when().post(path+"customer").then().extract().response();
        //Assert the response code and response body
        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("email"),customerPayload.getEmail());
    }
    @Test
    public void addCategoryTest(){
        CategoryPayload categoryPayload=new CategoryPayload(db.categoryName,db.description,1,0,0.00,
                0.00,0.00,0.00,0,db.metaTitle,db.metaDescription,db.keyword,1,1,0);
        Response response=RestAssured.given().headers("Content-Type","application/json")
                .and().body(PayloadUtility.getCategoryPayload(categoryPayload)).auth().basic(db.api_username,db.api_password)
                .when().post(path+"category").then().extract().response();
        response.getBody().prettyPrint();
        Assert.assertEquals(response.jsonPath().getString("catName"),categoryPayload.getCatName());
    }

}
