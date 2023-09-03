package regressionsuit.testngframework;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserIdValidatorTest {
    private DynamicUserIdValidator dynamicUserIdValidator;
    @BeforeClass
    public void initData(){
        dynamicUserIdValidator=new DynamicUserIdValidator();
    }
    //Test valid user ids
    @Test(dataProvider = "validUserIds")
    public void validUserIdTest(String[] userIds){
        for( String eachUserId:userIds){
            boolean valid = dynamicUserIdValidator.validate(eachUserId);
            Assert.assertTrue(valid);
            System.out.println(eachUserId+" ," +valid);
        }
        System.out.println("Valid User Id Validation Test Completed");
    }
    //Test invalid user ids
    @Test(dataProvider = "invalidUserIds",dependsOnMethods = "validUserIdTest")
    public void invalidUserIdTest(String[] userIds){
        for (String eachUserId:userIds){
            boolean valid= dynamicUserIdValidator.validate(eachUserId);
            Assert.assertEquals(valid,false);
            System.out.println(eachUserId + " , " + valid);
        }
        System.out.println("Invalid User Id Validation Test Completed");
    }

    //valid user id sample data
    @DataProvider
    public Object[][] validUserIds(){
        return new Object[][] {{new String []{
                "userid_4_23_2005_85083","userid_11_13_2000_31277", "userid_8_27_2014_83046",
                "userid_12_24_2006_63060", "userid_9_8_2000_56086", "userid_7_7_2005_30338",
                "userid_10_15_2006_54936","userid_9_14_2014_65261", "userid_1_30_2010_64475",
                "userid_2_1_2004_58032", "userid_8_4_2010_26849","userid_10_19_2012_23906",
                "userid_5_29_2004_60408","userid_6_6_2011_82682", "userid_6_13_2005_32055",
                "userid_12_17_2013_76612", "userid_3_22_2001_41024","userid_12_3_2010_51135",
                "userid_4_13_2002_50477","userid_9_25_2014_10160", "userid_5_9_2009_18337",
                "userid_4_8_2002_42764", "userid_5_29_2003_37048","userid_12_16_2002_97276"
        }}};
    }

    //invalid user id sample data
    @DataProvider
    public Object[][] invalidUserIds(){
        return new Object[][]{{new String[]{
                "userid_108_28_2014_5815","userid_104_8_2011_4572", "userid_101_12_2001_4319",
                "userid_114_10_2012_2718", "userid_112_11_2011_6250","userid_118_7_2000_9750",
                "userid_117_11_2007_4355","userid_108_12_2005_3010", "userid_113_21_2013_5157",
                "userid_112_7_2013_7582", "userid_103_15_2006_3962","userid_117_13_2011_4727",
                "userid_109_5_2001_7123","userid_103_12_2009_5901", "userid_111_19_2002_9712",
                "userid_119_1_2008_5702", "userid_105_12_2002_6523","userid_100_25_2000_1151",
                "userid_107_5_2006_4363", "userid_108_1_2010_5425", "userid_113_12_2011_6270",
                "userid_108_26_2000_7718", "userid_120_3_2003_3281","userid_118_29_2003_4848"
        }}};
    }
    @AfterClass
    public void afterClass(){
    }

}
