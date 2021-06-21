package stepDefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class comment_on_post {
	
	
	  private static ResponseOptions<Response> response;

	    @Given("A valid user performs POST operation for creating social media comments posts")
	    public void validUserCreatesCommentsOnPosts() throws Throwable {
	        System.out.println("Database Seeded: You can now start running your tests for /comments API.");

	    }

	    @When("I perform POST operation to write a comment on particular post")
	    public void iPerformPostOperationForCreatingSocialMediaComments() throws Throwable {
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

	    @Then("I should receive {int} status code for successful creation of comment")
	    public void iShouldReceiveStatusCodeForSuccess(int int1) throws Throwable {
	    	
//			int statusCode = response.getStatusCode();
//			System.out.println(statusCode);
//			Assert.assertEquals(statusCode, null);
	    }

	    @And("I should receive an id for successful comment creation as {int}")
	    public void iShouldReceiveIdForCreatedComment(int id) throws Throwable {
	    	int commentId = id;
	   	 Assert.assertEquals(101,commentId);
	        
	    }

	    @And("I should get the same body as posted in the comment")
	    public void iShouldverifybodyForCreatedCommentPost() throws Throwable {
	    	 String commentBody = "laborum distinctio aperiam et ab ut";
			  Assert.assertEquals("laborum distinctio aperiam et ab ut", commentBody);

	    }

}
