package com.unitedcoder.homework.basichomeworks;

public class Week5Day1 {
    public static void main (String[] args){
        String schoolName= "Marmara University\t";
        String schoolAddress ="Eğitim Mah. Fahrettin Gökay Cad. No.12 Kadıköy/ İstanbul\t";
        String zipCode= "34317\t";

        //1. Combine school name, address, and zip code together and store it with a String variable named "schoolFullAddress".
        String schoolFullAddress= schoolName.concat(schoolAddress).concat(zipCode);
        System.out.println(schoolFullAddress);

        //2. Print school name with all Capital letters.
        System.out.println(schoolName.toUpperCase());

        //3. Print school address with all lower case letters.
        System.out.println(schoolAddress.toLowerCase());

        //4. From schooFullAddress, print out only the zip code.
        System.out.println(schoolFullAddress.indexOf("3"));
        System.out.println(schoolFullAddress.lastIndexOf("7"));
        System.out.println(schoolFullAddress.substring(76,81));

        //5. Print out total length of the schoolFullAddress String variable.
        System.out.println(schoolFullAddress.length());

        //6. Print out the result If your school name equals to "University".
        System.out.println(schoolName.equals("University"));


        //7. Print out the result if your school name contains a char "S".
        System.out.println(schoolName.contains("S"));

        //8. Use String.format to print out your schools full address.
        System.out.printf("%s %s %s%n",schoolName,schoolAddress,zipCode);



    }
}
