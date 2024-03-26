Feature: Service Provider manegment

Service Provider manegment should be quick and easy

Scenario: Successful Addition of New Item

A new item should be added to the item lists(food list,singers list ,decorations list,photography studios list)

Given I chose to add new item
When I add a new item with valid details(name,price,availability,description,category)
Then the item should be successfully added to it is category list (food list,singers list ,decorations list,photography studios list)
And users should be able to view and select the newly added item

Scenario: Duplicate Item Name
Given I chose to add new item 
When I attempt to add a new item with a name that already exists in items lists
Then I should be notified that the item name is already in use
And prompted to choose a different name for the item


Scenario: Editing  Existing Item
Given I chose to edit existing item
When I decide to edit an existing item
Then I should be able to edit its details such as name, description, price,catagory and availability
And upon submission, the changes should be successfully updated in the item lists
And users should see the updated details for the edited item

Scenario: Deleting an item

An item should be deleted from the item lists


Given I chose to delete an item
When I delete an existing item
Then I should see a confirmation message that the item has been successfully deleted
And the item should no longer be visible in the item lists
