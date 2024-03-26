package partyplanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import eventplanner.CalendarEvent;
import eventplanner.CoUserData.Event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EventManagementTest {
	CalendarEvent event;
    CalendarEvent eventCalendar;
    boolean result;
    String message;

    @Given("I chose to approve a reserved event")
    public void iChoseToApproveAReservedEvent() {
    
    	event = new CalendarEvent();
    }

    @When("I approve a reserved event with complete details")
    public void iApproveAReservedEventWithCompleteDetails() {
        event.setEventName("NewEvent");
        event.setEventDate("21/11/2024");
        event.setEventPlace("venue");
       
        result = eventCalendar.eList.add(event);
    }

    @Then("I should see a confirmation message that the event details have been successfully added to the event Calendar")
    public void iShouldSeeAConfirmationMessageThatTheEventDetailsHaveBeenSuccessfullyAddedToTheEventCalendar() {
        assertTrue(result);
        message = event.getSuccessMessage();
        assertEquals("Event details added to calendar successfully.", message);
    }

    @Then("the event should display in event Calendar")
    public void theEventShouldDisplayInEventCalendar() {
        assertNotNull(event.eList.get(0));
    }

    @Given("I chose to Reject a reserved event")
    public void iChoseToRejectAReservedEvent() {
        event = event.eList.get(0);
    }

    @When("I Reject a reserved event")
    public void iRejectAReservedEvent() {
        result = event.eList.remove(event);
    }

    @Then("A message should be sent to the customer that his request has been rejected via email")
    public void aMessageShouldBeSentToTheCustomerThatHisRequestHasBeenRejectedViaEmail() {
        assertTrue(result);
        message = event.getEmailRejectionMessage();
        assertEquals("rejected", message);
    }

    @Given("I chose to edit an existing event")
    public void iChoseToEditAnExistingEvent() {
        event = event.eList.get(0);
    }

    @When("I edit an existing event with updated details")
    public void iEditAnExistingEventWithUpdatedDetails() {
        event.setEventName("UpdatedEventName");
        event.setEventDate("updated date");
        event.setEventPlace("updated venue");
        
        result = event.aList.add(event);
    }

    @Then("I should see a confirmation message that the event details have been successfully updated")
    public void iShouldSeeAConfirmationMessageThatTheEventDetailsHaveBeenSuccessfullyUpdated() {
        assertTrue(result);
        message = event.gettSuccessMessage();
        assertEquals("Event details updated successfully.", message);
    }

    @Then("the event details should be updated in event Calendar")
    public void theEventDetailsShouldBeUpdatedInEventCalendar() {
        CalendarEvent updatedEvent = new CalendarEvent();
        assertNotNull(updatedEvent);
        assertEquals(event, updatedEvent);
    }

    @Given("I chose to delete an event")
    public void iChoseToDeleteAnEvent() {
        event = event.aList.get(0);
    }

    @When("I delete an existing event")
    public void iDeleteAnExistingEvent() {
        result = event.aList.remove(event);
    }

    @Then("I should see a confirmation message that the event has been successfully deleted")
    public void iShouldSeeAConfirmationMessageThatTheEventHasBeenSuccessfullyDeleted() {
        assertTrue(result);
        message = eventCalendar.getSuccessMessage();
        assertEquals("Event deleted successfully.", message);
    }

    @Then("the event should no longer be visible in the event Calendar")
    public void theEventShouldNoLongerBeVisibleInTheEventCalendar() {
        assertNull(event.aList.get(0));
    }
}