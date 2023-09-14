package regressionsuit.testngframework;


import com.github.javafaker.Faker;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNGDemo2 {
    @Test(invocationCount = 2,invocationTimeOut = 10)
    public void test1(){
        System.out.println("test1");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue("Test".length()>2);
    }
    @Test(timeOut = 3)
    public void test2(){
        System.out.println("Test 2");
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(10,10);
    }
    @Test
    public void anyTest(){
    }
}
