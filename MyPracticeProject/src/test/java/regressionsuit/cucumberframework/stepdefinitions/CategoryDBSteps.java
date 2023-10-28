package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import regressionsuit.databasetestautomation.ConnectionType;
import regressionsuit.databasetestautomation.DataBaseConnection;
import regressionsuit.databasetestautomation.SQLScripts;
import regressionsuit.testngproject.TestData;

import java.sql.Connection;

/**
 * @author : user
 * @created : 22.10.2023,18:09
 * @Email :aliyeidiris@gmail.com
 **/
public class CategoryDBSteps {
    Connection connection;
    DataBaseConnection dataBaseConnection;
    boolean isCategoryExist;
    @Given("the user has read access to the cc_CubeCart_category table")
    public void theUserHasReadAccessToTheCc_CubeCart_categoryTable() {
        dataBaseConnection=new DataBaseConnection();
        connection=dataBaseConnection.connectToDataBaseServer(TestData.dbUrl,TestData.dbPort,TestData.dbUserName,TestData.dbPassword,
                TestData.defaultDB, ConnectionType.MYSQL);
    }
    @When("user query to get the category information with id {int}")
    public void userQueryToGetTheCategoryInformationWithId(int id) {
        SQLScripts sqlScripts=new SQLScripts();
        isCategoryExist=sqlScripts.getCategoryInfo(connection,id);
    }
    @Then("user should be able to see the category information in the table")
    public void userShouldBeAbleToSeeTheCategoryInformationInTheTable() {
        Assert.assertTrue(isCategoryExist);
    }



}
