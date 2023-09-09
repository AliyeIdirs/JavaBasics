package regressionsuit.testngproject;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.ProductPage;

public class ProjectRunnerClass extends TestBaseForTestNG{
    String userName=ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    TestData testData;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProductPage productPage;

    @BeforeClass
    public void setUp(){
        openBrowser();
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        customerPage=new CustomerPage(driver);
        testData=new TestData();
        productPage=new ProductPage(driver);
    }

    @Test(dataProvider = "customersData")
    public void addCustomerTest(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone,
                                String password, String confirmPassword, String addressDescription, String companyName, String address, String city,
                                String country, String state, String zipCode, String customerGroup){
        dashboardPage.clickCustomerList();
        customerPage.addCustomer(title,firstName,lastName,customerNotes,email,phone,cellPhone,password,confirmPassword,
                addressDescription,companyName,address,city,country,state,zipCode,customerGroup);
        Assert.assertTrue(customerPage.verifyAddCustomerSuccessfully());
    }
    @Test
    public void addProductTest(String productName,String manufacturer,String condition,String productCode,String productWeight,
                               String dimensionUnit,String productWidth,String productHeight,String productDepth,
                               String liveDate,int stockLevel, int stockLevelWarning,String upcCode,String eanCode,
                               String janCode,String isbnCode,String gtinCode,String mpnCode,String googleCategory,
                               String description, String shortDescription,double retailPrice,double salePrice,
                               String costPrice,String taxType,int minQuantity, int maxQuantity,int bulkQuantity, double bulkPrice,
                               String categories,String metaTitle,String seoPath,String metaDescription){
        dashboardPage.clickOnProductsLink();
        productPage.addProduct(productName,manufacturer,condition,productCode,productWeight,dimensionUnit,productWidth,
                productHeight,productDepth,liveDate,stockLevel,stockLevelWarning,upcCode,eanCode,janCode,isbnCode,
                gtinCode,mpnCode,googleCategory,description,shortDescription,retailPrice,salePrice,costPrice,taxType,minQuantity,
                maxQuantity,bulkQuantity,bulkPrice,categories,metaTitle,seoPath,metaDescription);
        Assert.assertTrue(productPage.verifyProductAddedSuccessfully());
    }
    @AfterClass
    public void tearDown(){
       closeBrowser();
    }

    @DataProvider
    public Object[][] customersData(){
        Object[][] data=new Object[][]{
                {testData.customerTitle(),testData.firstName,testData.lastName,testData.customerNotes,testData.email,
                testData.phone,testData.cellPhone,testData.password,testData.confirmPassword,testData.addressDescription(),
                testData.companyName,testData.address,testData.city,testData.country,testData.state,testData.zipCode,
                testData.customerGroup}
        };
        return data;
    }
    @DataProvider
    public Object[][] productData(){
        Object[][] data=new Object[][]{
        };
        return data;
    }
}
