package regressionsuit.testngproject;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestData {
    Faker faker=new Faker();
    public  String customerTitle(){
        List<String> title= new ArrayList<>(Arrays.asList("Mr.","Miss","Mrs."));
        Random randomTitle= new Random();
        String result=title.get(randomTitle.nextInt(title.size()));
        return result;
    }
    String firstName=faker.name().firstName();
    String lastName=faker.name().lastName();
    String customerNotes=faker.friends().quote();
    String email=faker.internet().emailAddress();
    String phone=String.valueOf(faker.phoneNumber().phoneNumber());
    String cellPhone=String.valueOf(faker.phoneNumber().cellPhone());
    String password=faker.internet().password();
    String confirmPassword=password;
    public String addressDescription(){
        List<String> descriptions= new ArrayList<>(Arrays.asList("Home Address","Office Address","Public Address"));
        Random randomAddress= new Random();
        String result=descriptions.get(randomAddress.nextInt(descriptions.size()));
        return result;
    }
    String companyName=faker.company().name();
    String address=faker.address().fullAddress();
    String city=faker.country().capital();
    String country=faker.country().name();
    String state=faker.address().state();
    String zipCode=faker.address().zipCode();
    String customerGroup="Team_6";
    public enum customerType{
        REGISTERED_CUSTOMER("Registered Customer"), UNREGISTERED_CUSTOMER("Unregistered Customer");
        private final String value;
        customerType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public enum subscriptionStatus{
        NO("No"),YES1("Yes"), YES2("Yes (Double Opt-In)");
        private final String value;
        subscriptionStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    String productName=faker.commerce().productName();
    String manufacturer(){
        List<String> manufacturers=new ArrayList<>(Arrays.asList("Amazon Essentials","Apple","Crayola","HP","manufacturer1"));
        Random randomOption=new Random();
        String result=manufacturers.get(randomOption.nextInt(manufacturers.size()));
        return result;
    }
}
