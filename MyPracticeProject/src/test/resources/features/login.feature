@UITest  @SmokeTest
Feature: Admin user login function

  Scenario: Admin user can login with valid credentials
    Given CubeCart login page opened
    When user enter valid username and valid password
    Then user login successfully