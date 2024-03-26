Feature: venue Management
  
  Venue Management should be efficient and user-friendly.

  Scenario: Adding a New Venue Successfully
    
    A new venue should be added to the venue list

    Given I am logged in as admin
    When I chose to add a new venue
    Then I should be prompted to provide details such as name,status(in door ,out door),location,capacity,availability, and pricing for the venue
    And upon submission the new venue should be successfully added to the venue list

  Scenario: Duplicate Venue Name
    An error message should be displayed when a new event with a recurring name is added.

    Given I am logged in as admin
    When I attempt to add a new venue with a name that already exists in the venue list
    Then I should be notified that the venue name is already in use
    And prompted to choose a different name for the venue

  Scenario: editing an Venue
    
    An venue that should be edited in the venue list

    Given I am logged in as admin
    When I attempt edit an existing venue with updated details
    Then I should see a confirmation message that the venue details have been successfully updated
    And the venue details should be updated in venue list

  Scenario: checking availablity
    
    Show available venues from the venue list for a specific day

    Given I am logged in as admin
    When I Choose to check venues availability for a specific day
    Then I should see   a list of available venues for that day
    And the list should include venue details
    
    
    Scenario: Viewing Feedback
    Given Admin is on the Feedback screen.
    When Admin accesses the feedback section.
    Then Admin can view feedback entries, filter them based on sentiment, and take necessary actions.
    