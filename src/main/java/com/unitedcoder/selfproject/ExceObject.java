package com.unitedcoder.selfproject;

public class ExceObject {
    private String productName;  private String productCode;  private String productWeight;  private String productWidth;
    private String productHeight;  private String productDepth;  private String stockLevel;
    private String stockLevelWarning;  private String upcCode;  private String eanCode;  private String janCode;
    private String isbnCode;  private String gtinCode;  private String mpnCode;
    /* ---- pricing -----*/
    private String retailPrice;  private String salePrice;  private String costPrice;  private String minimumPurchase;
    private String maximumPurchase;  private String quantity;  private String price;

    public ExceObject() {
    }

    public ExceObject(String productName, String productCode, String productWeight, String productWidth,
                      String productHeight, String productDepth, String stockLevel, String stockLevelWarning,
                      String upcCode, String eanCode, String janCode, String isbnCode, String gtinCode, String mpnCode,
                      String retailPrice, String salePrice, String costPrice, String minimumPurchase,
                      String maximumPurchase, String quantity, String price) {
        this.productName = productName;
        this.productCode = productCode;
        this.productWeight = productWeight;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productDepth = productDepth;
        this.stockLevel = stockLevel;
        this.stockLevelWarning = stockLevelWarning;
        this.upcCode = upcCode;
        this.eanCode = eanCode;
        this.janCode = janCode;
        this.isbnCode = isbnCode;
        this.gtinCode = gtinCode;
        this.mpnCode = mpnCode;
        this.retailPrice = retailPrice;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.minimumPurchase = minimumPurchase;
        this.maximumPurchase = maximumPurchase;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductWeight() {
        return productWeight;
    }
    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }
    public String getProductWidth() {
        return productWidth;
    }
    public void setProductWidth(String productWidth) {
        this.productWidth = productWidth;
    }
    public String getProductHeight() {
        return productHeight;
    }
    public void setProductHeight(String productHeight) {
        this.productHeight = productHeight;
    }
    public String getProductDepth() {
        return productDepth;
    }
    public void setProductDepth(String productDepth) {
        this.productDepth = productDepth;
    }
    public String getStockLevel() {
        return stockLevel;
    }
    public void setStockLevel(String stockLevel) {
        this.stockLevel = stockLevel;
    }
    public String getStockLevelWarning() {
        return stockLevelWarning;
    }
    public void setStockLevelWarning(String stockLevelWarning) {
        this.stockLevelWarning = stockLevelWarning;
    }
    public String getUpcCode() {
        return upcCode;
    }
    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }
    public String getEanCode() {
        return eanCode;
    }
    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }
    public String getJanCode() {
        return janCode;
    }
    public void setJanCode(String janCode) {
        this.janCode = janCode;
    }
    public String getIsbnCode() {
        return isbnCode;
    }
    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }
    public String getGtinCode() {
        return gtinCode;
    }
    public void setGtinCode(String gtinCode) {
        this.gtinCode = gtinCode;
    }
    public String getMpnCode() {
        return mpnCode;
    }
    public void setMpnCode(String mpnCode) {
        this.mpnCode = mpnCode;
    }
    public String getRetailPrice() {
        return retailPrice;
    }
    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }
    public String getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }
    public String getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }
    public String getMinimumPurchase() {
        return minimumPurchase;
    }
    public void setMinimumPurchase(String minimumPurchase) {
        this.minimumPurchase = minimumPurchase;
    }
    public String getMaximumPurchase() {
        return maximumPurchase;
    }
    public void setMaximumPurchase(String maximumPurchase) {
        this.maximumPurchase = maximumPurchase;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "ExceObject{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productWeight='" + productWeight + '\'' +
                ", productWidth='" + productWidth + '\'' +
                ", productHeight='" + productHeight + '\'' +
                ", productDepth='" + productDepth + '\'' +
                ", stockLevel=" + stockLevel +
                ", stockLevelWarning=" + stockLevelWarning +
                ", upcCode=" + upcCode +
                ", eanCode=" + eanCode +
                ", janCode=" + janCode +
                ", isbnCode='" + isbnCode + '\'' +
                ", gtinCode='" + gtinCode + '\'' +
                ", mpnCode='" + mpnCode + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", costPrice='" + costPrice + '\'' +
                ", minimumPurchase=" + minimumPurchase +
                ", maximumPurchase=" + maximumPurchase +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
