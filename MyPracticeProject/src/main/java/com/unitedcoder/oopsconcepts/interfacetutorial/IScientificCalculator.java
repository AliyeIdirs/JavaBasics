package com.unitedcoder.oopsconcepts.interfacetutorial;

public interface IScientificCalculator {
    String version="2.3";
    double calculatePower(int base, int power);
    double calculateSquareRoot(long l);
    double calculateAbsoluteValue(int x);
    int minValue(int m,int n);
}
