package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestsExamples {
	
		public void get_userslist()
	{
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
		System.out.println(response.getBody().asString());
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
@Test
	public void get_post()
	{

      RequestSpecification request = RestAssured.given();
      request.baseUri("https://jsonplaceholder.typicode.com");
      request.basePath("/posts");
		
      Response response = request.get();

      System.out.println(response.asString());
		
		
	}
	
	public void get_post_by_id()
	{

      RequestSpecification request = RestAssured.given();
      request.baseUri("https://jsonplaceholder.typicode.com");
      request.basePath("/posts/2");
		
      Response response = request.get();

      System.out.println(response.asString());
		
		
	}
	
	
	
	public void get_comment_by_id()
	{

      RequestSpecification request = RestAssured.given();
      request.baseUri("https://jsonplaceholder.typicode.com");
      request.basePath("/posts/3/comments");
		
      Response response = request.get();

      System.out.println(response.asString());
		
		
	}
	
	@Test
	public void get_comment_by_postid()
	{

      RequestSpecification request = RestAssured.given();
      request.baseUri("https://jsonplaceholder.typicode.com");
      request.basePath("/comments?postId=100");
      /*This API is not giving correct results as this is also displaying post other 100 post ID.*/
		
      Response response = request.get();

      System.out.println(response.asString());
		
	}
	

}
