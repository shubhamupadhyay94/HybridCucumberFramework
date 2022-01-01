Feature: External excel data test to verify mobile details

  Scenario Outline: As a App User, I should be able to see mobile details on new tab
    Given I am on the Store home page
    And I click on phones tab
    When I click on different phone "<phone>" with external data
    Then I should be able to see the <mobileName> and <mobilePrice> and <mobileDescription> details in next tab with external data
      | mobileName | mobilePrice | mobileDescription |
      | mobileName | mobilePrice | mobileDescription |
    Examples:
      | phone   |
      | phone_1 |