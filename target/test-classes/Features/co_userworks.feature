Feature: co_user works

	Scenario: Editing Profile Information
     	Given co_user is on the Profile screen.
    	When User selects the option to edit profile information.
    	Then User can modify profile details such as name, contact information.

    Scenario: Creating a New Event
	    Given co_user is on the Home screen.
	    When User selects the option to create a new event.
	    Then User fills in details such as event name, price, duration, start and end times, and adds photos.
      And the Details should be sent to the admin for approval
        
     Scenario: Editing an existing Event 
       Given co_user is on the Home screen 
       When user select the option to edit an existing event 
       Then User fills in details such as event name, price, duration, start and end times, and adds photos
       
      Scenario: Vewing my event
       Given co_user is on the Home screen 
       When co_user select the option to view my event 
       Then print the event details such as name , date , location , and description
         
         
 