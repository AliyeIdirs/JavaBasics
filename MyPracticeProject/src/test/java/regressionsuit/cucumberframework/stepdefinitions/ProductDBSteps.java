package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
 * @created : 16.10.2023,14:29
 * @Email :aliyeidiris@gmail.com
 **/
public class ProductDBSteps {
    private Scenario scenario;
    Connection connection;
    TestData db=new TestData();
    boolean isProductExist;
    @Before
    public void beforeStepInCucumber(Scenario scenario){
        this.scenario=scenario;
    }
    @Given("the user has read access to the cc_CubeCart_inventory table")
    public void theUserHasReadAccessToTheCc_CubeCart_inventoryTable() {
        DataBaseConnection dataBaseConnection=new DataBaseConnection();
        connection= dataBaseConnection.connectToDataBaseServer(db.dbUrl,db.dbPort,db.dbUserName,db.dbPassword,
                db.defaultDB,ConnectionType.MYSQL);
        scenario.log("Database username: "+db.dbUserName);
        scenario.log("Database password: "+db.dbPassword);
    }

    @When("the user query the cc_CubeCart_inventory table")
    public void theUserQueryTheCc_CubeCart_inventoryTable() {
        SQLScripts sqlScripts=new SQLScripts();
        String productName="TestProduct-2023-10-18-123";
        isProductExist=sqlScripts.getProductInfo(connection,productName);
        scenario.log("Product name to be searched: "+productName);

    }

    @Then("the user should see the product info")
    public void theUserShouldSeeTheProductInfo() {
        Assert.assertTrue(isProductExist);
    }
}
