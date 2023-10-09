@AmazonTest
Feature: Login page feature

  Background: User is Logged In
    Given I navigate to the login page
    When I submit username and password
    Then user is on login page

  Scenario: Login page title
    When user is on login page
    #When user gets the title of the page
    Then page title should be "Amazon.in"
