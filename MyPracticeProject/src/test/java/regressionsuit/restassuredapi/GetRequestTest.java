package regressionsuit.restassuredapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

public class GetRequestTest {
    DataBase db;
    String path;
    RequestSpecification specification;
    @BeforeClass
    public void setUp(){
        db =new DataBase();
        path= db.api_host+":"+ db.api_port+"/";
        specification=RestAssured.given().auth().basic(db.api_username, db.api_password);

    }
    @Test(description = "Authorized user should be able to get all customers")
    public void getAllCustomers(){
        //send request-get response
        Response response=  specification.when().get(path+"customers");
        response.getBody().prettyPrint();
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
    @Test(description = "Authorized user should be able to get all categories")
    public void getAllCategories(){
        specification.when().get(path+"categories").then().assertThat().statusCode(200);
    }
    @Test(description = "Authorized user should be able to get all products")
    public void getAllProducts(){
        Response response=specification.when().get(path+"products");
        response.getBody().prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(description = "user should be able to get product by id")
    public void getProductById(){
        int id=6205;
        Response response=specification.pathParam("id",id).
                when().get(path+"product/{id}");
        response.getBody().prettyPrint();
        String productName=response.jsonPath().getString("name");
        assert productName.equals("Sleek Plastic Table"):"Expected product name is 'Sleek Plastic Table' but got "+productName;
    }
    @Test(description = "user should be able to get customer by id")
    public void getCustomerById(){
        int customerId=7520;
        String response =specification.pathParam("id",customerId)
                .when().get(path+"customer/{id}").then().log().all().assertThat().header("Transfer-Encoding","chunked")
                .body("id",equalTo(customerId)).extract().asString();
        Assert.assertTrue(response.contains("Adam"));
    }
    @Test
    public void getCategoryById(){
        int categoryId=23;
        System.out.println(specification.pathParam("id",categoryId).when().get(path+"category/{id}")
                .then().assertThat().extract().response().asString());
    }
}
