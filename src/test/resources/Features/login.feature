Feature: feature to test login functionality

  Scenario: Logging in as Admin
    
    Given Admin is on the login screen
    When Admin enters credentials
    Then Admin gains access to the admin interface with the provided credentials
   
   
   Scenario: Successful Login for user
	Given User is on the Login screen.
	When User enters correct email and password.
	Then User is logged into the application.
   
   	Scenario: Remember Me Functionality
	Given User is on the Login screen.
	When User checks the "Remember Me" option and logs in.
	Then User remains logged in even after exiting the application.
	
  Scenario: Logging in as service provider
	Given service provider is on the login screen.
	When  service provider enters credentials.
	Then service provider gains access to the service provider interface with the provided credentials.
   

  Scenario: Incorrect Password or incorrect email
    Given Adminis on the Login screen
    When Adminenters incorrect email or incorrect password
    Then System displays an error message


  Scenario: Successful Login co_user
    Given  co_user  is on the Login screen.
    When co_user  enters correct email and password.
    Then co_user  is logged into the co_user  page


  Scenario: Empty Fields
    Given co_user  is on the Login screen.	
         When co_user  tries to login with empty email or password field.
    Then System displays an error message prompting user to fill in all fields.