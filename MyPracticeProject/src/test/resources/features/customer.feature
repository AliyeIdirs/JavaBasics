@CustomerFeature @UITest
Feature: Admin user can manage customers in the CubeCart Application

  @AddCustomer
  Scenario: Admin user can add a new customer
    Given user is on the customer list page
    When user fills customer info
    Then new customer should be created

    @UpdateCustomer
  Scenario: Admin user update an existing customer
    Given user is on the customer list page
    When user update the customer info
    Then user verify the customer info is updated