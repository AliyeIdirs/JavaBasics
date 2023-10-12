package regressionsuit.httpclientapi;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.restassuredapi.CategoryPayload;
import regressionsuit.testngproject.DataBase;

import javax.json.JsonObject;
import java.util.List;
import java.util.Random;

public class CategoryModuleTestRunner {
    DataBase db=new DataBase();
    RequestHandler requestHandler;
    CategoryPayload categoryPayload;
    int categoryId;
    ResponseHandler responseHandler;
    JSONObject jsonObject;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        requestHandler=new RequestHandler();
    }
    @Test
    public void getAllCategories(){
        responseHandler=requestHandler.getRequest("categories");
        System.out.println(responseHandler.getResponseContent());
        Assert.assertEquals(responseHandler.getResponseCode(),200);
    }
    @Test
    public void postCategory(){
        categoryPayload=new CategoryPayload(db.categoryName,db.description);
        jsonObject=new JSONObject(categoryPayload);
        responseHandler=requestHandler.postRequest("category",jsonObject.toString());
        System.out.println(responseHandler.getResponseContent());
        Assert.assertEquals(responseHandler.getResponseCode(),200);
        categoryId=responseHandler.getJsonPath().getInt("id");
    }
    @Test(dependsOnMethods = "postCategory")
    public void updatePostedCategory(){
        jsonObject.put("catName","Meyve");
        responseHandler= requestHandler.putRequest("category/"+categoryId,jsonObject.toString());
        Assert.assertEquals(responseHandler.getResponseCode(),204);
        responseHandler= requestHandler.getRequest("category/"+categoryId);
        System.out.println("After Update\n"+responseHandler.getResponseContent());
    }
    @Test
    public void updateExistingCategory(){
        //get all categories ids into a list
        responseHandler=requestHandler.getRequest("categories");
        List<Integer> catIds=responseHandler.getJsonPath().getList("id");
        //pick up a random id from the list
        int randomId=catIds.get(new Random().nextInt(catIds.size()));
        //pick up a random category corresponds to the random id
        responseHandler= requestHandler.getRequest("category/"+randomId);
        System.out.println(responseHandler.getResponseContent());
        //update the random category's name
        jsonObject=new JSONObject(responseHandler.getResponseContent()).put("catName","Sebze");
        responseHandler=requestHandler.putRequest("category/"+randomId, jsonObject.toString());
        Assert.assertEquals(responseHandler.getResponseCode(),204);
        //verify the category name has been updated
        responseHandler= requestHandler.getRequest("category/"+randomId);
        System.out.println("After Update\n"+responseHandler.getResponseContent());
        Assert.assertEquals(responseHandler.getJsonPath().getString("catName"),"Sebze");
    }
    @Test
    public void getCategoryById(){
        responseHandler=requestHandler.getRequest("categories");
        List<Integer> catIds=responseHandler.getJsonPath().getList("id");
        int randomId=catIds.get(new Random().nextInt(catIds.size()));
        responseHandler= requestHandler.getRequest("category/"+randomId);
        jsonObject=new JSONObject(responseHandler.getResponseContent());
        System.out.println(responseHandler.getResponseContent());
    }

}
