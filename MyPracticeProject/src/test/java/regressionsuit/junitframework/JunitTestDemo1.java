package regressionsuit.junitframework;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import regressionsuit.week16junitproject.FunctionLibrary;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
@Disabled
    @Test
    public void squareRootTest(){
        System.out.println("Testing a square root");
        Assertions.assertTrue(Math.sqrt(9)==3);
    }
    @Test
    @Timeout(10)
    public void timeoutTest(){
        long startTime;
        long endTime=0;
        long elapseTime;
        startTime=new Date().getTime();
        System.out.println("Start time: "+startTime);
        for(int i=0; i<100000; i++){
            endTime=new Date().getTime();
        }
        System.out.println("End time: "+endTime);
        elapseTime=endTime-startTime;
        System.out.println(elapseTime);
        Assertions.assertEquals(10,elapseTime);
    }
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
    @Test
    public void test(){
        /*Date startDate=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("28-8-2023");
        System.out.println(dateFormat.format(startDate));
        Date endDate=new Date();*/
        String randomTime=String.valueOf(Faker.instance().date().future(365,TimeUnit.DAYS));
        String[] timeContent=randomTime.split(" ");
        String liveDate=timeContent[2]+" "+timeContent[1]+" "+timeContent[5]+" "+timeContent[3];
        System.out.println(liveDate);

    }

}
