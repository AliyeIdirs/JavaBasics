package regressionsuit.databasetestautomation;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class SQLScripts {

    //Aynigar code 2022
    public boolean getProductInfo(String productName, Connection connection){
        Statement statement;       //define a statement object to execute sql script
        ResultSet resultSet;       //mandatory
        CachedRowSet cachedRowSet; //optional (stores resultSet locally)
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
        try {
            if (resultSet==null){
                System.out.println("No records found");
                return false;
            }else{
                try {
                    cachedRowSet.populate(resultSet);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                while (true){
                    count=cachedRowSet.getRow();
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
                    System.out.printf("product_id= %d product_name= %s product_price= %.2f%n",
                            product_id,name,price);

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }
                if(count>=1 & productName.equalsIgnoreCase(name))
                    System.out.println("Product count: "+count);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Aynigar code 2023
    public boolean getProductInfo(Connection connection, String productName) {
        boolean isProductExist = false;
        Statement statement;
        ResultSet resultSet;
        CachedRowSet cachedRowSet;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlScriptForProduct = String.format("select product_id,name,price from cc_CubeCart_inventory where name='%s'",
                productName);
        try {
            resultSet = statement.executeQuery(sqlScriptForProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet == null) {
            System.out.println("No records found");
        } else {
            try {

                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int rowCount = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    int product_id = cachedRowSet.getInt("product_id");
                    String name = cachedRowSet.getString("name");
                    double price = cachedRowSet.getDouble("price");
                    System.out.printf("product_id=%d name=%s price=%.2f%n",product_id,name,price);
                    rowCount = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rowCount >= 1) {
                    isProductExist = true;
                }
            }
            System.out.println("Row count: "+rowCount);
        }
        return isProductExist;
    }

    //Aliye code 2023
    public boolean getCustomerInfo(Connection connection, String customerName, String customerEmail){
        Statement statement;
        ResultSet resultSet;
        CachedRowSet cachedRowSet;
        try {
            statement=connection.createStatement();
            String sqlScriptForCustomer=String.format("Select * from cc_CubeCart_customer where first_name='%s' and email='%s'",
                    customerName,customerEmail);
            resultSet=statement.executeQuery(sqlScriptForCustomer);
            cachedRowSet=RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultSet);
            if(!cachedRowSet.next()) {
                System.out.println("No record found!");
                return false;
            }else{
                int rowCount;
                do{
                    rowCount=cachedRowSet.getRow();
                    int customer_id = cachedRowSet.getInt("customer_id");
                    String firstName = cachedRowSet.getString("first_name");
                    String lastName=cachedRowSet.getString("last_name");
                    String email=cachedRowSet.getString("email");
                    if (firstName.equalsIgnoreCase(customerName)&email.equalsIgnoreCase(customerEmail)) {
                        System.out.printf("Customer_Id: %d, CustomerName: %s %s, Customer_Email: %s",
                                customer_id,firstName,lastName,email);
                    }else
                        System.out.println("Customer info dose not match!!!");
                }while (cachedRowSet.next());
                System.out.println("\nRow count is:" + rowCount);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertNewCategory(Connection connection,Category category){
        String insertCategorySqlScript="insert into cc_CubeCart_category"+
                "(cat_name,cat_desc,cat_parent_id,per_ship,item_ship,item_int_ship,per_int_ship,hide," +
                "seo_meta_title,seo_meta_description,priority,status,cat_image,seo_meta_keywords)" +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertStatement;
        int affectedRowsCount;
        try {
            insertStatement=connection.prepareStatement(insertCategorySqlScript);

            insertStatement.setString(1,category.getCat_name());
            insertStatement.setString(2,category.getDescription());
            insertStatement.setInt(3,category.getCat_Parent_Id());
            insertStatement.setDouble(4,category.getPerShip());
            insertStatement.setDouble(5,category.getItemShip());
            insertStatement.setDouble(6,category.getItemIntShip());
            insertStatement.setDouble(7,category.getPerIntShip());
            insertStatement.setInt(8,category.getHide());
            insertStatement.setString(9,category.getSeoMetaTitle());
            insertStatement.setString(10,category.getSeoMetaDescription());
            insertStatement.setInt(11,category.getPriority());
            insertStatement.setInt(12,category.getStatus());
            insertStatement.setInt(13,category.getCat_image());
            insertStatement.setString(14,category.getMeta_keyword());

            affectedRowsCount=insertStatement.executeUpdate();
            System.out.printf("%d rows affected%n",affectedRowsCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return affectedRowsCount >= 1;
    }
}
