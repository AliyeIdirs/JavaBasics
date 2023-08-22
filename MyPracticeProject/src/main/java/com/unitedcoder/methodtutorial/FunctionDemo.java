package com.unitedcoder.methodtutorial;

public class FunctionDemo {
    //void function does not return any value
    public void printInfo(){
        System.out.println("Hello, Selenium Master");
        System.out.println("Hello, This is test 1");
    }

    //return a value
    public int getArea(int length, int width){
        return length*width;
    }

    //return a class

    //firstly define a Person class
    class Person{
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName){
            this.firstName= firstName;
            this.lastName= lastName;
        }
        public String getFirstName(){
            return firstName;
        }
        public void setFirstName(String firstName){
            this.firstName= firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public void setLastName(String lastName){
            this.lastName= lastName;
        }

    }

    //define a method that returns the class Person
    public Person getPerson(String firstname, String lastname){ //name of the method
        Person p= new Person(firstname,lastname);
        System.out.println("First Name: " +p.getFirstName());
        System.out.println("Last Name: "+p.getLastName());
        return new Person(firstname,lastname);
    }

    public static void main(String[] args) {
        FunctionDemo f= new FunctionDemo();
        f.printInfo();
        int recAreaValue=f.getArea(5,6);
        System.out.println("Rectangle area is: "+recAreaValue);
        Person p1=f.getPerson("Selenium", "Master");
        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());
    }
}
