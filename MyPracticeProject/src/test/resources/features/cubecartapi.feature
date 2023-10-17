@ApiTest
Feature: An authorized user should be able to manage customers and products using CubeCart swagger api documentation

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

  Scenario Outline: and authorized user should be able to add multiple customers
    Given "<email>" and "<title>" and "<firstname>" and "<lastname>" and "<country>" and "<phone>" and "<status>" and "<language>" and "<ipaddress>" and "<registered>"
    When the user sends the post request to the customer endpoint with the payload
    Then the api should return 200 response code and create a new customer
    Examples:
      | email           | title | firstname | lastname | country | phone      | status | language | ipaddress      | registered
      | qw1@gmail.com   | Mr    | Adbusalam | Idris    | 0       | 2374532198 | 1      | en-GB    | 122.22.235.875 | 1          |
      | qw2@outlook.com | Miss  | Amangul   | Idris    | 0       | 2374532193 | 1      | en-GB    | 122.22.235.873 | 1          |

