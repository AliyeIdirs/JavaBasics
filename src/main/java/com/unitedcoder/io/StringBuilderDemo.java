package com.unitedcoder.io;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("This is string builder example").append("\n");
        stringBuilder.append("line 1\n");
        stringBuilder.append("line 2\n");
        stringBuilder.append("line 3\n");
        stringBuilder.append("line 4\n");
        stringBuilder.append("Final line\n");
        System.out.println(stringBuilder.toString());
        int[] myNumbers=new int[]{10,15,13,14,35,30,34,40,50};
        for(int i:myNumbers)
        stringBuilder.append(i).append("\n");
        System.out.println(stringBuilder.toString());

    }
}
