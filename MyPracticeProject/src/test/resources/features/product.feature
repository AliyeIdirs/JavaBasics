@RegressionTest @ProductFeature
Feature: Admin user can manage products
  an an admin, the user should be able to add, update or delete products

  @AddProduct
  Scenario: admin user can add a new product
    Given user is on the dashboard page
    When the user fills out a new product form
    Then a new product should be created

  @DeleteProduct
  Scenario: admin user can delete an existing product
    Given user is on the dashboard page
    When the user tries to delete an existing product
    Then the product should be deleted
