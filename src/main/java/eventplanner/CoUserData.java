package eventplanner;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoUserData {
    private String name;
    private String email; 
    private String password;
    private List<Event> userEvents;

    public CoUserData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userEvents = new ArrayList<>(); 
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public boolean setEmail(String email) {

        this.email = email;
        return true;
    }
    public String getPassword() { return password; }
    public boolean setPassword(String password) {
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

    public String createNewEvent(String eventName, String eventDate, String location, String description, double eventPrice, String status) {
        Event newEvent = new Event(eventName, eventDate, location, description, eventPrice, status, this.email);
        userEvents.add(newEvent);
        return Event.getSuccessMessage(eventName);
    }



    public static class Event {
        private static final String DATE_PATTERN = null;
		private String eventName;
        private String eventDate;
        private String location;
        private String description;
        private double eventPrice;
        private String adminApprovalStatus;
        private String creatorEmail; 

        public Event(String eventName, String eventDate, String location, String description, double eventPrice, String status, String creatorEmail) {
            this.eventName = eventName;
            this.eventDate = validateDate(eventDate);
            this.location = location;
            this.description = description;
            this.eventPrice = eventPrice;
            this.adminApprovalStatus = status;
            this.creatorEmail = creatorEmail;
        }


        private String validateDate(String eventDate) {
            if (!isValidDate(eventDate)) {
                throw new IllegalArgumentException("Invalid date format. Please use dd/mm/yyyy format.");
            }
            return eventDate;
        }


        public static String getSuccessMessage(String eventName) {
            return "Event '" + eventName + "' created successfully! Wait for admin approval.";
        }


        static boolean isValidDate(String date) {
            Pattern pattern = Pattern.compile(DATE_PATTERN);
            Matcher matcher = pattern.matcher(date);
            return matcher.matches();
        }
    }


    public List<Event> getUserEvents() {
        return userEvents;
    }


    public String getAdminApprovalStatus() {
        return "pending"; 
    }
