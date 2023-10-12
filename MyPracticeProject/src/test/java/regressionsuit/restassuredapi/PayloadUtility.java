package regressionsuit.restassuredapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PayloadUtility {
    public static String getCustomerPayload(CustomerPayload customerPayload) {
        String payload;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(customerPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }
    public static String getCategoryPayload(CategoryPayload categoryPayload){
        String payload;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(categoryPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }
    public static JsonNode updatePayload(String responseBody,String key,String newValue){
        ObjectMapper mapper=new ObjectMapper();
        JsonNode node= null;
        try {
            node = mapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonToken token=((ObjectNode)node).put(key,newValue).asToken();
        return node;
    }
}
