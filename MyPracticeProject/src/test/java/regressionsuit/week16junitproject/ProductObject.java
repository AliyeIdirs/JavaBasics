package regressionsuit.week16junitproject;

import com.github.javafaker.Faker;

import java.util.concurrent.TimeUnit;

public class ProductObject {
    private String productName;
    private String manufacturer;
    private String condition;
    private String productCode;
    private String productWeight;
    private String dimensionUnit;
    private String productWidth;
    private String productHeight;
    private String productDepth;
    private String liveDate;
    private int stockLevel;
    private int stockLevelWarning;
    private String upcCode;
    private String eanCode;
    private String janCode;
    private String isbnCode;
    private String gtinCode;
    private String mpnCode;
    private String googleCategory;

    public ProductObject() {
    }

    public ProductObject(String productName, String manufacturer, String condition, String productCode, String productWeight, String dimensionUnit, String productWidth, String productHeight, String productDepth, String liveDate, int stockLevel, int stockLevelWarning, String upcCode, String eanCode, String janCode, String isbnCode, String gtinCode, String mpnCode, String googleCategory) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.condition = condition;
        this.productCode = productCode;
        this.productWeight = productWeight;
        this.dimensionUnit = dimensionUnit;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productDepth = productDepth;
        this.liveDate = liveDate;
        this.stockLevel = stockLevel;
        this.stockLevelWarning = stockLevelWarning;
        this.upcCode = upcCode;
        this.eanCode = eanCode;
        this.janCode = janCode;
        this.isbnCode = isbnCode;
        this.gtinCode = gtinCode;
        this.mpnCode = mpnCode;
        this.googleCategory = googleCategory;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCondition() {
        return condition;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public String getDimensionUnit() {
        return dimensionUnit;
    }

    public String getProductWidth() {
        return productWidth;
    }

    public String getProductHeight() {
        return productHeight;
    }

    public String getProductDepth() {
        return productDepth;
    }

    public String getLiveDate() {
        return liveDate;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public int getStockLevelWarning() {
        return stockLevelWarning;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public String getEanCode() {
        return eanCode;
    }

    public String getJanCode() {
        return janCode;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public String getGtinCode() {
        return gtinCode;
    }

    public String getMpnCode() {
        return mpnCode;
    }

    public String getGoogleCategory() {
        return googleCategory;
    }



}
