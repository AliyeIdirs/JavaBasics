@MultiBrowserTest
Feature: Admin user should be able to login the system with different browsers

  Scenario Outline: on the login page, admin user should be able to login the system using multiple browsers
    Given a valid username and password for login
    When when the user enter username and password on the login page and clicks on the login button on the "<browser>"
    Then the user should see the admin dashboard page

    Examples:
    |browser|
    |Chrome |
    |Safari |
