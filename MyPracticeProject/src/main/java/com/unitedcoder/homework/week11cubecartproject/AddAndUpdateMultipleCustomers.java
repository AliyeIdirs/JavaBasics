package com.unitedcoder.homework.week11cubecartproject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class AddAndUpdateMultipleCustomers extends BaseClass{

    //Add multiple customers
    public static void addCustomer(CustomerObject customerObject)  {

        //Fill general information
        WebElement customerListLink = driver.findElement(By.linkText("Customer List"));
        customerListLink.click();

        WebElement addCustomerLink = driver.findElement(By.xpath("//a[contains(text(),\"Add Customer\")]"));
        addCustomerLink.click();

        WebElement status = driver.findElement(By.xpath("//img[@rel='#customer_status']"));
        status.click();

        WebElement title = driver.findElement(By.id("cust-title"));
        title.sendKeys(customerObject.getTitle());

        WebElement firstName = driver.findElement(By.name("customer[first_name]"));
        firstName.sendKeys(customerObject.getFirstName());

        WebElement lastName = driver.findElement(By.id("cust-lastname"));
        lastName.sendKeys(customerObject.getLastName());

        WebElement typeDropdown = driver.findElement(By.id("cust-type"));
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText(CustomerObject.CustomerDropdowns.REGISTERED_CUSTOMER.getValue());

        WebElement customerNotes = driver.findElement(By.id("cust-notes"));
        customerNotes.sendKeys(customerObject.getCustomerNotes());

        WebElement email = driver.findElement(By.id("cust-email"));
        email.sendKeys(customerObject.getEmail());

        WebElement phone = driver.findElement(By.id("cust-phone"));
        phone.sendKeys(customerObject.getPhone());

        WebElement cellPhone = driver.findElement(By.id("cust-mobile"));
        cellPhone.sendKeys(customerObject.getCellPhone());

        WebElement newsletterDropdown = driver.findElement(By.id("subscription_status"));
        Select newsletterStatus = new Select(newsletterDropdown);
        List<WebElement> options = newsletterStatus.getOptions();
        for (WebElement text : options) {
            String selectText = text.getText();
            if (selectText.equalsIgnoreCase("Yes")) {
                text.click();
            }
        }

        WebElement addressesLink = driver.findElement(By.linkText("Addresses"));
        fluentWait(addressesLink,3);
        try {
        WebElement password = driver.findElement(By.id("cust-password"));
        password.sendKeys(customerObject.getPassword());

        WebElement confirmPassword = driver.findElement(By.id("cust-passconf"));
        confirmPassword.sendKeys(customerObject.getConfirmPassword());
            if (!customerObject.getPassword().equalsIgnoreCase(customerObject.getConfirmPassword())) {
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i) {
            System.out.println("password unmatched, please enter same passwords");
        }finally {
            addressesLink.click();
        }
        //Fill address information
        WebElement addAddressLink = driver.findElement(By.cssSelector(".colorbox.address-form.cboxElement"));
        addAddressLink.click();
        WebElement description = driver.findElement(By.id("edit_description"));
        fluentWait(description,3);
        description.sendKeys(customerObject.getAddressDescription());

        WebElement editTitle = driver.findElement(By.id("edit_title"));
        editTitle.sendKeys(customerObject.getTitle());

        WebElement editFirstName = driver.findElement(By.name("address[first_name][]"));
        editFirstName.sendKeys(customerObject.getFirstName());

        WebElement editLastName = driver.findElement(By.id("edit_last_name"));
        editLastName.sendKeys(customerObject.getLastName());

        WebElement companyName = driver.findElement(By.id("edit_company_name"));
        companyName.sendKeys(customerObject.getCompanyName());

        WebElement addressLine1 = driver.findElement(By.name("address[line1][]"));
        WebElement addressLine2 = driver.findElement(By.name("address[line2][]"));
        sleep(1);
        if (customerObject.getAddress().length() > 35) {
            addressLine1.sendKeys(StringUtils.substring(customerObject.getAddress(), 0, 35));
            addressLine2.sendKeys(StringUtils.substring(customerObject.getAddress(), 35));
        } else {
            addressLine1.sendKeys(customerObject.getAddress());
        }
        WebElement city = driver.findElement(By.id("edit_town"));
        city.sendKeys(customerObject.getCity());

        WebElement countryOption = driver.findElement(By.id("edit_country"));
        Select selectCountry = new Select(countryOption);
        selectCountry.selectByVisibleText(customerObject.getCountry());
        sleep(2);
        WebElement state = driver.findElement(By.name("address[state][]"));
            if(state.getText().equalsIgnoreCase("-- None --")){
                Select select = new Select(state);
                select.selectByIndex(3);
            }else {
                state.sendKeys(customerObject.getState());
            }

        WebElement zipCode = driver.findElement(By.id("edit_postcode"));
        zipCode.sendKeys(customerObject.getZipCode());

        WebElement billingAddressCheckBox = driver.findElement(By.name("address[billing][]"));
        if (!billingAddressCheckBox.isEnabled()) {
            billingAddressCheckBox.click();
        }
        WebElement deliveryAddressCheckBox = driver.findElement(By.name("address[default][]"));
        if (!deliveryAddressCheckBox.isEnabled()) {
            deliveryAddressCheckBox.click();
        }
        WebElement addButton = driver.findElement(By.xpath("//input[@target='address-list']"));
        addButton.click();
        //Select customer group
        WebElement customerGroups = driver.findElement(By.linkText("Customer Groups"));
        fluentWait(customerGroups,2);
        customerGroups.click();

        WebElement groupType = driver.findElement(By.id("group-join"));
        fluentWait(groupType,2);
        Select selectCustomerGroup = new Select(groupType);
        List<WebElement> groups = selectCustomerGroup.getOptions();
        for (int i = 0; i < groups.size(); i++) {
            String groupValue = groups.get(i).getText();
            if (groupValue.equalsIgnoreCase(customerObject.getCustomerGroup())) {
                groups.get(i).click();
            }
        }
       WebElement saveButton= driver.findElement(By.name("save"));
        saveButton.click();
    }
        //verify add customer successful
        public static void verifyCustomerAddedSuccessfully(CustomerObject customerObject){
            WebElement successMessage=driver.findElement(By.xpath
                    ("//*[contains(text(),'Customer successfully added.')]"));
            if(successMessage.isDisplayed()){
                System.out.println(customerObject.getCustomerGroup()+" "+customerObject.getTitle()+" "+
                        customerObject.getLastName() +" added successfully");
            }else{
                System.out.println("Add customer Failed!!!");
            }
        }


        public static void updateCustomer(CustomerObject customerObject){

            WebElement customerListLink = driver.findElement(By.linkText("Customer List"));
            fluentWait(customerListLink,2);
            customerListLink.click();

            WebElement searchCustomerMenu= driver.findElement(By.linkText("Search Customers"));
            searchCustomerMenu.click();
            WebElement searchCustomerBar= driver.findElement(By.id("customer_id"));
            searchCustomerBar.click();
            searchCustomerBar.sendKeys(customerObject.getEmail());
            WebElement goButton= driver.findElement(By.xpath("//*[@id=\"sidebar_content\"]/div[1]/form/input[3]"));
            goButton.click();
            WebElement editIcon= driver.findElement(By.cssSelector(".fa.fa-pencil-square-o"));
            editIcon.click();

            WebElement customerNotes = driver.findElement(By.id("cust-notes"));
            customerNotes.clear();
            customerNotes.sendKeys("New customer note "+System.currentTimeMillis());
            WebElement saveButton= driver.findElement(By.name("save"));
            saveButton.click();
            WebElement successMessage= driver.findElement(By.xpath("//div[text()='Customer successfully updated.']"));
            if (successMessage.isDisplayed()){
                System.out.println("Customer "+customerObject.getLastName()+"  updated successfully");
            }
        }

        public static void deleteCustomer(CustomerObject customerObject){
            WebElement customerListLink = driver.findElement(By.linkText("Customer List"));
            customerListLink.click();

            //Delete with search function
          /*  WebElement searchCustomerMenu= driver.findElement(By.linkText("Search Customers"));
            searchCustomerMenu.click();
            WebElement searchCustomerBar= driver.findElement(By.id("customer_id"));
            searchCustomerBar.click();
            searchCustomerBar.sendKeys(customerObject.getEmail());
            WebElement goButton= driver.findElement(By.xpath("//*[@id=\"sidebar_content\"]/div[1]/form/input[3]"));
            goButton.click();
            WebElement deleteIcon= driver.findElement (By.xpath(String.format ("//td[text()='%s']//parent::td//following-sibling::td//*[@title='Delete']",customerObject.getEmail())));
            deleteIcon.click();
            driver.switchTo().alert().accept();*/

            //Delete by select multiple customers
            for (int i = 1; i <= 3; i++) {
                WebElement multiCustomerCheckBox = driver.findElement(By.xpath(String.format("//*[@id=\"customer-list\"]/table[2]/tbody/tr[%d]/td[1]/div", i)));
                multiCustomerCheckBox.click();
            }
            WebElement deleteIcon= driver.findElement(By.xpath("//*[@id=\"customer-list\"]/table[2]/tbody/tr[1]/td[8]/a[3]"));
            deleteIcon.click();
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();

            WebElement verifyDeleteSuccess= driver.findElement(By.xpath("//div[contains(text(),\"successfully deleted.\")]"));
            if (verifyDeleteSuccess.isDisplayed()) {
                System.out.println("Some or all selected Customer successfully deleted.");
            }else{
            System.out.println("Delete not successful");
            }
        }
}
