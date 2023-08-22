package regressionsuit.junitframework;

import java.util.List;

public class PromotionalCodeInfo {
    private String code;
    private String description;
    private int discountValue;
    private String startDate;
    private String expiresDate;
    private String allowedUses;
    private double minSubTotal;
    private List<String> limitToManufacturer;

    public PromotionalCodeInfo(String code, String description, int discountValue, String startDate, String expiresDate, String allowedUses, double minimumSubTotal, List<String> limitToManufacturer) {
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.startDate = startDate;
        this.expiresDate = expiresDate;
        this.allowedUses = allowedUses;
        this.minSubTotal = minimumSubTotal;
        this.limitToManufacturer = limitToManufacturer;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getExpiresDate() {
        return expiresDate;
    }

    public String getAllowedUses() {
        return allowedUses;
    }

    public double getMinimumSubTotal() {
        return minSubTotal;
    }

    public List<String> getLimitToManufacturer() {
        return limitToManufacturer;
    }
}
