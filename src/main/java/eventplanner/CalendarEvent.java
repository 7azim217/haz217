package eventplanner;


import java.util.ArrayList;

import java.util.List;

public class CalendarEvent {
    private String eventName;
    private String eventDate;
    private String eventPlace;
	String email;
    public  static List<CalendarEvent> eList = new ArrayList<>();
    public  static List<CalendarEvent> aList = new ArrayList<>();

    public CalendarEvent(String eventName, String eventDate, String eventPlace) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.email=User.getemail();
    }

  

	public CalendarEvent() {
		// TODO Auto-generated constructor stub
	}



	// Getters and setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }
    @Override
    public String toString() {
        return "Event Name: " + eventName + "\n" +
                "Event Date: " + eventDate + "\n" +
                "Event Place: " + eventPlace + "\n" ;
               
    }

	public String getSuccessMessage() {
		// TODO Auto-generated method stub
		return "Event details added to calendar successfully.";
	}

	public String getEmailRejectionMessage() {
		// TODO Auto-generated method stub
		return "rejected";
	}

	public String gettSuccessMessage() {
		// TODO Auto-generated method stub
		return "Event details updated successfully.";
	}
}
