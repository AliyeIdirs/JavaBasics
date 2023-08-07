package com.unitedcoder.javabasic;

public class StringExample {

    public static void main(String[] args) {
        //define a string variable
        String greeting="Hello, Selenium Master";


        //get string length
        int i=greeting.length();
        System.out.println("The string length is "+i);


        //convert to upper case
        String greetingUpper=greeting.toUpperCase();
        System.out.println("Upper case of the string greeting is "+greetingUpper);


        //convert to lower case
        String greetingLower=greeting.toLowerCase();
        System.out.println("Lower case of the string greeting is: "+greetingLower);


        //concatenate string (birleştirmek)
        String a=greeting.concat(" Java Webdriver Crash Course");
        System.out.println(a);


        //replace string
        String testPlan="Login Test";
        testPlan=testPlan.replace("Test", "Plan");
        System.out.println(testPlan);


        //get substring
        greeting=greeting.substring(0,5);
        System.out.println(greeting);


        //remove spaces in the beginning and end
        String country="      USA      ";
        System.out.println(("Country is "+country));
        System.out.println("Country is "+country.trim());


        //check the first occurrence of the specified character in a string
        String x="abcdef";
        char y='f';
        int location=x.indexOf(y);
        System.out.printf("The location of %s in %s is %d%n",y,x,location);


        //check the sequence of characters in a string
        String testCase="Login Test";
        String subString="Login";
        System.out.printf("Test case: %s contains %s: %b%n",testCase,subString,testCase.contains(subString) );
    }
}
