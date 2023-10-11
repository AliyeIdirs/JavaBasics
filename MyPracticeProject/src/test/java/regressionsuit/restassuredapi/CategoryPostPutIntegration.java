package regressionsuit.restassuredapi;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;
public class CategoryPostPutIntegration {
    DataBase db;
    String responseBody;
    int catId;
    CategoryPayload categoryPayload;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        RestAssured.baseURI=db.api_host;
        RestAssured.port=db.api_port;
        RestAssured.authentication=RestAssured.basic(db.api_username,db.api_password);
    }
    @Test
    public void addCategoryApiTest(){
        categoryPayload=new CategoryPayload(db.categoryName);
        Response response= given().contentType(ContentType.JSON).and().body(categoryPayload)
                .when().post("/category").then().assertThat().body("catName",equalTo(db.categoryName))
                .and().assertThat().statusCode(200).extract().response();
        responseBody=response.asPrettyString();
        response.prettyPrint();
        catId=response.jsonPath().getInt("id");
    }
    @Test
    public void updateCategoryApiTest(){
        String newCateName= Faker.instance().commerce().department();
        System.out.println("New categoryName: "+newCateName);
        categoryPayload.setCatName(newCateName);

        /*given().contentType(ContentType.JSON).and()
                .body(PayloadUtility.updatePayload(responseBody,"catName",newCateName))
                .when().put("/category/"+catId).then().assertThat().statusCode(204);*/
        given().contentType(ContentType.JSON).and()
                .body(categoryPayload)
                .when().put("/category/"+catId).then().assertThat().statusCode(204);

        Response getResponse=given().when().get("/category/"+catId);

        Assert.assertEquals(getResponse.jsonPath().getString("catName"),newCateName);
        System.out.println("After Update: ");
        getResponse.prettyPrint();
    }
}
