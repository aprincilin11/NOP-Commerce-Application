Feature:Free CRM login feature

  @smoke
  Scenario: Free CRM Login Test Scenario

    Given User is already on Login page
    When Title of login page is Free CRM
    Then User enters username and password
    Then User clicks on login button
    And User is on homepage

@Regression
  Scenario: Free CRM name display Test
  Given User is already on homepage
  Then User checks on the name has displayed or not
  Then User quit the browser

# this is the test from 'freecrm' webpage by Naveen Automation labs