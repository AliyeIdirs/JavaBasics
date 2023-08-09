package com.unitedcoder.homework.week13cubecartautomation;

    public class Product {
        private String status;private String productName; private String manufacturer;
        private String condition;private String productCode; private String autoGenerateProductCode;
        private double weight; private String dimensionUnit; private double width;
        private double height; private double depth; private String includeInFeaturedProduct;
        private String includeInLatestProduct; private String availableForPurchase; private String listDate;
        private String useStockLevel; private int stockLevel; private int stockLevelWarning; private String upcCode;
        private String eanCode; private String janCode; private String isbnCode; private  String gtinCode;
        private String mpnCode; private String googleCategory;


        public Product(String status, String productName, String manufacturer, String condition, String productCode, String autoGenerateProductCode, double weight, String productUnit, double width, double height, double depth, String includeInFeaturedProduct, String includeInLatestProduct, String availableForPurchase, String listDate, String useStockLevel, int stockLevel, int stockLevelWarning, String upcCode, String eanCode, String janCode, String isbnCode, String gtinCode, String mpnCode, String googleCategory) {
            this.status = status;
            this.productName = productName;
            this.manufacturer = manufacturer;
            this.condition = condition;
            this.productCode = productCode;
            this.autoGenerateProductCode = autoGenerateProductCode;
            this.weight = weight;
            this.dimensionUnit = productUnit;
            this.width = width;
            this.height = height;
            this.depth = depth;
            this.includeInFeaturedProduct = includeInFeaturedProduct;
            this.includeInLatestProduct = includeInLatestProduct;
            this.availableForPurchase = availableForPurchase;
            this.listDate = listDate;
            this.useStockLevel = useStockLevel;
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

        public String getListDate() {
            return listDate;
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

        public String isStatus() {
            return status;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getCondition() {
            return condition;
        }

        public String isAutoGenerateProductCode() {
            return autoGenerateProductCode;
        }

        public String getDimensionUnit() {
            return dimensionUnit;
        }

        public String isIncludeInFeaturedProduct() {
            return includeInFeaturedProduct;
        }

        public String isIncludeInLatestProduct() {
            return includeInLatestProduct;
        }

        public String isAvailableForPurchase() {
            return availableForPurchase;
        }

        public String isUseStockLevel() {
            return useStockLevel;
        }

        public String getGoogleCategory() {
            return googleCategory;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public void setAutoGenerateProductCode(String autoGenerateProductCode) {
            this.autoGenerateProductCode = autoGenerateProductCode;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public void setDimensionUnit(String dimensionUnit) {
            this.dimensionUnit = dimensionUnit;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public void setDepth(double depth) {
            this.depth = depth;
        }

        public void setIncludeInFeaturedProduct(String includeInFeaturedProduct) {
            this.includeInFeaturedProduct = includeInFeaturedProduct;
        }

        public void setIncludeInLatestProduct(String includeInLatestProduct) {
            this.includeInLatestProduct = includeInLatestProduct;
        }

        public void setAvailableForPurchase(String availableForPurchase) {
            this.availableForPurchase = availableForPurchase;
        }

        public void setListDate(String listDate) {
            this.listDate = listDate;
        }

        public void setUseStockLevel(String useStockLevel) {
            this.useStockLevel = useStockLevel;
        }

        public void setStockLevel(int stockLevel) {
            this.stockLevel = stockLevel;
        }

        public void setStockLevelWarning(int stockLevelWarning) {
            this.stockLevelWarning = stockLevelWarning;
        }

        public void setUpcCode(String upcCode) {
            this.upcCode = upcCode;
        }

        public void setEanCode(String eanCode) {
            this.eanCode = eanCode;
        }

        public void setJanCode(String janCode) {
            this.janCode = janCode;
        }

        public void setIsbnCode(String isbnCode) {
            this.isbnCode = isbnCode;
        }

        public void setGtinCode(String gtinCode) {
            this.gtinCode = gtinCode;
        }

        public void setMpnCode(String mpnCode) {
            this.mpnCode = mpnCode;
        }

        public void setGoogleCategory(String googleCategory) {
            this.googleCategory = googleCategory;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "status='" + status + '\'' +
                    ", productName='" + productName + '\'' +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", condition='" + condition + '\'' +
                    ", productCode='" + productCode + '\'' +
                    ", autoGenerateProductCode='" + autoGenerateProductCode + '\'' +
                    ", weight=" + weight +
                    ", dimensionUnit='" + dimensionUnit + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", depth=" + depth +
                    ", includeInFeaturedProduct='" + includeInFeaturedProduct + '\'' +
                    ", includeInLatestProduct='" + includeInLatestProduct + '\'' +
                    ", availableForPurchase='" + availableForPurchase + '\'' +
                    ", listDate='" + listDate + '\'' +
                    ", useStockLevel='" + useStockLevel + '\'' +
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
