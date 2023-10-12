package regressionsuit.httpclientapi;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.restassuredapi.CustomerPayload;
import regressionsuit.testngproject.DataBase;

public class CustomerModuleTest {
    DataBase db=new DataBase();
    RequestHandler requestHandler;
    CustomerPayload customerPayload;
    int customerId;
    ResponseHandler responseHandler;
    JSONObject jsonObject;
    @BeforeClass
    public void setUp(){
        db=new DataBase();
        requestHandler=new RequestHandler();
    }
    @Test
    public void getAllCustomers(){
        responseHandler=requestHandler.getRequest("customers");
        System.out.println(responseHandler.getResponseContent());
        Assert.assertTrue(responseHandler.getResponseCode()==200);
    }
    @Test
    public void postCustomerTest(){
        customerPayload=new CustomerPayload(db.email,db.customerTitle(),db.firstName,db.lastName,0,db.phone,
                1,"en-GB",db.ipAddress,0);
        jsonObject=new JSONObject(customerPayload);
        responseHandler=requestHandler.postRequest("customer",jsonObject.toString());
        System.out.println(responseHandler.getResponseContent());
        Assert.assertEquals(responseHandler.getResponseCode(),200);
        Assert.assertEquals(responseHandler.getJsonPath().getString("firstName"),db.firstName);
        customerId=responseHandler.getJsonPath().getInt("id");
    }
    @Test(dependsOnMethods = "postCustomerTest")
    public void updateCustomer(){
        String newName= Faker.instance().name().firstName();
        jsonObject.put("firstName",newName);
        responseHandler=requestHandler.putRequest("customer/"+customerId,jsonObject.toString());
        Assert.assertEquals(responseHandler.getResponseCode(),204);
        responseHandler=requestHandler.getRequest("customer/"+customerId);
        System.out.println(responseHandler.getResponseContent());
        Assert.assertTrue(responseHandler.getResponseContent().contains(newName));
        Assert.assertEquals(responseHandler.getJsonPath().getString("firstName"),newName);
    }
}
