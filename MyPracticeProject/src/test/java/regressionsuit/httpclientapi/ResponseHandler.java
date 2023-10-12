package regressionsuit.httpclientapi;

import io.restassured.path.json.JsonPath;

public class ResponseHandler {
    private int responseCode;
    private String responseContent;
    private long responseTime;
    private JsonPath jsonPath;

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

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public JsonPath getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(JsonPath jsonPath) {
        this.jsonPath = jsonPath;
    }
}
