package com.unitedcoder.classconcepts;

public class EncapsulationDemo {
    private  int testSuitId;
    private String testSuitName;
    private String testSuitDescription;

    public int getTestSuitId() {
        return testSuitId;
    }

    public void setTestSuitId(int testSuitId) {
        this.testSuitId = testSuitId;
    }

    public String getTestSuitName() {
        return testSuitName;
    }

    public void setTestSuitName(String testSuitName) {
        this.testSuitName = testSuitName;
    }

    public String getTestSuitDescription() {
        return testSuitDescription;
    }

    public void setTestSuitDescription(String testSuitDescription) {
        this.testSuitDescription = testSuitDescription;
    }
}

class EncapsulationDemoTest{
    public static void main(String[] args) {
        EncapsulationDemo obj= new EncapsulationDemo();
        obj.setTestSuitId(2);
        obj.setTestSuitName("Dashboard Test Suit");
        obj.setTestSuitDescription("Admin Dashboard");
        System.out.println("Test Suit Id: " +obj.getTestSuitId());
        System.out.println("Test Suit Name: "+obj.getTestSuitName());
        System.out.println("Test Suit Description: "+obj.getTestSuitDescription());
    }
}
