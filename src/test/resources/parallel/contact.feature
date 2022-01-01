#Feature: : Share your contact details and query to support team
#
#  Background: Launch the app url and be on homepage
#    Given I am on the Store home page
#    And I click on contact tab
#    And I see new contact message form
#
#  Scenario: As a App User, I should be able to send contact query or message to support team
#    And i enter contact details "abc@gmail.com,Satyam sharma,I need latest offer details avialble in your store"
#    When I submit on send message button
#    Then I should get contact message submitted alert pop up with message "Thanks for the message!!"
#
#  Scenario: As a App User, I should be able to cancel contact message
#    And i enter contact details "abc@gmail.com,Satyam sharma,I need latest offer details avialble in your store"
#    When I click on cancel submit message
#    Then Contact message popup should be closed
#    And I should be able to see page title as "STORETM"