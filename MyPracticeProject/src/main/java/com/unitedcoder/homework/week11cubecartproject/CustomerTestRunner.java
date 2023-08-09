package com.unitedcoder.homework.week11cubecartproject;

import java.util.ArrayList;
import java.util.List;
public class CustomerTestRunner extends AddAndUpdateMultipleCustomers{

    public static void main(String[] args) {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        AdminUser adminUser= new AdminUser();
        logIn(new AdminUser("testautomation2","automation123!"));
        if(!verifyLogin()) {
            System.out.println("Login Failed, unable to add customer.");
            tearDown();
        }else {

            List<CustomerObject> customerList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                CustomerObject customerObject = new CustomerObject(CustomerObject.customerTitle(), "Alan" + System.currentTimeMillis(),
                        "White" + System.currentTimeMillis(), "Note " + System.currentTimeMillis(),
                        "email" + System.currentTimeMillis() + CustomerObject.email(), "212" + System.currentTimeMillis(), "5" + System.currentTimeMillis(),
                        "abc1+", "abc1+", CustomerObject.addressDescription(), "Company" + System.currentTimeMillis(),
                        CustomerObject.addressDetail(), "City", CustomerObject.country(), "state",
                        "ZPC" + System.currentTimeMillis(), CustomerObject.customerGroup());
                customerList.add(customerObject);

                //call add customer method
                addCustomer(customerObject);
                verifyCustomerAddedSuccessfully(customerObject);
            }

            //call update customer method
           /* for (CustomerObject customerObject : customerList) {
                updateCustomer(customerObject);
            }*/

            //call Delete method by search
           /* for (CustomerObject customerObject : customerList) {
                deleteCustomer(customerObject);
            }*/

            //call Delete method by select
            //deleteCustomer(new CustomerObject());

            logOut();
            tearDown();

        }

    }
}
