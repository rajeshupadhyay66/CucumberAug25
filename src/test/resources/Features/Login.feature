@loginAll @abc @regression
Feature: login functionality

  Background:
    Given user should be on login page

    @valid @smoke @regression @ab
  Scenario: valid_login_TC01
    When user enters valid credentials
    Then user should navigated to home page
    And user can see the logout option


    @Invalid @sanity @regression @ab
  Scenario: Invalid_login_TC02
    When user enters invalid credentials
    Then user should navigated to login page
    And user can see the error message


  @datadriven @sanity @regression
  Scenario Outline: Invalid_login_with_multiset_data_TC03
    When user enters invalid credentials userid as "<username>" and password as "<password>"
    Then user should navigated to login page
    And user can see the error message
    And close browser
   Examples:
     | username | password |
     | admin1   | test1    |
     | admin2   | test2    |
     | admin3   | test3    |




