package regressionsuit.cubecartobjects;

public class ProductCategoryObject {
    private String categoryName;
    private String parentCategoryName;

    public ProductCategoryObject(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategoryObject(String categoryName, String parentCategoryName) {
        this.categoryName = categoryName;
        this.parentCategoryName = parentCategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }
}
