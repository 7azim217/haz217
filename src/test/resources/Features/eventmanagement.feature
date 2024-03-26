Feature: Event Management
  
  Event Management should be quick and easy

  Scenario: Approval of an event
    
    An event that should be added in the event Calendar

    Given I am logged in as admin
    When I chose to approve a reserved event with complete details
    Then I should see a confirmation message that the event details have been successfully added to the event Calendar
    And the event should display in event Calendar

  Scenario: Reject  an event
    
    An event Rejected by the admin

    Given I am logged in as admin
    When I chose to Reject a reserved event
    Then A message should be sent to the customer that his request has been rejected via email

  Scenario: Approval of a co_user Ready package
    An Ready package that should be added in the Ready package list

    Given I am logged in as admin
    When I chose to approve a Ready package requist with complete details
    Then I should see a confirmation message that the Ready package have been successfully added to the Ready package list
    And the Ready package should display in Ready package list

  Scenario: Reject a co_user Ready package
    
    An Ready package Rejected by the admin

    Given I am logged in as admin
    When I chose to Reject a Ready package requist
    Then A message should be sent to the co_user that his request has been rejected via email

  Scenario: editing an Event
    
    An event that should be edited in the event Calendar

    Given I am logged in as admin
    When I edit an existing event with updated details
    Then I should see a confirmation message that the event details have been successfully updated
    And the event details should be updated in event Calendar

  Scenario: Deleting an Event
    
    An event should be deleted from the event Calendar

    Given I am logged in as admin
    When I chose to delete an existing event
    Then I should see a confirmation message that the event has been successfully deleted
    And the event should no longer be visible in the event Calendar
    
    