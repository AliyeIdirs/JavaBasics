package regressionsuit.restassuredapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;
public class CategoryPostPutIntegration {
    DataBase db;
    String path;
    String responseBody;
    int catId;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        path=db.api_host+":"+db.api_port+"/";
    }
    @Test
    public void addCategoryApiTest(){
        CategoryPayload categoryPayload=new CategoryPayload(db.categoryName);
        Response postResponse= RestAssured.given().headers("Content-Type","application/json")
                .and().body(PayloadUtility.getCategoryPayload(categoryPayload))
                .when().auth().basic(db.api_username, db.api_password)
                .post(path+"category").then().extract().response();
        postResponse.prettyPrint();
        responseBody=postResponse.getBody().asPrettyString();
        catId=postResponse.jsonPath().getInt("id");
    }
    @Test
    public void updateCategoryApiTest(){
        String newCateName= Faker.instance().commerce().department();
        System.out.println("New categoryName: "+newCateName);
        ObjectMapper mapper=new ObjectMapper();
        JsonNode category= null;
        try {
            category = mapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonToken updateToken= ((ObjectNode)category).put("catName",newCateName).asToken();
        Response putResponse=RestAssured.given().headers("Content-Type","application/json")
                .and().body(category).auth().basic(db.api_username,db.api_password).when().put(path+"category/"+catId).then().extract().response();
        Assert.assertEquals(putResponse.getStatusCode(),204);
        Response getResponse=given().auth().basic(db.api_username,db.api_password)
                .when().get(path+"category/"+catId);
        Assert.assertEquals(getResponse.jsonPath().getString("catName"),newCateName);
        System.out.println("After Update: ");
        getResponse.prettyPrint();
    }
}
