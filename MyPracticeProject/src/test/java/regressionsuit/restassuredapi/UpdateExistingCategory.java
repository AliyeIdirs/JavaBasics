package regressionsuit.restassuredapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

import java.util.List;
import java.util.Random;

public class UpdateExistingCategory {
    DataBase db;
    String path;
    RequestSpecification specification;
    List<Integer> catIds;
    int randomCatId;
    String responseBody;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        path=db.api_host+":"+db.api_port+"/";
        specification= RestAssured.given().auth().basic(db.api_username,db.api_password).when();
    }
    @Test
    public void getAllCategoriesName(){
        String responseBody=specification.get(path+"categories").then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jsonPath=new JsonPath(responseBody);
        catIds=jsonPath.getList("id");
    }
    @Test
    public void getRandomCategory(){
        Random random=new Random();
        randomCatId=catIds.get(random.nextInt(catIds.size()));
        Response response=specification.get(path+"category/"+randomCatId);
        Assert.assertEquals(response.getStatusCode(),200);
        response.getBody().prettyPrint();
        responseBody=response.getBody().asPrettyString();
    }
    @Test
    public void updateCategoryInfo(){
        ObjectMapper mapper=new ObjectMapper();
        JsonNode category;
        try {
            category = mapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String newCateName=db.categoryName;
        JsonToken updateToken=((ObjectNode)category).put("catName",newCateName).asToken();
        System.out.println("Value to be updated: "+newCateName);

        Response putResponse=RestAssured.given().headers("Content-Type","application/json")
                .and().body(category).auth().basic(db.api_username,db.api_password)
                .when().put(path+"category/"+randomCatId).then().extract().response();
        Assert.assertEquals(putResponse.getStatusCode(),204);
        Response getResponse= specification.get(path+"category/"+randomCatId);
        Assert.assertEquals(getResponse.jsonPath().getString("catName"),newCateName);
        System.out.println("After Update: ");
       getResponse.prettyPrint();
    }
}
