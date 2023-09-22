package regressionsuit.databasetestautomation;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    //write a method to get a product information
    public boolean getProductInfo(String productName, Connection connection){
        boolean isProductExist=false;
        Statement statement=null;       //define a statement object to execute sql script
        ResultSet resultSet=null;       //mandatory
        CachedRowSet cachedRowSet=null; //optional (stores resultSet locally)
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement= connection.createStatement(); //open a new query tab
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //write sql script
        String selectProduct=String.format("select product_id,name,price from cc_CubeCart_inventory where name='%s'"
                ,productName);
        try {
            resultSet=statement.executeQuery(selectProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //verify the result set
        int count;
        String name="";
        if (resultSet==null){
            System.out.println("No records found");
            return isProductExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
                count=cachedRowSet.getRow();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    int product_id=cachedRowSet.getInt("product_id");
                name=cachedRowSet.getString("name");
                double price=cachedRowSet.getDouble("price");
                System.out.println(String.format("product_id= %d\nproduct_name= %s\nproduct_price= %.2f",
                        product_id,name,price));

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            if(count>=1 & productName.equalsIgnoreCase(name))
                System.out.println("Product count: "+count);
                isProductExist=true;
            return isProductExist;
        }
    }
}
