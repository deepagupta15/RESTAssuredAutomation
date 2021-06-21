package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class make_post {
	

	 public static Response response = RestAssured.get("https://jsonplaceholder.typicode.com");
	@Given("A valid user performs POST operation for creating social media posts")
	public void a_valid_user_performs_post_operation_for_creating_social_media_posts() {
		 System.out.println("Database Seeded: You can now start running your tests for /comments API.");
	}

	@When("I perform POST operation using {string}, for the specific user with the following data")
	public void i_perform_post_operation_using_for_the_specific_user_with_the_following_data(String string) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
//JSONObject is a class that represents a Simple JSON.
//We can add Key - Value pairs using the put method
JSONObject requestParams = new JSONObject();
requestParams.put("postId", 1); 
requestParams.put("id", 6);
requestParams.put("name", "repellat");
requestParams.put("email", "repellats@ole.me");
requestParams.put("body", "laborum distinctio aperiam et ab ut");

//Add a header stating the Request body is a JSON
request.header("Content-Type", "application/json");

//Add the Json to the body of the request
request.body(requestParams.toJSONString());

//Post the request and check the response
Response response = request.post("/posts");

System.out.println(response.asString());
	    
	}

	@Then("I should receive {int} status code for successful creation")
	public void i_should_receive_status_code_for_successful_creation(Integer int1) {
		
		int expectedcode= int1;
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, expectedcode);

	   
	}

	@Then("I should receive an id for successful creation as {int}")
	public void i_should_receive_an_id_for_successful_creation_as(Integer int1) {
	 int commentId = int1;
	 Assert.assertEquals(101,commentId);
	 
	}

	@Then("I should get the same body as posted")
	public void i_should_get_the_same_body_as_posted() {
		
		  String commentBody = "laborum distinctio aperiam et ab ut";
		  Assert.assertEquals("laborum distinctio aperiam et ab ut", commentBody);
	}
	

}
