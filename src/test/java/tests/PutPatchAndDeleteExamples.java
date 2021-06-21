package tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PutPatchAndDeleteExamples {
	
//	PUT	/posts/1
	
	
@Test	(enabled= false)
public void put_request()
{
	
	
//RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
//RequestSpecification request = RestAssured.given();

JSONObject request = new JSONObject();
request.put("postId", 1); 
request.put("id", 6);
request.put("name", "repellat");
request.put("email", "repellats@ole.me");
request.put("body", "laborum distinctio aperiam et ab ut");

System.out.println(request.toJSONString());

baseURI ="https://jsonplaceholder.typicode.com";

given()
.header("Content-Type", "application/json").
contentType(ContentType.JSON).
accept(ContentType.JSON).
body(request.toJSONString()).
when().put("/posts/1").then().statusCode(200).
log().all();

	}

@Test (enabled= false)
public void patch_request()
{
	
	
//RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
//RequestSpecification request = RestAssured.given();

JSONObject request = new JSONObject();
request.put("postId", 1); 
request.put("id", 6);
request.put("name", "repellat");
request.put("email", "repellats@ole.me");
request.put("body", "laborum distinctio aperiam et ab ut");

System.out.println(request.toJSONString());

baseURI ="https://jsonplaceholder.typicode.com";

given()
.header("Content-Type", "application/json").
contentType(ContentType.JSON).
accept(ContentType.JSON).
body(request.toJSONString()).
when().
patch("/posts/1").
then().
statusCode(200).
log().all();

}


@Test
public void delete_request()
{
	
	
//RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
//RequestSpecification request = RestAssured.given();

JSONObject request = new JSONObject();
request.put("postId", 1); 
request.put("id", 6);
request.put("name", "repellat");
request.put("email", "repellats@ole.me");
request.put("body", "laborum distinctio aperiam et ab ut");

System.out.println(request.toJSONString());

baseURI ="https://jsonplaceholder.typicode.com";

given()
.header("Content-Type", "application/json").
contentType(ContentType.JSON).
accept(ContentType.JSON).
body(request.toJSONString()).
when().
delete("/posts/1").
then().
statusCode(200).
log().all();

}
}
