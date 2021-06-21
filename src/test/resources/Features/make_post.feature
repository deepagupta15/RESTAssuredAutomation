Feature: This feature is to make posts using the /posts API

  Scenario: Verify Post operation, User can create a social media post
    Given  A valid user performs POST operation for creating social media posts
    When I perform POST operation using "/posts/", for the specific user with the following data
    Then I should receive 200 status code for successful creation
    And I should receive an id for successful creation as 101
    And I should get the same body as posted