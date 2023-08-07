package com.unitedcoder.dropdowns;

public enum CustomerType {
    REGISTERED_CUSTOMER("Registered Customer"),
    UNREGISTERED_CUSTOMER("Unregistered Customer");

    private final String value;


    //constructor
    CustomerType(String value) {
        this.value = value;
    }

    // getter()
    public String getValue() {
        return value;
    }
}
