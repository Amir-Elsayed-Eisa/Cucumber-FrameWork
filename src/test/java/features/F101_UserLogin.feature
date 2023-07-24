Feature: User Login

  Scenario Outline: User Login Successfully
    Given User goes back to home page after registration
    When  User clicked on Login link and entered the data "<userEmail>", "<userPassword>"
    And User Login with his account done successfully
    Then User can Log out
    Examples:
      | userEmail  | userPassword |
      | a@fake.com | 111111       |