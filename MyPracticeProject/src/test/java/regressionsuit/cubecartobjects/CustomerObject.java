package regressionsuit.cubecartobjects;

public class CustomerObject {
    private String title; private String firstName; private String lastName;
    private String customerNotes; private String email; private String phone; private String cellPhone;
    private String password; private String confirmPassword;
    private String addressDescription; private String companyName; private String address;
    private String city; private String country; private String state; private String zipCode; private String customerGroup;

    //default constructor
    public CustomerObject() {
    }

    public CustomerObject(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //constructor with general info
    public CustomerObject(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone, String password, String confirmPassword) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNotes = customerNotes;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    //Constructor with general, address, and customer group info
    public CustomerObject(String title, String firstName, String lastName,
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



}
