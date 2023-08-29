package regressionsuit.week16junitproject;

import com.unitedcoder.configutility.ApplicationConfig;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRunner extends TestLibrary{
    FunctionLibrary functionLibrary =new FunctionLibrary();
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
            productObject = new ProductObject(functionLibrary.productName, functionLibrary.manufacturer(), functionLibrary.condition(),
                    functionLibrary.productCode, functionLibrary.productWeight, functionLibrary.dimensionUnit(),
                    functionLibrary.productWidth, functionLibrary.productHeight, functionLibrary.productDepth,
                    functionLibrary.liveDate(), functionLibrary.stockLevel, functionLibrary.stockLevelWarning,
                    functionLibrary.upcCode, functionLibrary.eanCode, functionLibrary.janCode, functionLibrary.isbnCode,
                    functionLibrary.gtinCode, functionLibrary.mpnCode, functionLibrary.googleCategory());
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
