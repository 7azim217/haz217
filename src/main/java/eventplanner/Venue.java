package eventplanner;
import java.util.ArrayList;
import java.util.Scanner;



public class Venue {
	 private String name;
	    private String status; // indoor or outdoor
	    private String location;
	    private int capacity;
	    private  boolean availability;
	    private double pricing;
	  public  static ArrayList<Venue> venueList = new ArrayList<Venue>();

	    // Constructor
	    public Venue() {
	    	
	    }
	    public Venue(String name, String status, String location, int capacity, boolean availability, double pricing) {
	        this.name = name;
	        this.status = status;
	        this.location = location;
	        this.capacity = capacity;
	        this.availability = availability;
	        this.pricing = pricing;
	     //   allVenues.add(this);
	    }

	    public static Venue getVenueByName(String name) {
	        for (Venue venue : venueList) {
	            if (venue.getName().equals(name)) {
	                return venue;
	            }
	        }
	        return null; // Venue not found with the given name
	    }
	    // Getters and Setters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }

	    public boolean isAvailability() {
	        return availability;
	    }

	    public  void setAvailability(boolean availabilityy) {
	    	availability = availabilityy;
	    }

	    public double getPricing() {
	        return pricing;
	    }

	    public void setPricing(double pricing) {
	        this.pricing = pricing;
	    }
	    public static void displayVenues(ArrayList<Venue> venues) {
	        System.out.println("Available Venues:");
	        for (int i = 0; i < venues.size(); i++) {
	            System.out.println((i + 1) + ". " + venues.get(i).getName());
	        }
	    }

	    // toString() method to represent Venue object as String
	    @Override
	    public String toString() {
	        return "Venue{" +
	                "name='" + name + '\'' +
	                ", status='" + status + '\'' +
	                ", location='" + location + '\'' +
	                ", capacity=" + capacity +
	                ", availability=" + availability +
	                ", pricing=" + pricing +
	                '}';
	    }
	

	  
	        }
