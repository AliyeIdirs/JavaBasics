package com.unitedcoder.hackerrank;

import java.util.Scanner;

public class LexicographicalSubstring {
    public static String getSmallestAndLargest(String s, int k){
        //https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
        //Given a string,s , and an integer,k , complete the function so that it finds the lexicographically smallest and largest substrings of length k.
        String smallest="";
        String largest="";
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest=largest=s.substring(0,k);

        for(int i=1; i<s.length()-k+1; i++){  //s.length()-k+1  is the number of substring of s
            String substr=s.substring(i,i+k);
            if(smallest.compareTo(substr)>0)
                smallest=substr;
            if(largest.compareTo(substr)<0)
                largest=substr;
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        int k=scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s,k));
    }
}
