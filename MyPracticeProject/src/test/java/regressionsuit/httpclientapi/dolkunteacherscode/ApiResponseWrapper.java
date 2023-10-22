package regressionsuit.httpclientapi.dolkunteacherscode;

/**
 * @author : user
 * @created : 17.10.2023,09:59
 * @Email :aliyeidiris@gmail.com
 **/
public class ApiResponseWrapper {
    private long responseTime;
    private int responseCode;
    private String responseContent;

    public ApiResponseWrapper() {
    }

    public ApiResponseWrapper(long responseTime, int responseCode, String responseContent) {
        this.responseTime = responseTime;
        this.responseCode = responseCode;
        this.responseContent = responseContent;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}
