@Leadall @regression
Feature:  Lead Functionality



@bulk
  Scenario: Create_bulk_Leads_TC04
    Given user should be on login page
    And user enters valid credentials
    And user need to click on new lead link and fill the mandatory fields and save
      | lastname |  company|
      | test1    | test1   |
      | test2    | test2   |
      | test3    | test3   |
    Then click on logout and close the browser

  @ab
  Scenario: Create_Leads_TC05
    Given user should be on login page
    And user enters valid credentials
    And user need to click on new lead link and enters the mandatory fields and save
    Then click on logout and close the browser
