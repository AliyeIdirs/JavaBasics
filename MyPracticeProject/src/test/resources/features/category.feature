@UITest
Feature: Admin user can Manage Category From CubeCart User Interface

  In this feature, admin user can add and update category both from the CubeCart user interface

  Background:
    Given admin user login to the CubeCart application user interface

  @AddCategory
  Scenario: Admin user can add a new category from CubeCart UI
    Given user is on the Add Category page
    When user fills out the category information on the Add Category page and click on save button
    Then a new Category should be appeared in the categories list

  @UpdateCategory
  Scenario: Admin user can update the category from CubeCart UI
    Given user is on the categories page
    When user update the category info with id <1054> from the UI
    Then the category information should be updated successfully





