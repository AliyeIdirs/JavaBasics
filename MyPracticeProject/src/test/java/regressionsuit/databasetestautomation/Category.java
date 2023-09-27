package regressionsuit.databasetestautomation;

public class Category {
    private String cat_name;
    private String description;
    private int cat_Parent_Id;
    private double perShip;
    private double itemShip;
    private double itemIntShip;
    private double perIntShip;
    private int hide;
    private String seoMetaTitle;
    private String seoMetaDescription;
    private int priority;
    private int status;
    private int cat_image;
    private String meta_keyword;

    public Category(String cat_name, String description, int cat_Parent_Id, double perShip, double itemShip, double itemIntShip, double perIntShip, int hide, String seoMetaTitle, String seoMetaDescription, int priority, int status, int cat_image, String meta_keyword) {
        this.cat_name = cat_name;
        this.description = description;
        this.cat_Parent_Id = cat_Parent_Id;
        this.perShip = perShip;
        this.itemShip = itemShip;
        this.itemIntShip = itemIntShip;
        this.perIntShip = perIntShip;
        this.hide = hide;
        this.seoMetaTitle = seoMetaTitle;
        this.seoMetaDescription = seoMetaDescription;
        this.priority = priority;
        this.status = status;
        this.cat_image = cat_image;
        this.meta_keyword = meta_keyword;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getDescription() {
        return description;
    }

    public int getCat_Parent_Id() {
        return cat_Parent_Id;
    }

    public double getPerShip() {
        return perShip;
    }

    public double getItemShip() {
        return itemShip;
    }

    public double getItemIntShip() {
        return itemIntShip;
    }

    public double getPerIntShip() {
        return perIntShip;
    }

    public int getHide() {
        return hide;
    }

    public String getSeoMetaTitle() {
        return seoMetaTitle;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public int getPriority() {
        return priority;
    }

    public int getStatus() {
        return status;
    }

    public int getCat_image() {
        return cat_image;
    }

    public String getMeta_keyword() {
        return meta_keyword;
    }
}
