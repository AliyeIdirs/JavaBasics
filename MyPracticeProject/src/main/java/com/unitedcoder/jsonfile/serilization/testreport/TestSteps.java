package com.unitedcoder.jsonfile.serilization.testreport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TestSteps {

    @JsonProperty("Id")
    @JsonIgnore
    private int Id;
    @JsonProperty("Step")
    @JsonIgnore
    private static String Step;

    public TestSteps() {
    }

    public TestSteps(int Id, String Step) {
        this.Id = Id;
        this.Step = Step;
    }

    public int getId() {
        return Id;
    }

    public static String getStep() {
        return Step;
    }
}
