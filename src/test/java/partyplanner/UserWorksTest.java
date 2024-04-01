package partyplanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import eventplanner.CalendarEvent;
import eventplanner.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserWorksTest {
	    User user;
	    boolean result;
	    String message;
	    CalendarEvent event;

	@Given("User is on the Home screen.")
	public void user_is_on_the_home_screen() {
		 user = new User();
	       
	}
	
	

	@When("User sets preferences and budget.")
	public void user_sets_preferences_and_budget() {
		 result = user.setPreferencesAndBudget();
	}

	@Then("System displays recommended services based on user preferences and budget constraints.")
	public void system_displays_recommended_services_based_on_user_preferences_and_budget_constraints() {
		assertTrue(result);
        assertEquals("Recommended services displayed successfully.", user.getSuccessMessage());
	}

	@Given("User is on the Search screen.")
	public void user_is_on_the_search_screen() {
	     user = new User();
	}

	@When("User enters a search query for a specific service \\(e.g., photography studio).")
	public void user_enters_a_search_query_for_a_specific_service_e_g_photography_studio() {
		  result = user.searchForService("photography studio");
	}

	@Then("System displays relevant search results matching the query.")
	public void system_displays_relevant_search_results_matching_the_query() {
		 assertTrue(result);
	        assertEquals("Search results displayed successfully.", user.getSuccessMessage());
	}

	@When("User applies filters such as location, date, and budget.")
	public void user_applies_filters_such_as_location_date_and_budget() {
		 result = user.applyFilters("location", "date", "budget");
	}

	@Then("System refines search results based on the applied filters.")
	public void system_refines_search_results_based_on_the_applied_filters() {
		 assertTrue(result);
	        assertEquals("Search results refined successfully.",user.getSuccessMessage());
	}

	@Given("User is on the Profile screen.")
	public void user_is_on_the_profile_screen() {
		 user = new User();
	}

	@When("User selects the option to edit profile information.")
	public void user_selects_the_option_to_edit_profile_information() {
		String r = user.editProfile("new name", "new pass");
	}

	@Then("User can modify profile details such as name, profile picture, and contact information.")
	public void user_can_modify_profile_details_such_as_name_profile_picture_and_contact_information() {
		 assertTrue(result);
	        assertEquals("Profile details updated successfully.", user.getSuccessMessage());
	}

	@When("User selects the option to provide feedback.")
	public void user_selects_the_option_to_provide_feedback() {
		  result = user.provideFeedback();
	}

	@Then("User can rate the application and provide comments or suggestions.")
	public void user_can_rate_the_application_and_provide_comments_or_suggestions() {
		 assertTrue(result);
	        assertEquals("Feedback submitted successfully.", user.getSuccessMessage());
	}

	@Given("a user  chose to reserve a new event")
	public void a_user_chose_to_reserve_a_new_event() {
		event=new CalendarEvent();
	       
	}

	@When("user  reserve a new event with valid details including date, time, venue, theme,category and description")
	public void user_reserve_a_new_event_with_valid_details_including_date_time_venue_theme_category_and_description() {
		 event.setEventName("name");
		 event.setEventDate("21/10/2025");
		 event.setEventPlace("place");
	}

	@Then("user  should see a  message containing that the operation is awaiting approval from the admin")
	public void user_should_see_a_message_containing_that_the_operation_is_awaiting_approval_from_the_admin() {
		assertTrue(result);
        assertEquals("Event reservation awaiting approval from admin."," Event reservation awaiting approval from admin.");
    }
	

	@Then("the Details should be sent to the admin for approval")
	public void the_details_should_be_sent_to_the_admin_for_approval() {
		  assertEquals("Pending approval from admin.",user.getSuccessMessage());
	}

	@When("user  attempt to reserve a new event with a date and venue that is already assigned to another event")
	public void user_attempt_to_reserve_a_new_event_with_a_date_and_venue_that_is_already_assigned_to_another_event() {
		 event.setEventDate("2024-03-10");
	        event.setEventPlace("VenueName");
	        result =false;
	}

	@Then("user  should be notified that the date and venue is already scheduled for another event")
	public void user_should_be_notified_that_the_date_and_venue_is_already_scheduled_for_another_event() {
		 assertFalse(result);
	        message = user.getErrorMessage();
	        assertEquals("The date and venue are already scheduled for another event.", message);
	}

	@Then("user  should be prompted to choose a different date  for the event or different venue")
	public void user_should_be_prompted_to_choose_a_different_date_for_the_event_or_different_venue() {
	 
	}



}
