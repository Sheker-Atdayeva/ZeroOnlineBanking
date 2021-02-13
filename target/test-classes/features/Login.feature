@login
Feature: Only authorized users should be able to login

  Scenario: Authorized users should be able to login
    Given the user is on the login page
    When the user enters the user informations
    Then the user should be able to login
    And the "Account Summary" page should be displayed

#    Users with wrong username or wrong password should not be able to login. Users
#    with blank username or password should also not be able to login. When user tries
#    to login with invalid information, error message Login and/or password are wrong.
#    should be displayed.

  Scenario Outline: Users with wrong username or wrong password should not be able to login.
  Users with blank username or password should also not be able to login.
    Given the user is on the login page
    When the user logs in using "<username>" and "<password>"
    Then the user should not be able to login
    And the error message should be displayed
    Examples:
      | username | password |
      | user     | password |
      | username | pass     |
      | user     | pass     |
      |          | password |
      | username |          |
      |          |          |




