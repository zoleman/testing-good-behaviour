Feature: Login
  As a user
  I want to log in to the site
  So I can place orders

  Background:
    Given I am on the login page

  @valid
  Scenario: Valid login shows the logout button
    When I log in with "asd@asd.com" and "asd123"
    Then I should see the logout button

  @invalid
  Scenario: Invalid credentials show error modal
    When I log in with "asd@qwe.com" and "asd123"
    Then I should see the invalid login modal

  @validation
  Scenario: Invalid email format shows error modal
    When I log in with "qwe" and "asd123"
    Then I should see the invalid login modal
