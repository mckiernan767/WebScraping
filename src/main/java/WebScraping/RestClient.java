/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Eoin
 */
public class RestClient {
    
    final String api = "https://api.knack.com/v1/objects";
    
    String postProgram(Program program) throws Exception{
        return sendPost(program,"/object_1/records");
    }
    
    String postSubProgram(SubProgram subProgram) throws Exception{
        return sendPost(subProgram, "/object_2/records");
    }
    
    String postPart(Part part) throws Exception{
        return sendPost(part, "/object_3/records");
    }
    
    private String sendPost(Object o, String url) throws Exception {
     HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 
     
     ObjectMapper mapper = new ObjectMapper();

      String json = mapper.writeValueAsString(o);
        System.out.println("ResultingJSONstring = " + json);
        
StringEntity entity = new StringEntity(json);
String id ="";
try {

    HttpPost request = new HttpPost(api + url);
    //StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
    request.addHeader("content-type", "application/json");
    request.addHeader("X-Knack-REST-API-KEY", "857acc10-f29f-11e9-a05e-c5d1053cd361");
    request.addHeader("X-Knack-Application-Id", "5da73985298a0b0015e9fb71");
    request.setEntity(entity);
    HttpResponse response = httpClient.execute(request);

    HttpEntity ent = response.getEntity();
    String responseString = EntityUtils.toString(ent, "UTF-8");
    
    final ObjectNode node = new ObjectMapper().readValue(responseString, ObjectNode.class);

 //System.out.println("node = " + node.get("id"));
    id = node.get("id").toString().replaceAll("\"","");
    
//if (node.has("id")) {
//    System.out.println("id: " + node.get("id"));
//}    
    //System.out.println("Response = " + responseString);

}catch (Exception ex) {

    //handle exception here

}
    return id;
      }
}
