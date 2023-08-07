package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CubeCartMainJson {
    @JsonProperty("login-user")
    private LoginUser loginUsers;
    @JsonProperty("customer")
    private Customer customers;
    @JsonProperty("product")
    private Product products;
    @JsonProperty("url")
    private String url;

    public CubeCartMainJson() {
    }

    public CubeCartMainJson(LoginUser loginUsers, Customer customers, Product products,String url) {
        this.loginUsers = loginUsers;
        this.customers = customers;
        this.products = products;
        this.url=url;
    }

    public LoginUser getLoginUsers() {
        return loginUsers;
    }

    public Customer getCustomers() {
        return customers;
    }

    public Product getProducts() {
        return products;
    }

    public String getUrl() {
        return url;
    }
}
