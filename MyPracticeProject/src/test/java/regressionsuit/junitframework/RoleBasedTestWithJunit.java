package regressionsuit.junitframework;

import com.unitedcoder.cubecartautomation.BaseClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value= Parameterized.class)
public class RoleBasedTestWithJunit extends BaseClass {
@Parameterized.Parameter()
    public String userName;
@Parameterized.Parameter(value=1)
    public String password;
@Parameterized.Parameters(name="{index}: username={0}, password={1})")
    public static Collection<String[]> users(){
    return Arrays.asList(new String[][]{
            {"testautomation1", "automation123!"},
            {"testautomation2", "automation123!"}
    });
}
    @Test
    public void multipleLogin(){
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        Assertions.assertTrue(login(userName,password));
    }

}
