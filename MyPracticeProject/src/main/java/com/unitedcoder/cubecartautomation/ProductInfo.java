package com.unitedcoder.cubecartautomation;

public class ProductInfo {
    private String productName; private String productCode; private String weight;
    private String width; private String height; private String depth; private String listDate;
    private int stockLevel; private int stockLevelWarming; private String upcCode;
    private String eanCode; private String janCode; private String isbnCode; private  String gtinCode;
    private String mpnCode;

    //default constructor
    public ProductInfo() {
    }

    //constructor with parameters
    public ProductInfo(String productName, String productCode, String weight, String width, String height,
                       String depth, String listDate, int stockLevel, int stockLevelWarming, String upcCode,
                       String eanCode, String janCode, String isbnCode, String gtinCode, String mpnCode) {
        this.productName = productName;                 this.productCode = productCode;
        this.weight = weight;                           this.width = width;
        this.height = height;                           this.depth = depth;
        this.listDate = listDate;                       this.stockLevel = stockLevel;
        this.stockLevelWarming = stockLevelWarming;     this.upcCode = upcCode;
        this.eanCode = eanCode;                         this.janCode = janCode;
        this.isbnCode = isbnCode;                       this.gtinCode = gtinCode;
        this.mpnCode = mpnCode;
    }

    //getter
    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getWeight() {
        return weight;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getDepth() {
        return depth;
    }

    public String getListDate() {
        return listDate;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public int getStockLevelWarming() {
        return stockLevelWarming;
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
}
