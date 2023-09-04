package regressionsuit.testngframework;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestNGCommandDemo {
    @Test
    public void runAClass(){
        TestListenerAdapter testListenerAdapter=new TestListenerAdapter();
        TestNG testNG=new TestNG();
        testNG.setTestClasses(new Class[]{TestNGDemo1.class, TestNGRunner2.class});
        testNG.addListener(testListenerAdapter);
        testNG.run();
    }
}
