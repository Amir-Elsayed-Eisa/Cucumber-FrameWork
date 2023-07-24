Feature: User Account for changing password
 Scenario Outline: User visit his Account to change password
    Given User Login with data "<userEmail>", "<userPassword>"
   When User visit his account to change password
   And User clicks on change password and enters the data "<userPassword>", "<newPassword>"
   Then User has changed the password successfully and can log out
   Examples:
     | userEmail  | userPassword | newPassword |
     | a@fake.com | 111111       | 222222      |