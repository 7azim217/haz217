package eventplanner;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private double price;
    private boolean availability;
    private String description;
    private String category;
    public static ArrayList<Item> itemList = new ArrayList<Item>();
    static  ArrayList<Item> foodList = new ArrayList<Item>();
    static ArrayList<Item> singersList = new ArrayList<Item>();
    static    ArrayList<Item> decorationsList = new ArrayList<Item>();
    static ArrayList<Item> photographyStudiosList = new ArrayList<Item>();

    // Constructor
    public Item() {}
    public Item(String name, double price, boolean availability, String description, String category) {
        this.name = name;
        this.price = price;
        this.availability = availability;
        this.description = description;
        this.category = category;
    }
    public static Item getItemByName(String itemName) {
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Item not found with the given name
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public static void searchAndDisplayItem(List<Item> items, String name) {
        boolean found = false;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Service Name: " + item.getName());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Description: " + item.getDescription());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("item not found.");
        }
    }

    // toString() method to represent Item object as String
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
    
}
