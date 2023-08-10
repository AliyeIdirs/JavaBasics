package regressionsuit.junitframework;

import org.junit.jupiter.api.*;

public class JunitTestDemo1 {
    @BeforeAll
    public static void setUp(){
        System.out.println("BeforeClass run once before all tests");
    }
    @BeforeEach
    public  void start(){
        System.out.println("Test started.");
    }
    @AfterEach
    public  void end(){
        System.out.println("Test ended.");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("AfterClass run once after all tests");
    }

    @Test
    public void squareRootTest(){
        System.out.println("Testing a square root");
        Assertions.assertTrue(Math.sqrt(9)==3);
    }
    @Disabled
    @Test
    public void compareTwoString(){
        String s1="selenium";
        String s2="selenium";
        Assertions.assertEquals(s1,s2);
        System.out.println("Testing two strings");

    }
    @RepeatedTest(3)
    public void power(){
        System.out.println("Testing the power of a number");
        Assertions.assertTrue(Math.pow(10,2)==100);
    }

}
