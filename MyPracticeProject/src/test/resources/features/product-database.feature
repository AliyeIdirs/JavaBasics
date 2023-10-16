Feature: Admin user should be able to view product information from the cc_CuebCart_inventory table

  Scenario: user should be able to get product info
    Given the user has read access to the cc_CubeCart_inventory table
    When the user query the cc_CubeCart_inventory table
    Then the user should see the product info