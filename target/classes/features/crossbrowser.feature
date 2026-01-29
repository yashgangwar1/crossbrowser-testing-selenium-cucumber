#Author: your.email@your.domain.com

Feature: Cross browser check

  Scenario: Test Google on 3 browsers
    When I open google on chrome edge and firefox
    Then I print the status of all browsers
