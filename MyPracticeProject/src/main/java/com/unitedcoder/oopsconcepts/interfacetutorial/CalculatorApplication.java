package com.unitedcoder.oopsconcepts.interfacetutorial;



public class CalculatorApplication {
    public static void main(String[] args) {
        SimpleCalculator calculator= new Calculator(); //Calculator implements SimpleCalculator
        System.out.println(SimpleCalculator.version);
        System.out.println( calculator.addMultipleNumbers(3,5,9,15));
        System.out.println(calculator.addTwoNumbers(45,678));
        System.out.println(calculator.divideTwoNumbers(81,7));
        System.out.println(calculator.divideTwoNumbers(67,0));
        System.out.println(calculator.multiplyTwoNumber(5,8));

        IScientificCalculator scientificCalculator= new Calculator(); //Calculator also implements IScientificCalculator
        System.out.println(IScientificCalculator.version);
        System.out.println(  scientificCalculator.calculatePower(2,5));
        System.out.println(scientificCalculator.calculateAbsoluteValue(-98));
        System.out.println(scientificCalculator.calculateSquareRoot(49));
        System.out.println(scientificCalculator.minValue(543543543,546456546));

    }
}
