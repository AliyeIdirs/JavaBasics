package com.unitedcoder.classconcepts;

public class TestSuitClassDemo {
    /*
    @param testSuitId -- this param is for test suit id
    @param testSuitName -- this param is for test suit name
    @param testSuitDescription -- this param is fo test suit description
     */

    private int testSuitId;
    private String testSuitName;
    private String testSuitDescription;


    //create a class constructor without argument list
    public TestSuitClassDemo() {
    }


    //create a class constructor with all fields defined in the class
    public TestSuitClassDemo(int testSuitId, String testSuitName, String testSuitDescription) {
        this.testSuitId = testSuitId;
        this.testSuitName = testSuitName;
        this.testSuitDescription = testSuitDescription;
    }


    //create get and set methods
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

    @Override
    public String toString() {
        return "TestSuitClassDemo{" +
                "testSuitId=" + testSuitId +
                ", testSuitName='" + testSuitName + '\'' +
                ", testSuitDescription='" + testSuitDescription + '\'' +
                '}';
    }

    public static void main(String[] args){

        //create a test suit object
        TestSuitClassDemo testSuitClassDemo= new TestSuitClassDemo();

        //set test suit object properties
        testSuitClassDemo.setTestSuitId(1);
        testSuitClassDemo.setTestSuitName("Login Suit");
        testSuitClassDemo.setTestSuitDescription("User should be able to login the system");

        //get test suit object properties
        System.out.println("Test Suit Id: "+testSuitClassDemo.getTestSuitId() );
        System.out.println("Test Suit Name: "+testSuitClassDemo.getTestSuitName());
        System.out.println("Test Suit Description: "+testSuitClassDemo.getTestSuitDescription());

        //create test suit object with initial field value

        TestSuitClassDemo testSuitClassDemo2= new TestSuitClassDemo(2,"Logout Test Suit","Users should be able to log out");
        System.out.println("Test Suit Id: "+testSuitClassDemo2.getTestSuitId() );
        System.out.println("Test Suit Name: "+testSuitClassDemo2.getTestSuitName());
        System.out.println("Test Suit Description: "+testSuitClassDemo2.getTestSuitDescription());

        System.out.println(testSuitClassDemo2);
    }
}
