package com.unitedcoder.classconcepts.package2;

import com.unitedcoder.classconcepts.package1.Alpha;

public class AlphaSub extends Alpha{ //AlphaSub and Alpha is inheritance relationship
    public static void main(String[] args) {
        Alpha alpha= new Alpha();
        alpha.alphaVersion="2.1";
        AlphaSub alphaSub= new AlphaSub();
        alphaSub.age=50;
        alphaSub.getAge();
    }
}
