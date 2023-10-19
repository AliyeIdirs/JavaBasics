package regressionsuit.cucumberframework;

/**
 * @author : user
 * @created : 19.10.2023,10:40
 * @Email :aliyeidiris@gmail.com
 **/
public class ApiResponseHolder {
    private static int getResponseCode;
    private static int totalResponseSize;
    private static int postResponseCode;
    private static int customerId;

    public static int getCustomerId() {
        return customerId;
    }

    public static void setCustomerId(int customerId) {
        ApiResponseHolder.customerId = customerId;
    }

    public static int getPostResponseCode() {
        return postResponseCode;
    }

    public static void setPostResponseCode(int postResponseCode) {
        ApiResponseHolder.postResponseCode = postResponseCode;
    }

    public static int getGetResponseCode() {
        return getResponseCode;
    }

    public static void setGetResponseCode(int getResponseCode) {
        ApiResponseHolder.getResponseCode = getResponseCode;
    }

    public static int getTotalResponseSize() {
        return totalResponseSize;
    }

    public static void setTotalResponseSize(int totalResponseSize) {
        ApiResponseHolder.totalResponseSize = totalResponseSize;
    }
}
