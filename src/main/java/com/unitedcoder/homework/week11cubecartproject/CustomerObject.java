package com.unitedcoder.homework.week11cubecartproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CustomerObject {
    private String title; private String firstName; private String lastName;
    private String customerNotes; private String email; private String phone; private String cellPhone;
   private String password; private String confirmPassword;
    private String addressDescription; private String companyName; private String address;
    private String city; private String country; private String state; private String zipCode; private String customerGroup;

    //default constructor
    public CustomerObject() {
    }

    //Constructor with general info parameters
    public CustomerObject( String title, String firstName, String lastName,
                          String customerNotes, String email, String phone, String cellPhone,
                         String password, String confirmPassword,
                           String addressDescription, String companyName, String address, String city,
                           String country, String state, String zipCode, String customerGroup) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNotes = customerNotes;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.addressDescription = addressDescription;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
        this.customerGroup=customerGroup;
    }

    //getter()

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }
    public String getCountry(){return country;}
    public String getState(){return state;}
    public String getCustomerGroup(){return customerGroup;}

    //setter()

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }


    //set enum for some dropdowns
    public enum CustomerDropdowns{
        REGISTERED_CUSTOMER("Registered Customer"),
        UNREGISTERED_CUSTOMER("Unregistered Customer");
        private final String value;
        //constructor
        CustomerDropdowns(String value) {
            this.value = value;
        }
        // getter()
        public String getValue() {
            return value;
        }
    }

    public static String customerTitle(){
        List<String> title= new ArrayList<>(Arrays.asList("Mr.","Miss","Mrs."));
        Random randomTitle= new Random();
        String result=title.get(randomTitle.nextInt(title.size()));
        return result;
    }
    public static String email(){
        List<String> mailForm= new ArrayList<>(Arrays.asList("@gmail.com","@yahoo.com","@outlook.com"));
        Random randomEmail= new Random();
        String result=mailForm.get(randomEmail.nextInt(mailForm.size()));
        return result;
    }
    public static String addressDescription(){
        List<String> descriptions= new ArrayList<>(Arrays.asList("Home Address","Office Address","Public Address"));
        Random randomAddress= new Random();
        String result=descriptions.get(randomAddress.nextInt(descriptions.size()));
        return result;
    }

    public static String addressDetail(){
        List<String> details= new ArrayList<>(Arrays.asList("2259 Gislason Mountains, Apt. 868, McKenzieburgh, Montana, United States",
                "Amasya, Turkey","Koloniestraße 10, Apt. 223, 5059, Hausleiten, Burgenland, Austria",
                "adress","王路65号, Apt. 827, 250370, 西阳市, 河北省, China"));
        Random randomDetail= new Random();
        String result=details.get(randomDetail.nextInt(details.size()));
        return result;
    }

    public static String country(){
        String country=addressDetail().substring(addressDetail().lastIndexOf(",")+1);
        List<String> countryList= new ArrayList<>(Arrays.asList("Australia","Belgium","Yemen", "Canada",
                "China","Denmark","United Arab Emirates","Japan","New Zealand","Turkey","United States",
                "Germany","United Kingdom"));
        Random randomCountry= new Random();
        String result=countryList.get(randomCountry.nextInt(countryList.size()));
        return result;
    }
    public static String customerGroup(){
        List<String> groupList=new ArrayList<>(Arrays.asList("VIP Customer","Standard Customer","Premium Customer"));
        Random randomGroup= new Random();
        String result=groupList.get(randomGroup.nextInt(groupList.size()));
        return result;
    }

}

