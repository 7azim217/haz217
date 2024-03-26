package partyplanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import eventplanner.CoUserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoUserWorksTest {
	
	    CoUserData coUser;
	    String editProfileResult;
	    String createEventResult;
	    String adminApprovalStatus;

	
	@Given("co_user is on the Profile screen.")
	public void co_user_is_on_the_profile_screen() {
		 coUser = new CoUserData("raghadbdair", "raghad@example.com", "R@ghadnbdair910");
	   
	}

	@When("User selects the option to edit profile information.")
	public void user_selects_the_option_to_edit_profile_information() {
		 editProfileResult = coUser.editProfile("raghadbdair", "raghad@example.com", "R@ghadnbdair910");
	  
	}

	@Then("User can modify profile details such as name, contact information.")
	public void user_can_modify_profile_details_such_as_name_contact_information() {
		  assertTrue(editProfileResult.equals("Profile updated successfully!"));
	  
	}

	@Given("co_user is on the Home screen.")
	public void co_user_is_on_the_home_screen() {
	     coUser = new CoUserData("raghadbdair", "raghad@example.com", "R@ghadnbdair910");
	    
	}

	@When("User selects the option to create a new event.")
	public void user_selects_the_option_to_create_a_new_event() {
		  createEventResult = coUser.createNewEvent("Event Name", "12/11/2024", "Location", "Description",1000, "pending");
	}

	@Then("User fills in details such as event name, price, duration, start and end times, and adds photos.")
	public void user_fills_in_details_such_as_event_name_price_duration_start_and_end_times_and_adds_photos() {
		 assertTrue(createEventResult.contains("created successfully"));
	}

	@Then("the Details should be sent to the admin for approval")
	public void the_details_should_be_sent_to_the_admin_for_approval() {
		 adminApprovalStatus = coUser.getAdminApprovalStatus();
	        assertEquals("Pending", adminApprovalStatus); 
	}

}