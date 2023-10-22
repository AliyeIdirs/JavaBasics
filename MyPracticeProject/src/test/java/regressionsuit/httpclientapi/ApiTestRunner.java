package regressionsuit.httpclientapi;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.TestData;

public class ApiTestRunner {
    TestData db;
    RequestHandler requestHandler;
    ResponseHandler responseHandler;
    @BeforeClass
    public void setUp(){
        db=new TestData();
        requestHandler=new RequestHandler();
    }
    @Test
    public void getAllCustomers(){
        responseHandler= requestHandler.getAllInfo(db.api_username,db.api_password,db.api_host,db.api_port,"customers");
        Assert.assertTrue(responseHandler.getResponseCode()==200);
    }
    @Test
    public void getAllCategories(){
        responseHandler= requestHandler.getAllInfo(db.api_username,db.api_password,db.api_host,db.api_port,"categories");
        Assert.assertTrue(responseHandler.getResponseCode()==200);
    }
    @Test
    public void getAllProducts(){
        responseHandler= requestHandler.getAllInfo(db.api_username,db.api_password,db.api_host,db.api_port,"products");
        System.out.println(responseHandler.getResponseContent());
        Assert.assertTrue(responseHandler.getResponseCode()==200);
    }
}
