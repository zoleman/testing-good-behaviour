Feature: User registration

  Scenario: Register a new user successfully
    Given I am on the registration page
    When I register a new user with valid data
    Then I should be redirected to the login page

  Scenario: Register with faulty email
    Given I am on the registration page
    When I try to register with a faulty email
    Then I should stay on the register page

  Scenario: Register with an existing email
    Given I am on the registration page
    When I try to register with an existing email
    Then I should see an error message about duplicate email

