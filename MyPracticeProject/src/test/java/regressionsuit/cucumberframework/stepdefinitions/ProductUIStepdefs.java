package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import regressionsuit.cubecartobjects.ProductObject;
import regressionsuit.cucumberframework.ProductTestRunner;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.ProductPage;
import regressionsuit.testngproject.DataBase;

/**
 * @author : user
 * @created : 16.10.2023,14:24
 * @Email :aliyeidiris@gmail.com
 **/
public class ProductUIStepdefs {
    WebDriver driver= ProductTestRunner.getDriver();
    DashboardPage dashboardPage;
    LoginPage loginPage;
    ProductPage productPage;
    DataBase db;
    ProductObject productObject;
    @Given("user is on the dashboard page")
    public void userIsOnTheDashboardPage() {
        db=new DataBase();
        dashboardPage=new DashboardPage(driver);
        productPage=new ProductPage(driver);
        Assert.assertTrue(dashboardPage.verifyDashboardPage());
    }

    @When("the user fills out a new product form")
    public void theUserFillsOutANewProductForm() {
        /*productObject=new ProductObject(db.productName,db.manufacturer(),db.productCode,db.productWeight,db.productWidth,
                db.productHeight,db.productDepth,db.liveDate(),db.stockLevel,db.stockLevelWarning,db.upcCode,db.eanCode,
                db.janCode,db.isbnCode,db.gtinCode,db.mpnCode,db.googleCategory(),db.description,db.shortDescription,
                db.retailPrice,db.salePrice,db.costPrice,db.minQuantity,db.maxQuantity,db.bulkQuantity, db.bulkPrice,
                db.category(),db.metaTitle,db.seoPath,db.metaDescription);*/
        dashboardPage.clickOnProductsLink();
        productPage.addProduct(db.productName,db.productCode,db.stockLevel);
    }

    @Then("a new product should be created")
    public void aNewProductShouldBeCreated() {
        Assert.assertTrue(productPage.verifyProductAddedSuccessfully());
    }

    @When("the user tries to delete an existing product")
    public void theUserTriesToDeleteAnExistingProduct() {
        dashboardPage.clickOnProductsLink();
        productPage.deleteProduct(db.productCode);
    }

    @Then("the product should be deleted")
    public void theProductShouldBeDeleted() {
        Assert.assertTrue(productPage.verifyProductDeleteSuccessfully());
    }
}
