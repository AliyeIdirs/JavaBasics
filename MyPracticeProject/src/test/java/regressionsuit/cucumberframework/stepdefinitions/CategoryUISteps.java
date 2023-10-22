package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import regressionsuit.cubecartobjects.ProductCategoryObject;
import regressionsuit.junitframework.TestBase;
import regressionsuit.pageobjectmodel.CategoryPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.TestData;

/**
 * @author : user
 * @created : 22.10.2023,12:10
 * @Email :aliyeidiris@gmail.com
 **/
public class CategoryUISteps extends TestBase {
    TestData td=new TestData();
    LoginPage loginPage=new LoginPage(driver);
    DashboardPage dashboardPage=new DashboardPage(driver);
    CategoryPage categoryPage=new CategoryPage(driver);
    @Given("admin user login to the CubeCart application user interface")
    public void adminUserLoginToTheCubeCartApplicationUserInterface() {
        loginPage.login(TestData.userName,TestData.userPassword);
        dashboardPage.verifyLogin();
    }
    @Given("user is on the Add Category page")
    public void userIsOnTheAddCategoryPage() {
        dashboardPage.clickCategories();
    }

    @When("user fills out the category information on the Add Category page and click on save button")
    public void userFillsOutTheCategoryInformationOnTheAddCategoryPageAndClickOnSaveButton() {
        ProductCategoryObject categoryObject=new ProductCategoryObject(td.categoryName,td.description,td.metaTitle,
                td.seoPath,td.metaDescription);
        categoryPage.addCategory(categoryObject);
    }
    @Then("a new Category should be appeared in the categories list")
    public void aNewCategoryShouldBeAppearedInTheCategoriesList() {
        Assert.assertTrue(categoryPage.verifyCategoryAdded());
        Assert.assertTrue(categoryPage.categoryExistInTheList(td.categoryName));
    }
    @Given("user is on the categories page")
    public void userIsOnTheCategoriesPage() {
        dashboardPage.clickCategories();
    }

    @When("user update the category info with id <{int}> from the UI")
    public void userUpdateTheCategoryInfoWithIdFromTheUI(int id) {
        categoryPage.updateCategory(td.categoryName,id);
    }

    @Then("the category information should be updated successfully")
    public void theCategoryInformationShouldBeUpdatedSuccessfully() {
        Assert.assertTrue(categoryPage.verifyCategoryUpdated());
    }
}
