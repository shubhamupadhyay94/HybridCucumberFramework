#Feature: Validate store home page
#
#  Background: Launch the app url and be on homepage
#    Given I am on the Store home page
#
#  Scenario: Verify the store page title
#    When I verify the store home page details
#    Then I should be able to see page title as "STORE"
#
#  Scenario: Verify store page categories details
#    When I verify the store home page details
#    Then I should be able to see "CATEGORIES,Phones,Laptops,Monitors" tab
#
#  Scenario: As a App User, After clicking on monitors tab, I should be able to see few monitors
#    When I click on monitors tab
#    Then I should be able to see "Apple monitor 24,ASUS Full HD" monitor list
#
#  Scenario Outline: As a App User, I should be able to view different mobile
#    And I click on phones tab
#    When I click on different phone "<phone>"
#    Then I should be able to see the "<phone>" name and details on new tab
#    Examples:
#      | phone             |
#      | Nokia lumia 1520  |
#      | Samsung galaxy s6 |
#
#  Scenario Outline: As a App User, I should be able to see mobile details on new tab
#    And I click on phones tab
#    When I click on different phone "<phone>"
#    Then I should be able to see the <mobileName> and <mobilePrice> and <mobileDescription> details in next tab
#      | mobileName       | mobilePrice | mobileDescription                                                                                                   |
#      | Nokia lumia 1520 | 820         | The Nokia Lumia 1520 is powered by 2.2GHz quad-core Qualcomm Snapdragon 800 processor and it comes with 2GB of RAM. |
#    Examples:
#      | phone            |
#      | Nokia lumia 1520 |
#
#  Scenario: As a App User, I should be able to see laptop details with different attribute
#    When I click on laptop tab
#    Then I should be able to see the <laptopName> and <laptopPrice> and <laptopDescription> details on laptop tab
#      | laptopName   | laptopPrice | laptopDescription                                                                                                                                                                                                                                                                                           |
#      | Sony vaio i5 | 790         | Sony is so confident that the VAIO S is a superior ultraportable laptop that the company proudly compares the notebook to Apple's 13-inch MacBook Pro. And in a lot of ways this notebook is better, thanks to a lighter weight.                                                                            |
#      | Sony vaio i7 | 790         | REVIEW Sony is so confident that the VAIO S is a superior ultraportable laptop that the company proudly compares the notebook to Apple's 13-inch MacBook Pro. And in a lot of ways this notebook is better, thanks to a lighter weight, higher-resolution display, more storage space, and a Blu-ray drive. |
#      | MacBook air  | 700         | 1.6GHz dual-core Intel Core i5 (Turbo Boost up to 2.7GHz) with 3MB shared L3 cache Configurable to 2.2GHz dual-core Intel Core i7 (Turbo Boost up to 3.2GHz) with 4MB shared L3 cache.                                                                                                                      |
#
#
#
