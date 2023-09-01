package regressionsuit.testngframework;

import org.junit.Assert;
import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeClass
    public void setUp(){
        System.out.println("Before class...");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method...");
    }
    @Test(description = "this test is add customer test",groups = "regression test")
    public void addCustomerTest(){
        System.out.println("This is for add customer...");
        Assert.assertTrue("Add Customer".contains("Customer"));
    }
    @Test(groups = "regression test",dependsOnGroups = "smoke test")
    public void deleteCustomer(){
        System.out.println("Delete customer test");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(groups = "smoke test",dependsOnMethods = "addCustomerTest")
    public void verifyCustomerList(){
        System.out.println("List of customers appeared...");
        Assert.assertEquals(10,10);
    }
    @Test(enabled = false)
    public void customerList(){
        System.out.println("Customer List");
        Assert.assertEquals(5,5);
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method...");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class...");
    }
}
