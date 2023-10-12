package regressionsuit.restassuredapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryPayload {
    /*
        {
        "catName": "SuperGoods",
        "catDescription": "This is a test category setup during install. It can be edited or deleted from the store admin control panel.",
        "catParentId": 0,
        "catImage": 0,
        "perShip": 0.0,
        "itemShip": 0.0,
        "itemIntShip": 0.0,
        "perIntShip": 0.0,
        "hide": 1,
        "seoMetaTitle": "",
        "seoMetaDescription": "",
        "seoMetaKeywords": "",
        "priority": 803,
        "status": 0
    }
     */
    @JsonProperty
    private String catName;
    @JsonProperty
    private String catDescription;
    @JsonProperty
    private int cat_parent_id;
    @JsonProperty
    private int cat_image;
    @JsonProperty
    private double per_ship;
    @JsonProperty
    private double item_ship;
    @JsonProperty
    private double item_int_ship;
    @JsonProperty
    private double per_int_ship;
    @JsonProperty
    private int hide;
    @JsonProperty
    private String seo_meta_title;
    @JsonProperty
    private String seo_meta_description;
    @JsonProperty
    private String seo_meta_keywords;
    @JsonProperty
    private int priority;
    @JsonProperty
    private int status;
    @JsonProperty
    private int cat_hier_position;

    public CategoryPayload(String catName, String catDescription, int cat_parent_id, int cat_image, double per_ship, double item_ship, double item_int_ship, double per_int_ship, int hide, String seo_meta_title, String seo_meta_description, String seo_meta_keywords, int priority, int status, int cat_hier_position) {
        this.catName = catName;
        this.catDescription = catDescription;
        this.cat_parent_id = cat_parent_id;
        this.cat_image = cat_image;
        this.per_ship = per_ship;
        this.item_ship = item_ship;
        this.item_int_ship = item_int_ship;
        this.per_int_ship = per_int_ship;
        this.hide = hide;
        this.seo_meta_title = seo_meta_title;
        this.seo_meta_description = seo_meta_description;
        this.seo_meta_keywords = seo_meta_keywords;
        this.priority = priority;
        this.status = status;
        this.cat_hier_position = cat_hier_position;
    }

    public CategoryPayload(String catName) {
        this.catName = catName;
    }

    public CategoryPayload(String catName, String catDescription) {
        this.catName = catName;
        this.catDescription = catDescription;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public int getCat_parent_id() {
        return cat_parent_id;
    }

    public int getCat_image() {
        return cat_image;
    }

    public double getPer_ship() {
        return per_ship;
    }

    public double getItem_ship() {
        return item_ship;
    }

    public double getItem_int_ship() {
        return item_int_ship;
    }

    public double getPer_int_ship() {
        return per_int_ship;
    }

    public int getHide() {
        return hide;
    }

    public String getSeo_meta_title() {
        return seo_meta_title;
    }

    public String getSeo_meta_description() {
        return seo_meta_description;
    }

    public String getSeo_meta_keywords() {
        return seo_meta_keywords;
    }

    public int getPriority() {
        return priority;
    }

    public int getStatus() {
        return status;
    }

    public int getCat_hier_position() {
        return cat_hier_position;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public void setCat_parent_id(int cat_parent_id) {
        this.cat_parent_id = cat_parent_id;
    }

    public void setCat_image(int cat_image) {
        this.cat_image = cat_image;
    }

    public void setPer_ship(double per_ship) {
        this.per_ship = per_ship;
    }

    public void setItem_ship(double item_ship) {
        this.item_ship = item_ship;
    }

    public void setItem_int_ship(double item_int_ship) {
        this.item_int_ship = item_int_ship;
    }

    public void setPer_int_ship(double per_int_ship) {
        this.per_int_ship = per_int_ship;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public void setSeo_meta_title(String seo_meta_title) {
        this.seo_meta_title = seo_meta_title;
    }

    public void setSeo_meta_description(String seo_meta_description) {
        this.seo_meta_description = seo_meta_description;
    }

    public void setSeo_meta_keywords(String seo_meta_keywords) {
        this.seo_meta_keywords = seo_meta_keywords;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCat_hier_position(int cat_hier_position) {
        this.cat_hier_position = cat_hier_position;
    }
}
