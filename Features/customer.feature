Feature: Customer

  Scenario: Add new Customer
    Given User launch on the chrome browser

    When User opens URL "https://demo.nopcommerce.com/login"
    And User enters Email as "aprincilin@gmail.com" and Password as "Yallmusic123"
    And Click on Login
    Then User can see Dashboard
    When User clicks on customers menu
    And User click on the Customers Menu Item
    And CLick on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on save button
    Then User can  see confirmation page "The new customer has been added successfully"
    And close browser


