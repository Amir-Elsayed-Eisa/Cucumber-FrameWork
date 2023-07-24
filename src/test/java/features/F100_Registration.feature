
Feature: User Registration
  Scenario Outline: User can Register
    Given Open home page and navigate to register page
    When User enters the data "<fName>", "<lName>", "<D>", "<M>", "<Y>", "<userEmail>", "<companyName>", "<userPassword>"
    Then Registration passed successfully
    Examples:
      | fName | lName | D | M | Y    | userEmail     | companyName   | userPassword |  |
      | Amir  | Eisa  | 1 | 2 | 1999 | a@fake.com    | I'm a student | 111111       |  |
      | Eisa  | Amir  | 2 | 1 | 1993 | s@example.com | I'm a student | 222222       |  |

  Scenario Outline: User Registration doesn't pass
    Given User clicked on register link again
    When User enters the same data again "<fName>", "<lName>", "<D>", "<M>", "<Y>", "<userEmail>", "<companyName>", "<userPassword>"
    Then System refuses to register the same email
    Examples:
      | fName | lName | D | M | Y    | userEmail  | companyName   | userPassword |  |
      | Amir  | Eisa  | 1 | 2 | 1999 | a@fake.com | I'm a student | 111111       |  |