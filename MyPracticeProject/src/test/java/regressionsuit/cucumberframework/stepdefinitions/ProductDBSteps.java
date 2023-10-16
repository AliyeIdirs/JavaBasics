package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import regressionsuit.databasetestautomation.ConnectionType;
import regressionsuit.databasetestautomation.DataBaseConnection;
import regressionsuit.databasetestautomation.SQLScripts;
import regressionsuit.testngproject.DataBase;

import java.sql.Connection;

/**
 * @author : user
 * @created : 16.10.2023,14:29
 * @Email :aliyeidiris@gmail.com
 **/
public class ProductDBSteps {
    Connection connection;
    DataBase db=new DataBase();
    boolean isProductExist;
    @Given("the user has read access to the cc_CubeCart_inventory table")
    public void theUserHasReadAccessToTheCc_CubeCart_inventoryTable() {
        DataBaseConnection dataBaseConnection=new DataBaseConnection();
        connection= dataBaseConnection.connectToDataBaseServer(db.dbUrl,db.dbPort,db.dbUserName,db.dbPassword,
                db.defaultDB,ConnectionType.MYSQL);
    }

    @When("the user query the cc_CubeCart_inventory table")
    public void theUserQueryTheCc_CubeCart_inventoryTable() {
        SQLScripts sqlScripts=new SQLScripts();
        isProductExist=sqlScripts.getProductInfo(connection,"Ergonomic Cotton Bottle");

    }

    @Then("the user should see the product info")
    public void theUserShouldSeeTheProductInfo() {
        Assert.assertTrue(isProductExist);
    }
}
