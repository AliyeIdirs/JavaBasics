package regressionsuit.testngframework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicUserIdValidator {
    private Pattern pattern;
    private Matcher matcher;

    //sample user id: userId_03_29_2014_34852
    private static final String userIdPattern="userid_[0-9]{1,2}_[0-9]{1,2}_[0-9]{4}_[0-9]{5}";
    public DynamicUserIdValidator(){
        pattern=Pattern.compile(userIdPattern);
    }
    public boolean validate(final String userId){
        matcher=pattern.matcher(userId);
        return matcher.matches();
    }
}
