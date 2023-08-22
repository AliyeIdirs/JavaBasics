package regressionsuit.junitframework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AddPromotionalCodeTestRunner extends TestLibrary{
    static TestUser user;
    PromotionalCodeInfo promotionalCodeInfo;
    @BeforeAll
    public static void setUp(){
        user=new TestUser("testautomation1","automation123!");
        openCubeCart();
        login(user.getUserName(), user.getPassword());
    }
    @Test
    public void addPromotionalCodeTest(){
        promotionalCodeInfo=new PromotionalCodeInfo("A"+System.currentTimeMillis(),
                "Description"+System.currentTimeMillis(),50,"2023-08-22",
                "2024-07-23","All",1000,
                new ArrayList<>(Arrays.asList("Crayola","Mediocre Granite Pants","HP")));
        Assertions.assertTrue(addPromotionalCode(promotionalCodeInfo));

    }
    @AfterAll
    public static void tearDown(){
        logOut();
        closeBrowser();
        TestResultUtility.writeTestReport("doc/AddPromotionalCodeTestReport.txt",testResult.toString());
    }
}
