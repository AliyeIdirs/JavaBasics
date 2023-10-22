@ApiTest
Feature: An authorized user should be able to manage customers and products using CubeCart swagger api documentation

  Background:
    Given admin user has the authentication information to connect to the Api

  @CustomerApi
  Scenario: an authorized user should be able to get all customers
    Given a valid username and password
    When the user sends a get request to the customer end point
    Then the api should return 200 response code
    And the api should return more than one customer
  @ProductApi
  Scenario: an authorized user should be able to get all products
    Given a valid username and password
    When the user sends a get request to the product end point
    Then the api should return 200 response code
    And the api should return more than one product

@AddMultipleCustomer
  Scenario Outline: and authorized user should be able to add multiple customers
    Given customerPayload "<email>" "<title>" "<firstname>" "<lastname>" <country> "<phone>"  <status>  "<language>" "<ipaddress>" <registered>
    When the user sends the post request to the customer endpoint with the payload
    Then the api should return 200 response code and create a new customer
    Examples:
      | email           | title | firstname | lastname | country | phone      | status | language | ipaddress      | registered|
      | qw5@gmail.com   | Mr    | Adbusalam | Idris    | 0       | 2374532198 | 1      | en-GB    | 122.22.235.875 | 1          |
      | qw6@outlook.com | Miss  | Amangul   | Idris    | 0       | 2374532193 | 1      | en-GB    | 122.22.235.873 | 1          |

@AddMultipleCategory
  Scenario Outline: Admin user can create a new category from Api connection
    Given admin user connected to the Api
    When admin user fills out the "<categoryName>" and "<catDescription>"
    And admin user sends a post request to create a new category via the Api
    Then the response status code should be 200
    And a new category should be created successfully
    Examples:
      | categoryName  | catDescription                   |
      | Baby Stroller | This is a baby stroller category |
      | Kitchenware   | This is a kitchenware category   |

@UpdateCategory
  Scenario: Admin user update the category information through an Api connection
    Given admin user has a category id <1055> to be updated
    When admin user sends a put request to update the category with id <1055>
    Then the response status code should be 204
    And user verify the category <1055> updated successfully

