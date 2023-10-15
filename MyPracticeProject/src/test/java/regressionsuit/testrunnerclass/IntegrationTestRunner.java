package regressionsuit.testrunnerclass;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import regressionsuit.cubecartobjects.CustomerGroupObject;
import regressionsuit.cubecartobjects.CustomerObject;
import regressionsuit.cubecartobjects.ProductCategoryObject;
import regressionsuit.cubecartobjects.ProductObject;
import regressionsuit.pageobjectmodel.*;
import regressionsuit.testngproject.DataBase;
import regressionsuit.testngproject.TestBaseForTestNG;

import java.util.List;

//@Listeners(TestResultListener.class)

public class IntegrationTestRunner extends TestBaseForTestNG {
    int headlessMode=Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));
    String userName=ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    DataBase testData;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProductPage productPage;
    CustomerGroupObject customerGroupObject;
    CategoryPage categoryPage;
    ProductCategoryObject productCategoryObject;
    NewslettersPage newslettersPage;
    OrdersPage ordersPage;
    CustomerObject customerObject;
    ProductObject productObject;

    @BeforeClass
    public void setUp(ITestContext context){
        if(headlessMode==1){
            setUpBrowserInHeadlessMode();;
        }else {
            openBrowser();
        }
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        customerPage=new CustomerPage(driver);
        testData=new DataBase();
        productPage=new ProductPage(driver);
        categoryPage=new CategoryPage(driver);
        newslettersPage=new NewslettersPage(driver);
        ordersPage=new OrdersPage(driver);
        context.setAttribute("driver",driver);
    }
    @Test(dataProvider = "customerGroupsData")
    public void addCustomerGroupTest(String groupName,String groupDescription, ITestContext context){
        customerGroupObject=new CustomerGroupObject(groupName,groupDescription);
        dashboardPage.clickCustomerList();
        customerPage.addCustomerGroup(customerGroupObject);
        Assert.assertTrue(customerPage.verifyCustomerGroupAdded());
        //context.setAttribute(groupName,customerGroupObject.getGroupName());
    }

    @Test(dataProvider = "customersData",dependsOnMethods = "addCustomerGroupTest")
    public void addCustomerTest(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone,
                                String password, String confirmPassword, String addressDescription, String companyName, String address, String city,
                                String country, String state, String zipCode, String groupName,ITestContext context){
        customerObject=new CustomerObject(title,firstName,lastName,customerNotes,email,phone,cellPhone,password,
                confirmPassword,addressDescription,companyName,address,city,country,state,zipCode,groupName);
        //customerGroupObject=(CustomerGroupObject)context.getAttribute("groupName");
        dashboardPage.clickCustomerList();
        customerPage.addCustomer(customerObject);
        Assert.assertTrue(customerPage.verifyAddCustomerSuccessfully());
    }
    @Test(dataProvider = "productCategoryData")
    public void addProductCategoryTest(String categoryName){
        productCategoryObject=new ProductCategoryObject(categoryName);
        dashboardPage.clickCategories();
        categoryPage.addCategory(productCategoryObject);
        Assert.assertTrue(categoryPage.verifyCategoryAdded());
    }
    @Test(dataProvider = "productData",dependsOnMethods = "addProductCategoryTest")
    public void addProductTest(String productName,String manufacturer,String productCode,double productWeight,
                               double productWidth,double productHeight,double productDepth,
                               String liveDate,int stockLevel, int stockLevelWarning,String upcCode,String eanCode,
                               String janCode,String isbnCode,String gtinCode,String mpnCode,String googleCategory,
                               String description, String shortDescription,double retailPrice,double salePrice,
                               double costPrice,int minQuantity, int maxQuantity,int bulkQuantity, double bulkPrice,
                               String category,String metaTitle,String seoPath,String metaDescription){
        productObject=new ProductObject(productName,manufacturer,productCode,productWeight,
                productWidth,productHeight,productDepth,liveDate,stockLevel,stockLevelWarning,upcCode,eanCode,
                janCode,isbnCode,gtinCode,mpnCode,googleCategory,description,shortDescription,retailPrice,salePrice,
                costPrice,minQuantity,maxQuantity,bulkQuantity,bulkPrice,category,metaTitle,seoPath,metaDescription);
        dashboardPage.clickOnProductsLink();
        productPage.addProduct(productObject);
        Assert.assertTrue(productPage.verifyProductAddedSuccessfully());
    }
    @Test(dataProvider = "orderData",dependsOnMethods = {"addCustomerTest","addProductTest"})
    public void createOrderTest(String customerEmail, String dispatchDate, String shippingMethod, String shippingDate,
                                List<String> trackingInfo, double weight, int quantity, String productName,
                                double discountAmount, double shippingCost, double taxAmount, String internalNotes, String publicNotes){
        dashboardPage.clickOnOrders();
        ordersPage.createOrder(customerEmail,dispatchDate,shippingMethod,shippingDate,trackingInfo,weight,quantity,productName,
                discountAmount,shippingCost,taxAmount,internalNotes,publicNotes);
        Assert.assertTrue(ordersPage.verifyCreateOrderSuccessful());
    }
    @Test(dependsOnMethods = "createOrderTest")
    public void searchOrder(){
        dashboardPage.clickOnOrders();
        ordersPage.searchOrder();
        Assert.assertTrue(ordersPage.verifySearchOrder());
    }
    @Test(dependsOnMethods = "createOrderTest")
    public void editOrderTest(){
        dashboardPage.clickOnOrders();
        Assert.assertTrue(ordersPage.editOrderFromEditIcon());
    }
    @Test()
    public void viewOrdersTest(){
        dashboardPage.clickOnOrders();
        Assert.assertTrue(ordersPage.viewOrders());
    }
    @Test(dataProvider = "newsletterData")
    public void createNewsLetterTest(String newsLetterSubject,String senderName,String senderEmail,
                                     String htmlContent,String plainTextContent,String recipientEmail){
        dashboardPage.clickOnNewsletters();
        newslettersPage.createNewsLetter(newsLetterSubject,senderName,senderEmail,htmlContent,plainTextContent,
                recipientEmail);
        Assert.assertTrue(newslettersPage.verifyNewsletterCreated());
    }
    @AfterClass
    public void tearDown(){
       closeBrowser();
    }
    @DataProvider
    public Object[][] customerGroupsData(){
        return new Object[][]{{
                testData.groupName,testData.groupDescription}};
    }
    @DataProvider
    public Object[][] customersData(){
        return new Object[][]{
                {testData.customerTitle(),testData.firstName,testData.lastName,testData.customerNotes,testData.email,
                testData.phone,testData.cellPhone,testData.password,testData.confirmPassword,testData.addressDescription(),
                testData.companyName,testData.address,testData.city,testData.country,testData.state,testData.zipCode,
                customerGroupObject.getGroupName()}
        };
    }
    @DataProvider
    public Object[][] productCategoryData(){
        return new Object[][]{
                {testData.category()}
        };
    }
    @DataProvider
    public Object[][] productData(){
        return new Object[][]{
                {testData.productName,testData.manufacturer(),testData.productCode,testData.productWeight,
                testData.productWidth,testData.productHeight,testData.productDepth,testData.liveDate(),testData.stockLevel,
                testData.stockLevelWarning,testData.upcCode,testData.eanCode,testData.janCode,testData.isbnCode,testData.gtinCode,
                testData.mpnCode,testData.googleCategory(),testData.description,testData.shortDescription,testData.retailPrice,
                testData.salePrice,testData.costPrice,testData.minQuantity,testData.maxQuantity,testData.bulkQuantity,
                testData.bulkPrice,productCategoryObject.getCategoryName(),testData.metaTitle,testData.seoPath,testData.metaDescription}
        };
    }
    @DataProvider
    public Object[][] newsletterData() {
       return new Object[][]{
                    {testData.newsLetterSubject, testData.senderName, testData.senderEmail, testData.htmlContent,
                            testData.plainTextContent, testData.recipientEmail}

            };
    }
    @DataProvider
    public Object[][] orderData(){
        return new Object[][]{
                {customerObject.getEmail(),testData.dispatchDate(),testData.shippingMethod(),
                testData.shippingDate(),testData.trackingInfo(),testData.productWeight,testData.orderQuantity,
                productObject.getProductName(),testData.discountAmount,testData.shippingCost,testData.taxAmount,testData.internalNote,
                testData.publicNote}

        };
    }
}
