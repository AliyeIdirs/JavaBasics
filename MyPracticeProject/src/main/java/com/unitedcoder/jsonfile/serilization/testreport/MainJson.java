package com.unitedcoder.jsonfile.serilization.testreport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"TestName","TestModule","TestType","TestSteps","Verification","Note"})
public class MainJson {
    @JsonProperty("Note")
    private String note;
    @JsonProperty("Verification")
    private String verification;
    @JsonProperty("TestType")
    private String testType;
    @JsonProperty("TestModule")
    private String testModule;
    @JsonProperty("TestSteps")
    List<TestSteps> testSteps;
    @JsonProperty("TestName")
    private String testName;

    public MainJson() {
    }

    public MainJson(String note, String verification, String testType, String testModule, List<TestSteps> testSteps, String testName) {
        this.note = note;
        this.verification = verification;
        this.testType = testType;
        this.testModule = testModule;
        this.testSteps = testSteps;
        this.testName = testName;
    }

    public String getNote() {
        return note;
    }

    public String getVerification() {
        return verification;
    }

    public String getTestType() {
        return testType;
    }

    public String getTestModule() {
        return testModule;
    }

    public List<TestSteps> getTestSteps() {
        return testSteps;
    }

    public String getTestName() {
        return testName;
    }
}
