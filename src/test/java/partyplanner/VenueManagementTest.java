package partyplanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import eventplanner.Venue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;

public class VenueManagementTest {
	
	
	ArrayList<Venue> venueList = new ArrayList<Venue>();

    Venue venue;
    
    

  //  System system;
    boolean result;
    String message;
	@Given("I am logged in as admin")
	public void i_am_logged_in_as_admin() {
	}

	@When("I chose to add a new venue")
	public void i_chose_to_add_a_new_venue() {
	    venue = new Venue();

	      //  system = new System();
	  
	}

	@Then("I should be prompted to provide details such as name,status\\(in door ,out door),location,capacity,availability, and pricing for the venue")
	public void i_should_be_prompted_to_provide_details_such_as_name_status_in_door_out_door_location_capacity_availability_and_pricing_for_the_venue() {
	  
	}

	@Then("upon submission the new venue should be successfully added to the venue list")
	public void upon_submission_the_new_venue_should_be_successfully_added_to_the_venue_list() {
		assertTrue(venueList.add(venue));
	}

	@When("I attempt to add a new venue with a name that already exists in the venue list")
	public void i_attempt_to_add_a_new_venue_with_a_name_that_already_exists_in_the_venue_list() {
		 venue.setName("ExistingVenueName");
	        result = venueList.add(venue);
	}

	@Then("I should be notified that the venue name is already in use")
	public void i_should_be_notified_that_the_venue_name_is_already_in_use() {
		 assertFalse(result);
	        message = "this name is already in use please enter another name";
	        assertEquals("Venue name is already in use.", message);
	}

	@Then("prompted to choose a different name for the venue")
	public void prompted_to_choose_a_different_name_for_the_venue() {
		 venue = Venue.getVenueByName("name");
	}

	@When("I attempt edit an existing venue with updated details")
	public void i_attempt_edit_an_existing_venue_with_updated_details() {
		 venue.setName("UpdatedVenueName");
	        venue.setStatus("UpdatedStatus");
	        venue.setAvailability(true);
	        venue.setCapacity(6);
	        venue.setLocation("asasd");
	        venue.setPricing(10002);
	        result = true;
	}

	@Then("I should see a confirmation message that the venue details have been successfully updated")
	public void i_should_see_a_confirmation_message_that_the_venue_details_have_been_successfully_updated() {
		assertTrue(result);
        message = "the venue details have been successfully updated";
        assertEquals("Venue details updated successfully.", message);
	}

	@Then("the venue details should be updated in venue list")
	public void the_venue_details_should_be_updated_in_venue_list() {
		Venue updatedVenue = venueList.stream()
                .filter(v -> v.getName().equals(venue.getName()))
                .findFirst()
                .orElse(null);
             assertNotNull("Updated venue should be in the list", updatedVenue);

            assertEquals("UpdatedVenueName", updatedVenue.getName());
            assertEquals("UpdatedStatus", updatedVenue.getStatus());
            assertTrue(updatedVenue.isAvailability());
            assertEquals(100, updatedVenue.getCapacity());
            assertEquals("UpdatedLocation", updatedVenue.getLocation());
            assertEquals(5000, updatedVenue.getPricing());
	}

	@When("I Choose to check venues availability for a specific day")
	public void i_choose_to_check_venues_availability_for_a_specific_day() {
		 boolean day=true;
	 
	}

	@Then("I should see   a list of available venues for that day")
	public void i_should_see_a_list_of_available_venues_for_that_day() {
		 assertFalse("There should be available venues for the specific day", venueList.isEmpty());
	}

	@Then("the list should include venue details")
	public void the_list_should_include_venue_details() {
		for (Venue venue : venueList) {
	        assertNotNull("Venue name should not be null", venue.getName());
	        // Add more checks as necessary for each detail you expect to be populated
	    }
	}

}
