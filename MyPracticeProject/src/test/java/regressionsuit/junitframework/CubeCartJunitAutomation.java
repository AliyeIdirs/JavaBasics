package regressionsuit.junitframework;

import com.unitedcoder.jsonfile.deserilization.cubecartautomation.Customer;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.FunctionLibrary;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.LoginUser;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CubeCartJunitAutomation extends FunctionLibrary {
    static LoginUser loginUser;
    Customer customer;
    Product product;
    @BeforeAll
    public static void setUp(){
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginUser=new LoginUser("testautomation1","automation123!");
        login(loginUser);
    }
    @Test
    public void AddCustomerTest(){
        customer=new Customer("Ahmed"+getCurrentTime(),"Aziz"+getCurrentTime(),
                "aaziz"+System.currentTimeMillis()+"@hotmail.com");
        boolean isCustomerAdded= addCustomer(customer);
        Assertions.assertTrue(isCustomerAdded);
    }
    @Test
    public void AddProductTest(){
        product=new Product("Ipad","Ipad242","manufacturer1","Electronics");
        boolean isProductAdded=addProduct(product);
        Assertions.assertTrue(isProductAdded);
    }
    @AfterAll
    public static void TearDown(){
        logOut();
        tearDown();
    }

}
