package regressionsuit.testngproject;

import com.github.javafaker.Faker;
import com.unitedcoder.configutility.ApplicationConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataBase {
    String configFile = "config.properties";
    public int headlessMode=Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"headless"));

    public String userName = ApplicationConfig.readConfigProperties(configFile, "username");
    public String userPassword = ApplicationConfig.readConfigProperties(configFile, "password");
    public String uiUrl = ApplicationConfig.readConfigProperties(configFile, "qaurl");
    public String dbUrl= ApplicationConfig.readConfigProperties(configFile,"dburl");
    public String dbPort=ApplicationConfig.readConfigProperties(configFile,"dbport");
    public String dbUserName=ApplicationConfig.readConfigProperties(configFile,"dbusername");
    public String dbPassword=ApplicationConfig.readConfigProperties(configFile,"dbpassword");
    public String defaultDB=ApplicationConfig.readConfigProperties(configFile,"dbname");
    public String standAloneDB=ApplicationConfig.readConfigProperties(configFile,"standalonedbname");

    public String api_host=ApplicationConfig.readConfigProperties(configFile,"api_host");
    public int api_port=Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"api_port"));
    public String api_username=ApplicationConfig.readConfigProperties(configFile,"api_username");
    public String api_password=ApplicationConfig.readConfigProperties(configFile,"api_password");
    int timeOut = Integer.parseInt(ApplicationConfig.readConfigProperties(configFile, "timeout"));
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String customerNotes = faker.friends().quote();

    public String email = faker.internet().emailAddress();
    public String ipAddress=faker.internet().ipV4Address();
    public String phone = String.valueOf(faker.phoneNumber().phoneNumber());
    public String cellPhone = String.valueOf(faker.phoneNumber().cellPhone());

    public String password = faker.internet().password();
    public String confirmPassword = password;
    public String companyName = faker.company().name();
    public String address = faker.address().fullAddress();
    public String city = faker.country().capital();
    public String country = faker.country().name();
    public String state = faker.address().state();
    public String zipCode = faker.address().zipCode();
    public String groupName = faker.funnyName().name();
    public String groupDescription = faker.dune().quote();
    public String productName = faker.commerce().productName();
    public String productCode = Faker.instance().code().asin() + timeStamp();
    public double productWeight = Faker.instance().number().randomDouble(2, 1, 100);
    public double productWidth = Faker.instance().number().numberBetween(1, 100);
    public double productHeight = Faker.instance().number().numberBetween(1, 100);
    public double productDepth = Faker.instance().number().numberBetween(1, 100);
    public int stockLevel = Faker.instance().number().numberBetween(1, 1000);
   public int stockLevelWarning = Faker.instance().number().numberBetween(1, 20);
    public String upcCode = Faker.instance().code().imei();
    public String eanCode = Faker.instance().code().ean8();
    public String janCode = Faker.instance().code().ean13();
    public String isbnCode = Faker.instance().code().isbn13();
    public String gtinCode = Faker.instance().code().gtin8();
    public String mpnCode = Faker.instance().commerce().promotionCode();
    public String description = faker.harryPotter().quote();
    public String shortDescription = faker.gameOfThrones().quote();
    public double retailPrice = faker.number().randomDouble(2, 300, 500);
    public double salePrice = faker.number().randomDouble(2, 100, 300);
    public double costPrice = faker.number().randomDouble(2, 50, 200);
    public int minQuantity = faker.number().numberBetween(1, 5);
    public int maxQuantity = faker.number().numberBetween(10, 1000);
    public int bulkQuantity = faker.number().numberBetween(100, 1000);
    public double bulkPrice = faker.number().randomDouble(2, 100, 480);
    public String metaTitle = faker.name().title();
    public String seoPath = faker.internet().url();
    public String metaDescription = faker.internet().ipV4Address().concat(Faker.instance().book().genre());
    public String newsLetterSubject = faker.book().publisher();
    public String senderName = faker.name().fullName();
    public String senderEmail = faker.internet().emailAddress();
    public String htmlContent = faker.howIMetYourMother().quote();
    public String plainTextContent = faker.friends().quote();
    public String recipientEmail = faker.internet().emailAddress();
    public int orderQuantity = faker.number().numberBetween(1, 100);
    public double discountAmount = faker.number().randomDouble(2, 1, 90);
    public double shippingCost = faker.number().randomDouble(2, 5, 20);
    public double taxAmount = faker.number().randomDouble(2, 1, 30);
    public String internalNote = faker.harryPotter().quote();
    public String publicNote = faker.gameOfThrones().quote();
    public String categoryName=faker.commerce().department();
    public String keyword=faker.hipster().word();

    public String timeStamp() {
        long timeStamp = System.currentTimeMillis();
        return (Long.toString(timeStamp).toString().substring(10));
    }

    public String customerTitle() {
        List<String> title = new ArrayList<>(Arrays.asList("Mr.", "Miss", "Mrs."));
        Random randomTitle = new Random();
        String result = title.get(randomTitle.nextInt(title.size()));
        return result;
    }

    public String addressDescription() {
        List<String> descriptions = new ArrayList<>(Arrays.asList("Home Address", "Office Address", "Public Address"));
        Random randomAddress = new Random();
        String result = descriptions.get(randomAddress.nextInt(descriptions.size()));
        return result;
    }
    public String manufacturer() {
        List<String> options = new ArrayList<>(Arrays.asList("Amazon Essentials", "Crayola", "HP", "manufacturer1",
                "Apple"));
        Random randomOption = new Random();
        String result = options.get(randomOption.nextInt(options.size()));
        return result;
    }

    public String liveDate() {
        String randomTime = String.valueOf(Faker.instance().date().future(365, TimeUnit.DAYS));
        String[] timeContent = randomTime.split(" ");
        String liveDateValue = timeContent[2] + " " + timeContent[1] + " " + timeContent[5] + " " + timeContent[3];
        return liveDateValue;
    }

    public String googleCategory() {
        List<String> categories = new ArrayList<>(Arrays.asList("Animals & Pet Supplies", "Apparel & Accessories > Clothing",
                "Apparel & Accessories > Costumes & Accessories > Costume Shoes", "Arts & Entertainment", "Baby & Toddler",
                "Business & Industrial", "Cameras & Optics", "Electronics", "Food, Beverages & Tobacco", "Furniture",
                "Hardware", "Health & Beauty", "Home & Garden", "Luggage & Bags", "Mature", "Media", "Office Supplies",
                "Religious & Ceremonial", "Software", "Sporting Goods", "Toys & Games", "Vehicles & Parts"));
        Random randomCategory = new Random();
        String result = categories.get(randomCategory.nextInt(categories.size()));
        return result;
    }

    public String category() {
        List<String> categories = new ArrayList<>(Arrays.asList("kitchenware","Music & Shoes","Postern of Fate"));
        Random randomCategory = new Random();
        String result = categories.get(randomCategory.nextInt(categories.size()));
        return result;
    }

    public String dispatchDate() {
        String year = String.valueOf(faker.number().numberBetween(2023, 2025));
        String month = "0" + (faker.number().numberBetween(1, 9));
        String day = String.valueOf(faker.number().numberBetween(0, 31));
        return year + "-" + month + "-" + day;
    }

    public String shippingMethod() {
        List<String> methods = new ArrayList<>(Arrays.asList("FedEx", "UPS", "DHL", "Aramex", "TNT"));
        Random random = new Random();
        String value = methods.get(random.nextInt(methods.size()));
        return value;
    }

    public String shippingDate() {
        List<String> options = new ArrayList<>(Arrays.asList("Next Day", "Monday", "Tuesday", "Wednesday"));
        Random random = new Random();
        String value = options.get(random.nextInt(options.size()));
        return value;
    }

    public List<String> trackingInfo() {
        List<String> info = new ArrayList<>();
        info.add(faker.internet().url());
        info.add("\n");
        info.add(faker.code().asin());
        info.add("\n");
        return info;
    }

    public enum customerType {
        REGISTERED_CUSTOMER("Registered Customer"), UNREGISTERED_CUSTOMER("Unregistered Customer");
        private final String value;

        customerType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum subscriptionStatus {
        NO("No"), YES1("Yes"), YES2("Yes (Double Opt-In)");
        private final String value;

        subscriptionStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum condition {
        NEW("New"), USED("Used"), REFURBISHED("Refurbished"), DAMAGED("Damaged");
        private final String value;

        condition(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum dimensionUnit {
        CENTIMETERS("Centimeters (cm)"), INCHES("Inches (in)");
        private final String value;

        dimensionUnit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum taxType {
        STANDART_TAX("Standard Tax"), REDUCED_RATE("Reduced Rate"), TAX_EXEMPT("Tax Exempt");
        private final String value;

        taxType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum template {
        NONE("-- None --"), DEFAULT_EMAILS("Default Emails"), DEFAULT_NEWSLETTER("Default Newsletter");
        private final String value;

        template(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum orderStatus {
        PENDING("Pending"), PROCESSING("Processing"), ORDER_COMPLETE("Order Complete"), DECLINED("Declined"),
        FAILED_FRAUD_REVIEW("Failed Fraud Review"), CANCELLED("Cancelled");
        private final String value;

        orderStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum discountType {
        FIXED_PRICE_DISCOUNT("Fixed Price Discount"), PERCENTAGE_DISCOUNT("Percentage Discount");
        private final String value;

        discountType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public List<String> emails(){
        List<String> emails=new ArrayList<>();
        for(int i=0; i<3; i++) {
            emails.add(faker.internet().emailAddress());
        }
        return emails;
    }
}
