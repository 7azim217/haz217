Feature: User Registration
	Scenario:  Successful Registration
	Given User is on the Register screen.
	When User fills in all required fields with valid information and submits.
	Then User account is successfully created, and they are redirected to the Login screen.

	Scenario:  Weak Password
	Given User is on the Register screen.
	When User enters a weak password.
	Then System prompts user to choose a stronger password.

	Scenario: Existing Email or Username
	Given User is on the Register screen.
	When User enters an email or username that already exists in the database.
	Then System displays an error message indicating that the email or username is already taken.

	
	  Scenario: Successful Registration
    Given co_user is on the Register screen.
    When co_user fills in all required fields with valid information and submits.
    Then co_user  account is successfully created, and they are redirected to the Login screen.


  Scenario: Existing Email or Username
    Given co_user is on the Register screen.
    When co_user enters an email or username that already exists in the database.
    Then System displays an error message indicating that the email or username is already taken.
