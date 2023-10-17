package regressionsuit.httpclientapi;

import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import regressionsuit.testngproject.DataBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

public class RequestHandler {
    DataBase db = new DataBase();
    String userName;
    String password;
    String apiUrl;
    int port;
    StopWatch stopWatch;

    public RequestHandler() {
        userName = db.api_username;
        password = db.api_password;
        apiUrl = db.api_host;
        port = db.api_port;
    }

    public CloseableHttpClient client() {
        AuthenticationProvider authenticationProvider = new AuthenticationProvider();
        return HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.getCredentials(userName, password))
                .build();
    }

    public ResponseHandler getRequest(String endpoint) {
        ResponseHandler responseHandler = new ResponseHandler();
        //create a Get request
        HttpGet httpGet = new HttpGet(apiUrl + ":" + port + "/" + endpoint);
        stopWatch = new StopWatch();
        stopWatch.start();
        CloseableHttpResponse response = null;
        try {
            response = client().execute(httpGet);
            //get response code and response time
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 0) {
                responseHandler.setResponseCode(statusCode);
                responseHandler.setResponseTime(stopWatch.getTime(TimeUnit.MILLISECONDS));
            }
            //get response content
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                JsonPath jsonPath = new JsonPath(inputStream);
                responseHandler.setJsonPath(jsonPath);
                responseHandler.setResponseContent(jsonPath.prettify());
            }
            stopWatch.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseHandler;
    }

    public ResponseHandler postRequest(String endpoint, String payload) {
        ResponseHandler responseHandler = new ResponseHandler();
        HttpPost httpPost = new HttpPost(apiUrl + ":" + port + "/" + endpoint);
        stopWatch = new StopWatch();
        stopWatch.start();
        httpPost.setHeader("Content-Type", "application/json");
        try {
            httpPost.setEntity(new StringEntity(payload));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        CloseableHttpResponse response = null;
        try {
            response = client().execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 0) {
                responseHandler.setResponseCode(statusCode);
                responseHandler.setResponseTime(stopWatch.getTime(TimeUnit.MILLISECONDS));
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream inputStream = entity.getContent();
                    JsonPath jsonPath = new JsonPath(inputStream);
                    responseHandler.setJsonPath(jsonPath);
                    responseHandler.setResponseContent(jsonPath.prettify());
                }
            }
            stopWatch.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseHandler;
    }

    public ResponseHandler putRequest(String endpoint, String payload) {
        ResponseHandler responseHandler = new ResponseHandler();
        stopWatch = new StopWatch();
        stopWatch.start();
        HttpPut httpPut = new HttpPut(apiUrl + ":" + port + "/" + endpoint);
        httpPut.setHeader("Content-Type", "application/json");
        try {
            httpPut.setEntity(new StringEntity(payload));
            CloseableHttpResponse response = null;
            response = client().execute(httpPut);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 0) {
                responseHandler.setResponseCode(statusCode);
                responseHandler.setResponseTime(stopWatch.getTime(TimeUnit.MILLISECONDS));
            }
            stopWatch.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseHandler;
    }

    public ResponseHandler getAllInfo(String userName, String password, String url, int port, String endPoint) {
        ResponseHandler responseHandler = new ResponseHandler();
        AuthenticationProvider authenticationProvider = new AuthenticationProvider();

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(authenticationProvider.getCredentials(userName, password))
                .build();

        //create get request
        HttpGet httpGet = new HttpGet(url + ":" + port + "/" + endPoint);
        StopWatch stopWatch = new StopWatch();
        System.err.println(stopWatch);
        //get the response;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 0) {
                responseHandler.setResponseCode(statusCode);
                responseHandler.setResponseTime(stopWatch.getTime(TimeUnit.MILLISECONDS));
            }
            //response Body
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                JsonPath jsonPath = new JsonPath(inputStream);
                responseHandler.setResponseContent(jsonPath.prettify());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseHandler;
    }
}
