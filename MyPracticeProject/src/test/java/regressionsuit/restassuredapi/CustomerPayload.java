package regressionsuit.restassuredapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayload {
    /*
{
    "email": "AdamSmith123@hotmail.com",
    "firstName": "Adam",
    "lastName": "Smith",
    "country": 1,
    "phone": "",
    "status": 0,
    "language": "en-GB",
    "ipAddress": "",
    "registered": 1696545242
}
     */
    @JsonProperty
    private String email;
    @JsonProperty
    private String title;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private int country;
    @JsonProperty
    private String phone;
    @JsonProperty
    private int status;
    @JsonProperty
    private String language;
    @JsonProperty
    private String ipAddress;
    @JsonProperty
    private int registered;

    public CustomerPayload() {
    }

    public CustomerPayload(String email, String title, String firstName, String lastName, int country, String phone, int status, String language, String ipAddress, int registered) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.phone = phone;
        this.status = status;
        this.language = language;
        this.ipAddress = ipAddress;
        this.registered = registered;
    }

    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public String getLanguage() {
        return language;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getCountry() {
        return country;
    }

    public int getRegistered() {
        return registered;
    }
}
