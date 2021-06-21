Feature: This feature is to make comments on social media posts

  Scenario: Verify Post operation, User can comment on a social media post
    Given  A valid user performs POST operation for creating social media comments posts
    When I perform POST operation to write a comment on particular post
    Then I should receive 200 status code for successful creation of comment
    And I should receive an id for successful comment creation as 101
    And I should get the same body as posted in the comment

  Scenario: Verify Post operation, Invalid User can't comment on a social media post
    Given  An invalid user performs POST operation for creating social media comments posts
    When I perform POST operation to write a comment on particular post
    Then I should receive a bad request error