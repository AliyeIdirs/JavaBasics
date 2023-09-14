package regressionsuit.cubecartobjects;

public class ProductObject {
    private String productName; private String manufacturer;
    private String productCode; private double weight; private double width;
    private double height; private double depth; private String liveDate;
     private int stockLevel; private int stockLevelWarning; private String upcCode;
    private String eanCode; private String janCode; private String isbnCode; private  String gtinCode;
    private String mpnCode; private String googleCategory; private String description;private String shortDescription;
    private double retailPrice;private double salePrice;private double costPrice;private int minQuantity;
    private int maxQuantity;private int bulkQuantity;private double bulkPrice;private String category;
    private String metaTitle;private String seoPath;private String metaDescription;

    public ProductObject(String productName, String manufacturer, String productCode, double weight, double width, double height, double depth,  String liveDate, int stockLevel, int stockLevelWarning, String upcCode, String eanCode, String janCode, String isbnCode, String gtinCode, String mpnCode, String googleCategory) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productCode = productCode;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.depth = depth;
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

    public ProductObject(String productName, String manufacturer, String productCode, double weight, double width, double height, double depth, String liveDate, int stockLevel, int stockLevelWarning, String upcCode, String eanCode, String janCode, String isbnCode, String gtinCode, String mpnCode, String googleCategory, String description, String shortDescription, double retailPrice, double salePrice, double costPrice, int minQuantity, int maxQuantity, int bulkQuantity, double bulkPrice, String category, String metaTitle, String seoPath, String metaDescription) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productCode = productCode;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.depth = depth;
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
        this.description = description;
        this.shortDescription = shortDescription;
        this.retailPrice = retailPrice;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
        this.category = category;
        this.metaTitle = metaTitle;
        this.seoPath = seoPath;
        this.metaDescription = metaDescription;
    }

    //getter
    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public double getWeight() {
        return weight;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public String getGoogleCategory() {
        return googleCategory;
    }
    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getBulkQuantity() {
        return bulkQuantity;
    }

    public double getBulkPrice() {
        return bulkPrice;
    }

    public String getCategory() {
        return category;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public String getSeoPath() {
        return seoPath;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    @Override
    public String toString() {
        return
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productCode='" + productCode + '\'' +
                ", weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", listDate='" + liveDate + '\'' +
                ", stockLevel=" + stockLevel +
                ", stockLevelWarning=" + stockLevelWarning +
                ", upcCode='" + upcCode + '\'' +
                ", eanCode='" + eanCode + '\'' +
                ", janCode='" + janCode + '\'' +
                ", isbnCode='" + isbnCode + '\'' +
                ", gtinCode='" + gtinCode + '\'' +
                ", mpnCode='" + mpnCode + '\'' +
                ", googleCategory='" + googleCategory + '\'' +
                '}';
    }
}
