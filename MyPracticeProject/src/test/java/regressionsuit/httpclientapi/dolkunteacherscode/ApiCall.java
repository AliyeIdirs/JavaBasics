package regressionsuit.httpclientapi.dolkunteacherscode;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author : user
 * @created : 17.10.2023,10:08
 * @Email :aliyeidiris@gmail.com
 **/
public class ApiCall {
    private static String apiUrl = "http://api.openweathermap.org/data/2.5/weather";
    private static String apiKey = "70926ddfd37fdf454548b8db13695995";

    public static void main(String[] args) {
        getWeatherDataByCityName("London", "uk");
    }

    public static JSONObject getWeatherDataByCityName(String cityName, String countryName) {
        JSONObject payload = new JSONObject();
        String url = apiUrl + "?q=" + cityName + "," + countryName + "&APPID=" + apiKey;
        ApiResponseWrapper response = new ApiResponseWrapper();
        try {
            response = ApiRequestBase.Action(payload.toString(), url, 200, HttpRequestType.HTTPGET, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        JSONObject weatherResponseDataObject = new JSONObject();
        try {
            weatherResponseDataObject = (JSONObject) parser.parse(response.getResponseContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String cityNameInResponse = (String) weatherResponseDataObject.get("name");
        long codInResponse =(Long) weatherResponseDataObject.get("cod");
        System.out.println("City name in Response: " + cityNameInResponse + " Response Code: " + codInResponse);
        JSONArray weatherObject = (JSONArray) weatherResponseDataObject.get("weather");
        System.out.println("Number of weather object: " + weatherObject.size());
        Iterator i = weatherObject.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            String weatherMain = (String) innerObj.get("main");
            String weatherDescription = (String) innerObj.get("description");
            System.out.println("Weather main: " + weatherMain);
            System.out.println("Weather description: " + weatherDescription);

        }
        return weatherResponseDataObject;
    }
}
