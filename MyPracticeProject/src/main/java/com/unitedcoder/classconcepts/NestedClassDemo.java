package com.unitedcoder.classconcepts;

public class NestedClassDemo {
    public static void main(String[] args) {
        NestedClassDemo nestedClassDemo=new NestedClassDemo();
        nestedClassDemo.sum(15,35);

        NestedClassDemo.InnerClass1 class1=new NestedClassDemo().new InnerClass1();
        class1.subtract(50,20);

        InnerClass2 class2=new InnerClass2();
        class2.multiply(5,3);
    }
    public void sum(int a,int b){
        System.out.println(a+b);
    }

    //non static inner class
    class InnerClass1{
        private int subtract(int a, int b){
            System.out.println(a-b);
            return a-b;
        }

    }

    //static inner class
    static class InnerClass2{
        private long multiply(int x, int y){
            System.out.println(x*y);
            return x*y;
        }

    }

}
class Test1{
    public static void main(String[] args) {
        NestedClassDemo nestedClassDemo=new NestedClassDemo();
        nestedClassDemo.sum(10,20);
    }

}
class Test2{

}
