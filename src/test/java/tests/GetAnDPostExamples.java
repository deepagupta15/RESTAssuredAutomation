package tests;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAnDPostExamples {
	
	@Test
	public void testGet()
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("postId", 1);
//		map.put("id", 6);
//		map.put("name", "repellat");
//		map.put("email", "repellats@ole.me");
//		map.put("body", "laborum distinctio aperiam et ab ut");
//		System.out.println(map);
		
//		JSONObject request = new JSONObject(map);
//		
//		request.put("postId", 1);
//		request.put("id", 6);
//		request.put("name", "repellat");
//		request.put("email", "repellats@ole.me");
//		request.put("body", "laborum distinctio aperiam et ab ut");
//		
//		System.out.println(request.toJSONString());
//		
//		RequestSpecification requestspec = RestAssured.given();
//	    requestspec.baseUri("https://jsonplaceholder.typicode.com");
//	    requestspec.basePath("/posts");
//	    
//	    Response responseP = requestspec.post();
		
		
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
// JSONObject is a class that represents a Simple JSON.
// We can add Key - Value pairs using the put method
JSONObject requestParams = new JSONObject();
requestParams.put("postId", 1); 
requestParams.put("id", 6);
requestParams.put("name", "repellat");
requestParams.put("email", "repellats@ole.me");
requestParams.put("body", "laborum distinctio aperiam et ab ut");

// Add a header stating the Request body is a JSON
request.header("Content-Type", "application/json");
 
// Add the Json to the body of the request
request.body(requestParams.toJSONString());
 
// Post the request and check the response
Response response = request.post("/posts");

int statusCode = response.getStatusCode();
System.out.println(statusCode);

Assert.assertEquals(statusCode, 201);
String successCode = response.jsonPath().get("SuccessCode");
Assert.assertEquals( null, successCode);
System.out.println(successCode);

System.out.println(response.asString());
	}
	

}
