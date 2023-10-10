package regressionsuit.httpclientapi;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

public class ApiTestRunner {
    DataBase db;
    ApiRequestHandler requestHandler;
    ApiResponseHandler responseHandler;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        requestHandler=new ApiRequestHandler();
        responseHandler= requestHandler.getAllCustomer(db.api_username,db.api_password,db.api_host,db.api_port,"customers");
    }
    @Test
    public void getAllCustomers(){
        Assert.assertTrue(responseHandler.getResponseCode()==200);
    }
}
