package com.unitedcoder.datatypes;

public class StringDemo1 {
    public static void main(String[] args) {
        //Non Primitive data
        String name="Alim"; //String literal
        String name1="Alim";
        System.out.println(name==name1);
        //not: literal olarak değer atadığımızda variable name farklı olsa da değeri aynıdır.

        String s1= "Aynur"; //String Object
        String s2= "Aynur";
        System.out.println(s1==s2);
        //not: Object olarak değer atadığımızda variable name farklı ancak değeri aynı olsa bile eşit değildir.

        //String index and length
        String city="Amsterdam";
        String country="Netherland";
        String course="Java Selenium Test Automation";
        String space=" ";
        int l= city.length();
        System.out.println(l);
        int i1=country.indexOf("h");
        System.out.println(i1);
        System.out.println("Index of first e:"+country.indexOf("e"));
        System.out.println("Index of last e:"+country.lastIndexOf("e"));

        //upper case lower case ---Java is case sensitive
        System.out.println(city.toUpperCase());
        System.out.println(country.toLowerCase());

        //replace
        course=course.replace("Java","Python");
        System.out.println(course);
        String date="03-09-2022"; //replace to 03/09/2022
        date=date.replace("-","/");
        System.out.println(date);

        String value="2345, 9876"; //replace to 2345.9876
        value=value.replace(",",".").replace(" ","");
        System.out.println(value);

        String result="About 18.760.000.000 results";

        //sub string
        System.out.println(value.substring(1,5)); //includes begin index but excludes end index
        int beginIndex=result.indexOf("1");
        int endIndex=result.lastIndexOf("0");
        System.out.println("Begin Index:" +beginIndex);
        System.out.println("End Index: "+endIndex);
        System.out.println(result.substring(6,20));

        //compare two String
        String m1="Java";
        String m2="java";
        System.out.println(m1.equals(m2));
        System.out.println(m1.equalsIgnoreCase(m2));

        //String concatenation



    }
}
