package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.annotations.Test;

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
                String a="/Users/user/Documents/Desktop Pics/image-from-rawpixel-id-3814725-jpeg.jpg";
                String c=(a.split("/"))[a.split("/").length-1];

        System.out.println(c);
    }
}
