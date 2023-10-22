package regressionsuit.httpclientapi.dolkunteacherscode;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : user
 * @created : 17.10.2023,10:00
 * @Email :aliyeidiris@gmail.com
 **/


/**
 * Created by SeleniumMaster on 5/15/2017.
 */
public class ApiRequestBase {

    private final static String USER_AGENT = "Mozilla/5.0";

    public static ApiResponseWrapper Action(String payload, String ApiServiceUrl, int expectedResponseCode,
                                            HttpRequestType httpRequestType, String authTokenString) throws IOException {
        //define an api response wrapper object variable
        ApiResponseWrapper apiResponseWrapper = new ApiResponseWrapper();
        //define a string buffer object variable
        StringBuffer result = new StringBuffer();
        //create closable http client
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //create closable http response
        CloseableHttpResponse response = null;
        //define response code variable
        int responseCode;
        //define response time variable
        long responseTime;
        //define String Entity variable
        StringEntity stringEntity;
        //define stop watch
        StopWatch stopWatch = new StopWatch();
        //use switch case
        switch (httpRequestType) {
            case HTTPPOST:
                //define http post object
                HttpPost httpPost = new HttpPost(ApiServiceUrl);
                httpPost.setHeader("User-Agent", USER_AGENT);
                if (authTokenString.trim().length() > 1) {
                    httpPost.addHeader("Authorization", authTokenString);
                }
                stringEntity = new StringEntity(payload, ContentType.APPLICATION_JSON);
                stringEntity.setContentType("application/json");
                httpPost.setEntity(stringEntity);
                System.out.println("Action Parameters: ");
                System.out.println(payload);
                stopWatch.start();
                //send the http post request
                response = client.execute(httpPost);
                break;
            case HTTPGET:
                //define http get object
                HttpGet httpGet = new HttpGet(ApiServiceUrl);
                httpGet.setHeader("User-Agent", USER_AGENT);
                if (authTokenString.trim().length() > 1) {
                    httpGet.addHeader("Authorization", authTokenString);
                }
                stopWatch.start();
                //send http get request
                response = client.execute(httpGet);
                break;
            case HTTPDELETE:
                //define http delete object
                HttpDelete httpDelete = new HttpDelete(ApiServiceUrl);
                httpDelete.setHeader("User-Agent", USER_AGENT);
                if (authTokenString.trim().length() > 1) {
                    httpDelete.addHeader("Authorization", authTokenString);
                }
                stopWatch.start();
                //send delete request
                response = client.execute(httpDelete);
                break;
            case HTTPPUT:
                //define http put request object
                HttpPut httpPut = new HttpPut(ApiServiceUrl);
                httpPut.setHeader("User-Agent", USER_AGENT);
                if (authTokenString.trim().length() > 1) {
                    httpPut.addHeader("Authorization", authTokenString);
                }
                stringEntity = new StringEntity(payload, ContentType.APPLICATION_JSON);
                stringEntity.setContentType("application/json");
                //set the entity to update for the put request
                httpPut.setEntity(stringEntity);
                System.out.println("Action Parameters: ");
                System.out.println(payload);
                stopWatch.start();
                //send the put request
                response = client.execute(httpPut);
                break;
            default:
                System.out.printf("You need to provide a proper API call method");
                break;
        }
        try {
            System.out.println("Sending request to URL: " + ApiServiceUrl);
            System.out.println("Http Request Type: " + httpRequestType.name());
            //get the response code
            responseCode = response.getStatusLine().getStatusCode();
            //print out response code
            System.out.println("Response Code: " + responseCode);
            if (responseCode == expectedResponseCode) {
                //stop the watch (time clock)
                stopWatch.stop();
                //get the elapsed time for the request and response
                responseTime = stopWatch.getTime();
                //print out total time
                System.out.println("Response time: " + responseTime + "milliseconds");
                apiResponseWrapper.setResponseCode(responseCode);
                apiResponseWrapper.setResponseTime(responseTime);
                //to read the response content
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                System.out.println(result.toString());
                apiResponseWrapper.setResponseContent(result.toString());
            } else {
                //stop the timer
                stopWatch.stop();
                //get the elapsed time
                responseTime = stopWatch.getTime();
                //print out the response time
                System.out.println("Response time: " + responseTime + "milliseconds");
                //set the response code
                apiResponseWrapper.setResponseCode(responseCode);
                //set the response time
                apiResponseWrapper.setResponseTime(responseTime);
                //set the response error content
                BufferedReader errorMessage = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String temp = "";
                while ((temp = errorMessage.readLine()) != null) {
                    result.append(temp);
                }
                System.out.println("Error message : " + result.toString());
                //set the response string
                apiResponseWrapper.setResponseContent(result.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            response.close();
            client.close();
        }
        return apiResponseWrapper;
    }

}
