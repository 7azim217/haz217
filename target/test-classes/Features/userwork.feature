Feature: user works
	Scenario: Viewing Recommendations
	Given User is on the Home screen.
	When User sets preferences and budget.
	Then System displays recommended services based on user preferences and budget constraints.

	Scenario: Searching for Services
	Given User is on the Search screen.
	When User enters a search query for a specific service (e.g., photography studio).
	Then System displays relevant search results matching the query.

	Scenario: Refining Search Results
	Given User is on the Search screen.
	When User applies filters such as location, date, and budget.
	Then System refines search results based on the applied filters.

	Scenario: Editing Profile
	Given User is on the Profile screen.
	When User selects the option to edit profile information.
	Then User can modify profile details such as name, profile picture, and contact information.

	Scenario: Providing Feedback
	Given User is on the Profile screen.
	When User selects the option to provide feedback.
	Then User can rate the application and provide comments or suggestions.

	Scenario: Successfully reserved an event
     A user has reserved a new event and must be approved by the admin
    Given a user  chose to reserve a new event
    When user  reserve a new event with valid details including date, time, venue, theme,category and description
    Then user  should see a  message containing that the operation is awaiting approval from the admin
    And the Details should be sent to the admin for approval

    Scenario: Duplicate Event Date and venue
     An error message should be displayed when a new event with a recurring date and venue is added.
     Given a user  chose to reserve a new event
      When user  attempt to reserve a new event with a date and venue that is already assigned to another event
      Then user  should be notified that the date and venue is already scheduled for another event
      And user  should be prompted to choose a different date  for the event or different venue
      
      
      