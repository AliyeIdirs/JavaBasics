package com.unitedcoder.jsonfile.serilization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Members {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty("secretIdentity")
    private String secretIdentity;

    public Members() {
    }

    public Members(String name, int age, String secretIdentity) {
        this.name = name;
        this.age = age;
        this.secretIdentity = secretIdentity;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }
}
