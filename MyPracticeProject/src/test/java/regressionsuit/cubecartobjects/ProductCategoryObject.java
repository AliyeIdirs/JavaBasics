package regressionsuit.cubecartobjects;

public class ProductCategoryObject {
    private String categoryName;
    private String parentCategoryName;
    private String description;
    private String metaTitle;
    private String seoPath;
    private String metaDescription;

    public ProductCategoryObject(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategoryObject(String categoryName, String parentCategoryName) {
        this.categoryName = categoryName;
        this.parentCategoryName = parentCategoryName;
    }

    public ProductCategoryObject(String categoryName, String description, String metaTitle, String seoPath, String metaDescription) {
        this.categoryName = categoryName;
        this.description = description;
        this.metaTitle = metaTitle;
        this.seoPath = seoPath;
        this.metaDescription = metaDescription;
    }

    public String getDescription() {
        return description;
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

    public String getCategoryName() {
        return categoryName;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }
}
