@DatabaseTest
Feature: Admin user should be able to view information from the i5751295_cc1 database

    @GetProduct
  Scenario: user should be able to get product info
      Given the user has read access to the cc_CubeCart_inventory table
    When the user query the cc_CubeCart_inventory table
    Then the user should see the product info

  @GetCategory
  Scenario: Admin user can get the category information via the database connection
    Given the user has read access to the cc_CubeCart_category table
    When user query to get the category information with id 1054
    Then user should be able to see the category information in the table
