package regressionsuit.junitframework;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value= Parameterized.class)
public class JunitParameterizedDemo {
    @Parameterized.Parameter() //default value 0
    public int number;
    @Parameterized.Parameter(value=1)
    public int power;
    @Parameterized.Parameter(value=2)
    public int expectedPowerValue;
    @Parameterized.Parameters(name="{index}: testPower({0} power {1}) = {2}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {1,2,1},
            {2,2,4},
            {3,2,9},
            {4,2,16},
            {5,2,25}
        });
    }
    @Test
    public void testMathPowerCalculation(){
        Assertions.assertTrue(Math.pow(number,power)==expectedPowerValue);
    }

}
