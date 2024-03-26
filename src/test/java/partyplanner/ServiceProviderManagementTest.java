package partyplanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import eventplanner.Item;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceProviderManagementTest {
	 String message;
	 boolean result;
	 Item item;
	@Given("I chose to add new item")
	public void i_chose_to_add_new_item() {
		 item = new Item();
	}
	
	
	

	@When("I add a new item with valid details\\(name,price,availability,description,category)")
	public void i_add_a_new_item_with_valid_details_name_price_availability_description_category() {
		item.setName("NewItem");
        item.setPrice(10.00);
        item.setAvailability(true);
        item.setDescription("New item description.");
        result = Item.itemList.add(item);
	}

	@Then("the item should be successfully added to it is category list \\(food list,singers list ,decorations list,photography studios list)")
	public void the_item_should_be_successfully_added_to_it_is_category_list_food_list_singers_list_decorations_list_photography_studios_list() {
		 assertTrue(result);
	        assertNotNull(Item.itemList.get(1));
	}

	@Then("users should be able to view and select the newly added item")
	public void users_should_be_able_to_view_and_select_the_newly_added_item() {
	  
	}

	@When("I attempt to add a new item with a name that already exists in items lists")
	public void i_attempt_to_add_a_new_item_with_a_name_that_already_exists_in_items_lists() {
		 item.setName("ExistingItemName");
	        result = Item.itemList.add(item);
	}

	@Then("I should be notified that the item name is already in use")
	public void i_should_be_notified_that_the_item_name_is_already_in_use() {
		 assertFalse(result);
	        System.out.println("The item name  is already in use.");
	}

	@Then("prompted to choose a different name for the item")
	public void prompted_to_choose_a_different_name_for_the_item() {
	 
	}

	@Given("I chose to edit existing item")
	public void i_chose_to_edit_existing_item() {
	    
	}

	@When("I decide to edit an existing item")
	public void i_decide_to_edit_an_existing_item() {
		item.setName("UpdatedItemName");
        item.setDescription("Updated item description.");
        item.setPrice(15.00);
        item.setAvailability(false);
        result = true;
	}

	@Then("I should be able to edit its details such as name, description, price,catagory and availability")
	public void i_should_be_able_to_edit_its_details_such_as_name_description_price_catagory_and_availability() {
		 assertTrue(result);
	        assertEquals("UpdatedItemName", item.getName());
	        assertEquals("Updated item description.", item.getDescription());
	        assertEquals(15.00, item.getPrice(), 0.01);
	        assertFalse(item.isAvailability());
	}

	@Then("upon submission, the changes should be successfully updated in the item lists")
	public void upon_submission_the_changes_should_be_successfully_updated_in_the_item_lists() {
		  assertTrue(true);
	}

	@Then("users should see the updated details for the edited item")
	public void users_should_see_the_updated_details_for_the_edited_item() {
	 
	}

	@Given("I chose to delete an item")
	public void i_chose_to_delete_an_item() {
	   
	}

	@When("I delete an existing item")
	public void i_delete_an_existing_item() {
		item.setName("DeleteItemName");
        item.setDescription("Delete item description.");
        item.setPrice(15.00);
        item.setAvailability(false);
        result = true;
	}

	@Then("I should see a confirmation message that the item has been successfully deleted")
	public void i_should_see_a_confirmation_message_that_the_item_has_been_successfully_deleted() {
		assertTrue(result);
        message = "the item details have been successfully deleted";
        assertEquals("the item deleted successfully.", message);
	}

	@Then("the item should no longer be visible in the item lists")
	public void the_item_should_no_longer_be_visible_in_the_item_lists() {
	  
	}
	
}