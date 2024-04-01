package eventplanner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoUserData {
    private String name;
    private static String email;
    private String password;
   
    static ArrayList<Event> events = new ArrayList<Event>();
    static ArrayList<Event> aevents = new ArrayList<Event>();
  
    
   
    
     public CoUserData(String name, String email, String password) {
        this.name = name;
        CoUserData.email = email;
        this.password = password;
    
        
    }


    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    // Setter for email with validation
    public static  boolean setEmail(String email) {
        
        	 CoUserData.email = email;
            return true;
        
    }

    public String getPassword() {
        return password;
    }

    // Setter for password with basic validation
    public boolean setPassword(String password) {
        // Example of a simple password validation: not empty
        // You can expand this with more complex checks as needed
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
            return true;
        }
        return false;
    }


  
    public String editProfile(String newName, String newEmail, String newPassword) {
        boolean emailUpdated = setEmail(newEmail);
        boolean passwordUpdated = setPassword(newPassword);

        if (emailUpdated && passwordUpdated) {
            setName(newName);
            return "Profile updated successfully!";
        }
        return "Failed to update profile. Please check your inputs.";
    }

    public static String createNewEvent(String eventName, String eventDate, String location, String description,double eventPrice,String s) {
        Event newEvent = new Event(eventName, eventDate, location, description,eventPrice,s);
        events.add(newEvent);
        return getSuccessMessage(eventName);
    }
    private static String getSuccessMessage(String eventName) {
        return "Event '" + eventName + "' created successfully! wait admin approval";
    }

    public static class Event {
        private String eventName;
        private String eventDate;
        private String location;
        private double eventPrice;
        private  String adminApprovalStatus;
        private String description;
        public static String e;
        private static final String DATE_PATTERN = "^\\d{2}/\\d{2}/\\d{4}$";
        

        public Event(String eventName, String eventDate, String location, String description,double eventPrice,String status) {
            this.eventName = eventName;
            this.adminApprovalStatus=status;
            this.e=CoUserData.getEmail();
            this.location = location;
            this.description = description;
            this.eventPrice = eventPrice;
            if (isValidDate(eventDate)) {
                this.eventDate = eventDate;
                
            } else {
                throw new IllegalArgumentException("Invalid date format. Please use dd/mm/yyyy format.");
            }
        }

        public Event() {
			// TODO Auto-generated constructor stub
		}

		static boolean isValidDate(String date) {
            Pattern pattern = Pattern.compile(DATE_PATTERN);
            Matcher matcher = pattern.matcher(date);
            return matcher.matches();
        }

		public String getEventName() {
            return eventName;
        }

        public String getEventDate() {
            return eventDate;
        }

        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }


        public String getDescription() {
            return description;
        }
        public void setName(String name) {
            this.eventName = name;
        }
        public void setstatus(String s) {
            this.adminApprovalStatus = s;
        }
        public String getstatus() {
            return adminApprovalStatus;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public double getPrice() {
            return eventPrice;
        }
        public void settPrice(double price) {
            this.eventPrice = price;
        }
      
        public void settDate(String date) {
            this.eventDate = date;
        }

		public static Event getEventByName(String eventname) {
			for (Event event : events) {
	            if (event.getEventName().equalsIgnoreCase(eventname)) {
	                return event;
	            }
	        }
	        return null; // Event not found
		}
        
		@Override
	    public String toString() {
	        return "Event Name: " + eventName + "\n" +
	                "Event Date: " + eventDate + "\n" +
	                "Location: " + location + "\n" ;
	               
	    }

    }


    public static List<Event> getEvents() {
        return events;
    }
    private void sendForAdminApproval(String actionType, String details) {

        System.out.println("Sent for admin approval: " + actionType + " - " + details);
        
    }


   
    public static void filterByLocation(List<CoUserData.Event> events, String location) {
        System.out.println("Events in location '" + location + "':");
        for (CoUserData.Event event : events) {
            if (event.getLocation().equalsIgnoreCase(location)) {
                System.out.println("Name: " + event.getEventName() + ", Date: " + event.getEventDate() + ", Location: " + event.getLocation() + ", Description: " + event.getDescription());
            }else {System.out.println("No Events");
            
        }
    }}

    public static void filterByDate(List<CoUserData.Event> events, String dateString) {
        System.out.println("Events on date '" + dateString + "':");
        // Assuming event date is in format "dd-MM-yyyy"
        for (CoUserData.Event event : events) {
            if (event.getEventDate().equals(dateString)) {
                System.out.println("Name: " + event.getEventName() + ", Date: " + event.getEventDate() + ", Location: " + event.getLocation() + ", Description: " + event.getDescription());
            }
            else {System.out.println("No Events");}
        }
    }
	public String getAdminApprovalStatus() {
		// TODO Auto-generated method stub
		return "pending";
	}


    
}


	
