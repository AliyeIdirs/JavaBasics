package regressionsuit.week16junitproject;

import com.unitedcoder.configutility.ApplicationConfig;
import org.junit.jupiter.api.*;
import regressionsuit.testngproject.DataBase;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRunner extends TestLibrary{
    DataBase testData=new DataBase();
    ProductObject productObject;
    static String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    static String password=ApplicationConfig.readConfigProperties("config.properties","password");

    @BeforeAll
    public static void setUp(){
        openBrowser();
        login(userName,password);
    }
    @RepeatedTest(3)
    @Order(1)
    public void multipleProductAddTest(){
            productObject = new ProductObject(testData.productName, testData.manufacturer(), "New", testData.productCode,
                    String.valueOf(testData.productWeight),"Centimeters (cm)",String.valueOf(testData.productWidth),
                    String.valueOf(testData.productHeight),String.valueOf(testData.productDepth), testData.liveDate(),
                    testData.stockLevel, testData.stockLevelWarning, testData.upcCode, testData.eanCode, testData.janCode,
                    testData.isbnCode, testData.gtinCode, testData.mpnCode, testData.googleCategory());
            addProduct(productObject);
            Assertions.assertTrue(verifyProductAddedSuccessfully());
            System.out.println(productObject.getProductCode());
    }
    @RepeatedTest(3)
    @Order(2)
    public void deleteMultipleProducts(){
        deleteProduct();
        Assertions.assertTrue(verifyProductDeleteSuccessfully());
    }
    @AfterAll
    public static void tearDown(){
        logOut();
        closeBrowser();
    }
}
