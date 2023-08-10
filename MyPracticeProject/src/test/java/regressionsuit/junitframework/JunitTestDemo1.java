package regressionsuit.junitframework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class JunitTestDemo1 {
    @BeforeAll
    public static void setUp(){
        System.out.println("Before All run once before all tests");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("After All reun once after all tests");
    }

    @Test
    public void squareRootTest(){
        System.out.println("Testing a square root");
        Assert.assertTrue(Math.sqrt(9)==3);
    }
    @Test
    public void compareTwoString(){
        String s1="selenium";
        String s2="selenium";
        Assert.assertEquals(s1,s2);

    }
    @Test
    public void power(){
        System.out.println("Testing the power of a number");
        Assert.assertTrue(Math.pow(10,2)==100);
    }

}
