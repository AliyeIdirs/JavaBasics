package com.unitedcoder.homework.week10day1class;

public class Category {
     String name;
     String status;
     boolean visible;
     String parentCategory;

    public Category() {
    }

    public Category(String name, String status, String visible, String parentCategory) {
        this.name = name;
        this.status = status;
        this.visible = Boolean.parseBoolean(visible);
        this.parentCategory = parentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = Boolean.parseBoolean(visible);
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }
}

class TestCategory{
    public static void main(String[] args) {
        Category category= new Category();
        category.setName("Phone");
        category.setStatus("New");
        category.setVisible("True");
        category.setParentCategory("Electronic Device");

        System.out.println(category.getName());
        System.out.println(category.getStatus());
        System.out.println(category.getVisible());
        System.out.println(category.getParentCategory());

        Category category1= new Category("Book","Used","true","Educational Product");
        System.out.println(category1.getName());
        System.out.println(category1.getStatus());
        System.out.println(category1.getVisible());
        System.out.println(category1.getParentCategory());
    }
}
