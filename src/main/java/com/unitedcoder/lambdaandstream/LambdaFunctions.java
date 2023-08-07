package com.unitedcoder.lambdaandstream;

public interface LambdaFunctions {
    void read();

}

class Test{
    public static void main(String[] args) {
        LambdaFunctions functions=() -> System.out.println("I am reading book.");
        functions.read();
    }
}
