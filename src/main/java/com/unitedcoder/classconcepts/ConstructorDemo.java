package com.unitedcoder.classconcepts;

import org.openqa.selenium.edge.AddHasCasting;

public class ConstructorDemo {
    private String projectName;
    private int projectId;
    private int testSuitId;
    private String testSuitName;
    private String TestSuitDescription;

    //default constructor -no argument constructor
    public ConstructorDemo() {
    }

    //constructor with arguments
    //parameterized constructor

    public ConstructorDemo(int testSuitId, String testSuitName) {
        this.testSuitId = testSuitId;
        this.testSuitName = testSuitName;
    }

    public ConstructorDemo(int testSuitId, String testSuitName, String testSuitDescription) {
        this.testSuitId = testSuitId;
        this.testSuitName = testSuitName;
        TestSuitDescription = testSuitDescription;
    }

    public ConstructorDemo(String projectName, int projectId, int testSuitId, String testSuitName, String testSuitDescription) {
        this.projectName = projectName;
        this.projectId = projectId;
        this.testSuitId = testSuitId;
        this.testSuitName = testSuitName;
        TestSuitDescription = testSuitDescription;
    }

    //main program
    public static void main(String[] args) {
        ConstructorDemo constructorDemo1= new ConstructorDemo();
        constructorDemo1.setProjectId(1);
        constructorDemo1.setProjectName("Clinic Wise Project");
        constructorDemo1.setTestSuitId(1);
        constructorDemo1.setTestSuitName("Login Logout Suit");
        constructorDemo1.setTestSuitDescription("Valid users can login and logout of the system");
        System.out.println("Project Id: "+constructorDemo1.getProjectId() +
                "\nProject Name: "+constructorDemo1.getProjectName()+
                "\nTest Suit Id: "+constructorDemo1.getTestSuitId()+
                "\nTest Suit Name: "+constructorDemo1.getTestSuitName()+
                "\nTest Suit Description: "+constructorDemo1.getTestSuitDescription());

        //use the constructor with all fields
        ConstructorDemo constructorDemo2= new ConstructorDemo("Clinic Wise Staff Project",2,
                2,"Manage Staff","Admin user can manage staff");
        System.out.println("Project Id: "+constructorDemo2.getProjectId());
        System.out.println( "Project Name: "+constructorDemo2.getProjectName());
        System.out.println( "Test Suit Id: "+constructorDemo2.getTestSuitId());
        System.out.println("Test Suit Name: "+constructorDemo2.getTestSuitName());
        System.out.println( "Test Suit Description: "+constructorDemo2.getTestSuitDescription());
    }

    //define get and set methods for fields
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

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
        return TestSuitDescription;
    }

    public void setTestSuitDescription(String testSuitDescription) {
        TestSuitDescription = testSuitDescription;
    }
}
