package com.unitedcoder.homework.week10day1class;

public class Customer {
    private boolean status;
    private String title;
    private String firstName;
    private String lastName;
    private String type;
    private String email;

    private String phone;
    private String cellPhone;
    private String password;
    private String confirmPassword;
    private String subscribedToNewsletter;

    //default constructor
    public Customer() {
    }

    //Constructor with parameters
public Customer(String title, String firstName, String lastName, String email, String phone, String cellPhone){
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.cellPhone = cellPhone;
}


    public Customer(String title, String firstName, String lastName, String email, String phone, String cellPhone, String password, String confirmPassword) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    //getter(

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
}

    class testCustomer{
        public static void main(String[] args) {

        Customer customer = new Customer("Mr","Alim","Ahmed",
                "alimahmed@gmail.com","2128564345","5414331852L",
                "ad342+","ad342+");

            System.out.println(customer.getEmail());
            System.out.println(customer.getCellPhone());
            System.out.println(customer.getFirstName());

        }
    }
