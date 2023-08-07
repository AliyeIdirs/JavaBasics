package com.unitedcoder.collectiondatastructure;

public class EnumDemo {
    /*An enum Type is a special data type that enables for a variable to be a set of predefined constants. */
    public enum TestType{
        SMOKE_TEST,INTEGRATION_TEST,REGRESSION_TEST,PERFORMANCE_TEST,STRESS_TEST,FUNCTIONAL_TEST
    }
    public static void main(String[] args) {
        EnumDemo enumDemo=new EnumDemo();
        enumDemo.selectTestType(TestType.SMOKE_TEST);
        enumDemo.selectTestType(TestType.FUNCTIONAL_TEST);

    }
    private void selectTestType(TestType testType){
        switch(testType){
            case SMOKE_TEST:
                System.out.println("Run Smoke Test");
                System.out.println("Smoke Test is running!!!");
                break;
            case INTEGRATION_TEST:
                System.out.println("Run Integration Test");
                System.out.println("Integration Test is running!!!");
                break;
            case REGRESSION_TEST:
                System.out.println("Run Regression Test");
                System.out.println("Regression Test is running!!!");
                break;
            case PERFORMANCE_TEST:
                System.out.println("Run Performance Test");
                System.out.println("Performance Test is running!!!");
                break;
            case STRESS_TEST:
                System.out.println("Run Stress Test");
                System.out.println("Stress Test is running!!!");
                break;
            case FUNCTIONAL_TEST:
                System.out.println("Run Functional Test");
                System.out.println("Functional Test is running!!!");
                break;
            default:
                System.out.println("Run Smoke Test");
                System.out.println("Smoke Test is running!!!");
        }
    }
}
