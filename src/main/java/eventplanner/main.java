package eventplanner;


import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Scanner;



import eventplanner.CoUserData.Event;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.ParseException;

public class main {

	public static void main(String[] args) throws java.text.ParseException {

	    boolean loop=true;
		Scanner input=new Scanner(System.in);
		SignUp sign = new SignUp();
		Login login=new Login(sign);
		CoUserData co;
		User u;
		
		 Venue v1=new Venue("FlowerVenue","indoor","Nablus",200,true,1000);
		  Venue v2=new Venue("Princes Venue","indoor","Ramallah",100,true,1500);
		  Venue v3=new Venue("DreamVenue","outdoor","Nablus",150,true,3000);
		  Venue v4=new Venue("DiamondVenue","outdoor","Ramallah",100,false,1000);
		  Venue.venueList.add(v1);
		  Venue.venueList.add(v2);
		  Venue.venueList.add(v3);
		  Venue.venueList.add(v4);
		  Item.itemList.add(new Item("Pizza", 10.99, true, "Delicious cheese pizza", "Food"));
	        Item.itemList.add(new Item("Burger", 8.99, true, "Juicy beef burger with fries", "Food"));
	        Item.itemList.add(new Item("John Doe", 200.0, true, "Professional singer", "Singer"));
	        Item.itemList.add(new Item("Jane Smith", 250.0, true, "Experienced vocalist", "Singer"));
	        Item.itemList.add(new Item("Flower Arrangement", 50.0, true, "Beautiful floral decorations", "Decoration"));
	        Item.itemList.add(new Item("Fairy Lights", 30.0, true, "Glowing fairy lights for ambiance", "Decoration"));
	        Item.itemList.add(new Item("Snap Studios", 500.0, true, "Professional photography studio", "Photography Studio"));
	        Item.itemList.add(new Item("Capture Moments", 450.0, true, "Capturing your special moments", "Photography Studio"));
	        Item.foodList.add(new Item("Pizza", 10.99, true, "Delicious cheese pizza", "Food"));
	        Item.foodList.add(new Item("Burger", 8.99, true, "Juicy beef burger with fries", "Food"));
	        Item.singersList.add(new Item("John Doe", 200.0, true, "Professional singer", "Singer"));
	        Item.singersList.add(new Item("Jane Smith", 250.0, true, "Experienced vocalist", "Singer"));
	        Item.decorationsList.add(new Item("Flower Arrangement", 50.0, true, "Beautiful floral decorations", "Decoration"));
	        Item.decorationsList.add(new Item("Fairy Lights", 30.0, true, "Glowing fairy lights for ambiance", "Decoration"));
	        Item. photographyStudiosList.add(new Item("Snap Studios", 500.0, true, "Professional photography studio", "Photography Studio"));
	        Item. photographyStudiosList.add(new Item("Capture Moments", 450.0, true, "Capturing your special moments", "Photography Studio"));
	         List<String> usernames = new ArrayList<String>();
	         List<Integer> ratings = new ArrayList<Integer>();
	         List<String> messages = new ArrayList<String>();
	       // String bbb=CoUserData.createNewEvent("haa","21/11/2024","naplus","hooo",500.0,);
	       
	        
	      
while(loop) {
	System .out.println("hello\nplease enter your choice\n1.signnup\n2.signup as co_user \n3.login\n4.exit\n ");
	int num=input.nextInt();
switch(num){

case 1:	{
	    boolean test=true;
	    while(test) {
        Scanner Input=new Scanner(System.in);

		System.out.println("please enter your usrename");
		String username=Input.next();
		System.out.println("please enter your email");
		String em=Input.next();

		System.out.println("please enter the password");
		String pass=Input.next();

		System.out.println("please rewrite your password");
		String repass=Input.next();

		test=sign.signUp(username, pass, repass,em);
	    }break;}
case 2:{

	boolean test=true;
    while(test) {
	Scanner Input=new Scanner(System.in);

	System.out.println("please enter your usrename");
	String username=Input.next();

	System.out.println("please enter your name");
	String name=Input.next();

	System.out.println("please enter your email");
	String email=Input.next();

	System.out.println("please enter the password");
	String pass=Input.next();
	System.out.println("please enter your password");
	String repass=Input.next();
	test=sign.signUp_couser(username, name,email ,pass,repass);

    }break;}

case 3:{



	boolean test = true;
	boolean test1;
	while (test) {
	    boolean test2;
	    Scanner input1 = new Scanner(System.in);

	    System.out.println("Please enter your username:");
	    String username = input1.next();

	    System.out.println("Please enter the password:");
	    String pass = input1.next();
u=sign.getserData(username);
if(u!=null) {
	  Scanner scanner = new Scanner(System.in);
      int choice;

      do {
    	  User.displayHomePage();
          choice = scanner.nextInt();
         
          switch (choice) {
              case 1:
            	  while(true) {
            	  System.out.println("chose a venue for your event:");
            	   for (int i = 0; i < Venue.venueList.size(); i++) {
       	            System.out.print((i + 1) + ". " + Venue.venueList.get(i).getName());
       	         System.out.print( " Capacit:" + Venue.venueList.get(i).getCapacity());
       	      System.out.print(" venue Location:" + Venue.venueList.get(i).getLocation());
       	   System.out.println(" venue Price" + Venue.venueList.get(i).getPricing());
       	   //Venue chosenVenue = venues.get(venueChoice - 1);
       	
       	
       	        }
            	   int vc = scanner.nextInt();
            	   String v= Venue.venueList.get(vc-1).getName();
            	   System.out.println("chose a singer:");
            	   for (int i = 0; i < Item.singersList.size(); i++) {
          	            System.out.print((i + 1) + ". " + Item.singersList.get(i).getName());
          	         System.out.println( " Price:" + Item.singersList.get(i).getPrice());
          	  
          	        }
            	   int sc = scanner.nextInt();
            	   String s= Item.singersList.get(sc-1).getName();
            	   System.out.println("chose a photography studio:");
            	   for (int i = 0; i < Item.photographyStudiosList.size(); i++) {
          	            System.out.print((i + 1) + ". " + Item.photographyStudiosList.get(i).getName());
          	         System.out.println( " Price:" + Item.photographyStudiosList.get(i).getPrice());
          	  
          	        }
            	   int phc = scanner.nextInt();
            	   String ph= Item.photographyStudiosList.get(phc-1).getName();
            	   
            	   System.out.println("chose a decorations");
            	   for (int i = 0; i < Item.decorationsList.size(); i++) {
          	            System.out.print((i + 1) + ". " + Item.decorationsList.get(i).getName());
          	         System.out.print( " Price:" + Item.decorationsList.get(i).getPrice());
          	         //decorationsList
          	         System.out.println( " description:" + Item.decorationsList.get(i).getDescription());

          	  
          	        }
            	   int dc = scanner.nextInt();
            	   String d= Item.decorationsList.get(dc-1).getName();
            	   System.out.println("chose food and drinks");
            	   for (int i = 0; i < Item.foodList.size(); i++) {
          	            System.out.print((i + 1) + ". " + Item.foodList.get(i).getName());
          	         System.out.print( " Price:" + Item.foodList.get(i).getPrice());
          	         //decorationsList
          	         System.out.println( " description:" + Item.foodList.get(i).getDescription());

          	  
          	        }
            	   int fc = scanner.nextInt();
            	   String f= Item.foodList.get(fc-1).getName();
            	   
            	   System.out.println("Enter event name :");
            	   String eventName = scanner.next();
            	    System.out.print("Enter event date : ");
                    String dateString = scanner.next();

                    // Parse event date string to Date object
                   // Date eventDate = null ;
                   
               // if(CoUserData.Event.isValidDate(dateString)) {
                //	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                	//eventDate=dateFormat.parse(dateString);}
                CalendarEvent y=new CalendarEvent(eventName,dateString,v);
                boolean eventExists = false;
                for (CalendarEvent event :CalendarEvent.eList ) {
                    if (event.getEventPlace().equals(y.getEventPlace()) && event.getEventDate().equals(y.getEventDate())) {
                        eventExists = true;
                        break;
                    }
                }
                if (!eventExists) {
                	 CalendarEvent.eList.add(y);
                	 System.out.println("your event reservation is awating admin approval wait a response via email");
                	 break;
                } else {
                    System.out.println("An event with the same place and date already exists. try with a deff details");
                }
                    
            	  }
                    
              

            	  
                
                  break;
              case 2:
            	
                    int ch;

                    do {
                        
                        System.out.println("1. View all ready packages");
                        System.out.println("2. Filter results");
                        System.out.println("3. Back");
                        System.out.print("Enter your choice: ");
                        ch = scanner.nextInt();

                        switch (ch) {
                            case 1:
                            	System.out.println("Viewing all packges:");
    	                        List<CoUserData.Event> events = CoUserData.aevents;
    	                        for (int i = 0; i < events.size(); i++) {
    	                            CoUserData.Event event = events.get(i);
    	                            System.out.println((i + 1) + ". Name: " + event.getEventName() + ", Date: " + event.getEventDate() + ", Location: " + event.getLocation() + ", Description: " + event.getDescription());
    	                        }
    	                        System.out.print("Choose an event by entering its number : ");
    	                        int cho = scanner.nextInt();
    	                        if (cho > 0 && cho <= events.size()) {
    	                            System.out.print("Enter your card number to pay: ");
    	                            long cardNumber = scanner.nextLong();
    	                            System.out.println("Payment successful for event " + cho+"contact with owner ");
    	                        } else {
    	                            System.out.println("Event not chosen. Exiting...");
    	                        }


                                break;
                            case 2:
                            	List<CoUserData.Event> event = CoUserData.aevents;
                            	 System.out.println("Filter events by:");
                                 System.out.println("1. Location");
                                 System.out.println("2. Date");
                                 System.out.print("Enter your choice: ");
                                 int choi = scanner.nextInt();
                                 switch (choi) {
                                 case 1:
                                     System.out.print("Enter location: ");
                                     String location = scanner.next();
                                     CoUserData.filterByLocation(event, location);
                                     break;
                                 case 2:
                                     System.out.print("Enter date (format: dd-MM-yyyy): ");
                                     String dateS = scanner.next();
                                     CoUserData.filterByDate(event, dateS);
                                     break;
                                 default:
                                     System.out.println("Invalid choice! Exiting...");
                             }

                                break;
                            case 3:
                                // You can handle back option here if needed
                                System.out.println("Going back to the previous menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please choose again.");
                        }
                    } while (ch != 3);
                  // Code to handle option 2
                  break;
              case 3:
            	  System.out.print("Rate the us from 0 to 5: ");
                  int rating = scanner.nextInt();
                   // Consume newline
                  System.out.print("Enter your feedback message: ");
                  String message = scanner.next();
                  usernames.add(username);
                  ratings.add(rating);
                  messages.add(message);
                  System.out.println("Thank you for your feedback: ");
                  // Code to handle option 3
                  break;
              case 4:
            	  List<CoUserData.Event> events = CoUserData.aevents;
            	  System.out.print("Enter your budget: ");
                  double budget = scanner.nextDouble();

                  System.out.println("Events within your budget:");
                  boolean foundEventWithinBudget = false;
                  for (int i = 0; i < events.size(); i++) {
                	  CoUserData.Event event = events.get(i);
                	  if (event.getPrice() <= budget) {
                     
                      System.out.println((i + 1) + ". Name: " + event.getEventName() + ", Date: " + event.getEventDate() + ", Location: " + event.getLocation() + ", Description: " + event.getDescription());
                      foundEventWithinBudget=true;
                	  }
                	  }
                  if(foundEventWithinBudget==true) {
                  System.out.print("Choose an event by entering its number : ");
                  int cho = scanner.nextInt();
                  if (cho > 0 && cho <= events.size()) {
                      System.out.print("Enter your card number to pay: ");
                      long cardNumber = scanner.nextLong();
                      System.out.println("Payment successful for event " + cho+"contact with owner ");
                  } else {
                      System.out.println("Event not chosen. Exiting...");
                  }
                  }else {
                      System.out.println("no events less than your budget");

                  }
                 
                  
            	  break;
              case 5:
            	  System.out.println("Editing Profile...");

                  System.out.print("Enter new User name: ");
                  String newName = input1.next();
                
                  System.out.print("Enter new password: ");
                  String newPassword = input1.next();
                  System.out.println(u.editProfile(newName,newPassword));
                  break;
              case 6:
            	  System.out.print("Enter the name of the item you want to search for: ");
                  String itemeName = scanner.next();
                  Item.searchAndDisplayItem(Item.itemList, itemeName);
            	  break;
              case 7:
                  System.out.println("Exiting the program...");
                  break;
              default:
                  System.out.println("Invalid choice! Please choose again.");
          }
      } while (choice != 7);
      break;
}
	    co = sign.getUserData(username);
	     if (co != null) {

	        String emailCo = co.getEmail();
	        test2 = CoUserData.isValidEmail(emailCo);

	        test = login.COauthenticate(username, pass);

	        if (test==false) {
	            
	            int choice;
	            do {
	            	 co.displayHomePage();
	                System.out.print("Enter your choice: ");
	                choice = input1.nextInt();

	                switch (choice) {
	                    case 1:
	                        System.out.println("Editing Profile...");

	                        System.out.print("Enter new name: ");
	                        String newName = input1.next();
	                        System.out.print("Enter new email: ");
	                        String newEmail = input1.next();
	                        System.out.print("Enter new password: ");
	                        String newPassword = input1.next();
	                        System.out.println(co.editProfile(newName, newEmail, newPassword));
	                        break;
	                    case 2:
	                        System.out.println("Creating New Event...");

	                        System.out.print("Enter event name: ");
	                        String eventName = input1.next();
	                        System.out.print("Enter event date (dd/mm/yyyy): ");
	                        String eventDate = input1.next();
	                        System.out.print("Enter event location: ");
	                        String location = input1.next();
	                        System.out.print("Enter event description: ");
	                        String description = input1.next();
	                        System.out.print("Enter event price: ");
	                        double price = input1.nextDouble();
	                        System.out.println(co.createNewEvent(eventName, eventDate, location, description,price,"pending"));
	                        
	                        break;
	                    case 3:
	                        System.out.println("Viewing My Events...");
	                        List<CoUserData.Event> events = co.getEvents();
	                        for (CoUserData.Event event : events) {
	                            System.out.println("Name: " + event.getEventName() + ", Date: " + event.getEventDate() + ", Location: " + event.getLocation() + ", Description: " + event.getDescription()+ ", Status: " +event.getstatus());
	                        }
	                        break;
	                    case 4:
	                    	Scanner scanner = new Scanner(System.in);
	                    	System.out.print("Enter the name of the event you want to update: ");
        	            	boolean x=true;
        	                String eventname;
        	                Event eventToUpdate ;
        	                do {
        	                	eventname = scanner.next();
        	                	eventToUpdate=Event.getEventByName(eventname);
        	                	if(eventToUpdate==null) {
        	                	 System.out.println("This event does not exist, please rewrite the name");
        	                	}else {
        	                		x=false;
        	                	}
        	                }while(x);


        	                    System.out.println("Event found: " + eventToUpdate.getEventName());
        	                    // Prompt the user to enter the new details
        	                    System.out.println("Enter the new details for the event:");
        	                    System.out.print("event new name: ");

        	                    String namee = scanner.next();
        	                    System.out.print("Date: ");

        	                    String datee = scanner.next();
        	                    System.out.print("Location: ");
        	                    String locationn = scanner.next();
        	                    System.out.print("Description: ");
        	                    String d = scanner.next();
        	                   
        	                    System.out.print("Price: ");
        	                    double pricee = scanner.nextDouble();
        	                    eventToUpdate.setName(namee);
        	                    eventToUpdate.settPrice(pricee);
        	                    eventToUpdate.setLocation(locationn);
        	                    eventToUpdate.setDescription(d);
        	                    eventToUpdate.settDate(datee);
        	                    
        	                    System.out.println("Event updated successfully.");
	                    	break;
	                    case 5:
	                        System.out.println("Logging out...");
	                     ;   test = false;
	                        break;
	                    default:
	                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
	                }
	            } while (choice != 5);
	        } else {
	            System.out.println("Invalid username or password.");
	            test =true;
	        }
	        break;
	    }  
	    	 test1=login.aauthenticate(username,pass);
		     if(test1) {

		     Scanner scanner = new Scanner(System.in);
		        int c;

		        do {
		            System.out.println("Admin Page");
		            System.out.println("1. Event Management");
		            System.out.println("2. Venue Mangement");
		            System.out.println("3. viewing feedback");
		            System.out.println("4. Exit");
		            System.out.print("Enter your choice: ");
		            c = scanner.nextInt();

		            switch (c) {
		                case 1:
		                    int chh;
		                do {

	            	        	//Scanner scanner = new Scanner(System.in);

	            	            System.out.println("1. resarvatins approval");
	            	            System.out.println("2. Approval of Ready package");
	            	            System.out.println("3. Deleting an Event");
	            	            System.out.println("4. view calendar");
	            	            System.out.println("5. Back:");
	            	            System.out.print("Enter your choice: ");
	            	            chh = scanner.nextInt();
	            	            if (chh == 1) {
	            	                System.out.println("Reservations:");
	            	                for (int i = 0; i < CalendarEvent.eList.size(); i++) {
	            	                    System.out.println((i + 1) + ". " + CalendarEvent.eList.get(i));
	            	                }

	            	                // Prompt user to choose a reservation
	            	                System.out.print("Choose a reservation number: ");
	            	                int choice = scanner.nextInt();
	            	              

	            	                if (choice >= 1 && choice <= CalendarEvent.eList.size()) {
	            	                    CalendarEvent selectedEvent = CalendarEvent.eList.get(choice - 1); // Adjust for 0-based index

	            	                    // Prompt user to accept or reject the chosen reservation
	            	                    System.out.print("Accept (y/n): ");
	            	                    String decision = scanner.next().trim().toLowerCase();

	            	                    if (decision.equals("y")) {
	            	                        CalendarEvent.aList.add(selectedEvent);
	            	                        CalendarEvent.eList.remove(selectedEvent);
	            	                        System.out.println("Reservation approved.");
	            	                        sendEmail(selectedEvent.email, "Reservation Approval", "Approved");
	            	                    } else if (decision.equals("n")) {
	            	                        CalendarEvent.eList.remove(selectedEvent);
	            	                        System.out.println("Reservation rejected.");
	            	                        sendEmail(selectedEvent.email, "Reservation Approval", "Rejected");
	            	                    } else {
	            	                        System.out.println("Invalid choice.");
	            	                    }
	            	                } else {
	            	                    System.out.println("Invalid reservation number.");
	            	                }
	            	            

	            	            	}else if(chh==2) {

	            	            		 System.out.println("Events:");
	            	            	        for (int i = 0; i < CoUserData.events.size(); i++) {
	            	            	            System.out.println((i + 1) + ". " + CoUserData.events.get(i));
	            	            	        }

	            	            	        // Prompt user to choose an event by number
	            	            	        System.out.print("Choose an event number: ");
	            	            	        int choice = scanner.nextInt();
	            	            	        

	            	            	        if (choice >= 1 && choice <= CoUserData.events.size()) {
	            	            	            Event selectedEvent = CoUserData.events.get(choice - 1); // Adjust for 0-based index

	            	            	            // Prompt user to accept or reject the chosen event
	            	            	            System.out.print("Accept (y/n): ");
	            	            	            String decision = scanner.next().trim().toLowerCase();

	            	            	            if (decision.equals("y")) {
	            	            	                // Assuming CoUserData.aevents is a List<Event> for accepted events
	            	            	                CoUserData.aevents.add(selectedEvent);
	            	            	                CoUserData.events.get(choice - 1).setstatus("ibraheem does not reply to adham call");
	            	            	                System.out.println("Event approved.");
	            	            	                sendEmail(selectedEvent.e, "Event Approval", "Approved");
	            	            	            } else if (decision.equals("n")) {
	            	            	                System.out.println("Event rejected.");
	            	            	                CoUserData.events.get(choice - 1).setstatus("rejected");
	            	            	                sendEmail(selectedEvent.e, "Event Approval", "Rejected");
	            	            	            } else {
	            	            	                System.out.println("Invalid choice.");
	            	            	            }
	            	            	        } else {
	            	            	            System.out.println("Invalid event number.");
	            	            	        }
	            	            	

		            	                

	            	            	}else if(chh==3) {
	            	            		
	            	            		   System.out.println("Events:");
	            	            	        for (int i = 0; i < CalendarEvent.aList.size(); i++) {
	            	            	            System.out.println((i + 1) + ". " + CalendarEvent.aList.get(i));
	            	            	        }

	            	            	        System.out.print("Enter the number of the event to delete (0 to cancel): ");
	            	            	        int choice = scanner.nextInt();

	            	            	        if (choice > 0 && choice <= CalendarEvent.aList.size()) {
	            	            	        	CalendarEvent.aList.remove(choice - 1);
	            	            	            System.out.println("Event deleted successfully.");
	            	            	        } else if (choice == 0) {
	            	            	            System.out.println("Deletion cancelled.");
	            	            	        } else {
	            	            	            System.out.println("Invalid choice. No event deleted.");
	            	            	        }
	            	            	}else if(chh==4) {
        	            	            System.out.println("Calendar:");
        	            	            
        	            	            for (CalendarEvent event :CalendarEvent.aList ) {
        	            	                System.out.println(event);
        	            	            }


	            	            	}else if(chh==5) {
	            	            		 System.out.println("back ....");
	            	            	}
	           	            
		                }while(chh!=5);

	          break;
		                    
		                case 2:
		                	 int choice;

		            	     do {

		            	        	//Scanner scanner = new Scanner(System.in);

		            	            System.out.println("1. Add a new venue");
		            	            System.out.println("2. Update a venue");
		            	            System.out.println("3. View all venues");
		            	            System.out.println("4. check availble venues");
		            	            System.out.println("5. Exit");

		            	            System.out.print("Enter your choice: ");
		            	            choice = scanner.nextInt();

		            	            if (choice == 1) {
		            	            	System.out.println("venue name:");
		            	            	String vname = scanner.next();
		            	            	if(!(Venue.getVenueByName(vname)==null)) {
		            	            		System.out.println("venue name is already exist please enter another name ");
		            	            		vname=scanner.next();
		            	            	}
		            	            	System.out.println("Status (indoor/outdoor):");
		            	            	String sname = scanner.next();
		            	            	System.out.println("venue location:");
		            	            	String lname = scanner.next();
		            	            	System.out.println("venue capacity:");
		            	            	int cname = scanner.nextInt();
		            	            	System.out.println(" Venue Availability (true/false):");

		            	            	String aname = scanner.next();
		            	            	boolean value;
		            	            	if (aname.equalsIgnoreCase("true")) {
		            	            		   value = true;
		            	                }else if(aname.equalsIgnoreCase("false")) {
		            	                	value=false;
		            	                } else {
		            	                	value=false;
		            	                }
		            	            	System.out.println("venue price:");
		            	            	double pname = scanner.nextDouble();

		            	            	Venue newvenue=new Venue(vname,sname,lname,cname,value,pname);
		            	            	Venue.venueList.add(newvenue);
		            	            	 System.out.println("the venue added successfully");

		            	            } else if (choice == 2) {
		            	            	System.out.print("Enter the name of the venue you want to update: ");
		            	            	boolean x=true;
		            	                String venueName;
		            	                Venue venueToUpdate ;
		            	                do {
		            	                	venueName = scanner.next();
		            	                	venueToUpdate=Venue.getVenueByName(venueName);
		            	                	if(venueToUpdate==null) {
		            	                	 System.out.println("This venue does not exist, please rewrite the name");
		            	                	}else {
		            	                		x=false;
		            	                	}
		            	                }while(x);


		            	                    System.out.println("Venue found: " + venueToUpdate);
		            	                    // Prompt the user to enter the new details
		            	                    System.out.println("Enter the new details for the venue:");
		            	                    System.out.print("Status (indoor/outdoor): ");

		            	                    String status = scanner.next();
		            	                    System.out.print("Location: ");
		            	                    String location = scanner.next();
		            	                    System.out.print("Capacity: ");
		            	                    int capacity = scanner.nextInt();
		            	              //3      scanner.nextLine(); // Consume the newline character
		            	                    System.out.print("Availability (true/false): ");
		            	                    boolean availability = scanner.nextBoolean();
		            	                    System.out.print("Pricing: ");
		            	                    double pricing = scanner.nextDouble();
		            	                    venueToUpdate.setStatus(status);
		            	                    venueToUpdate.setLocation(location);
		            	                    venueToUpdate.setCapacity(capacity);
		            	                    venueToUpdate.setAvailability(availability);
		            	                    venueToUpdate.setPricing(pricing);
		            	                    System.out.println("Venue updated successfully.");



		            	            } else if (choice == 3) {
		            	            	 System.out.println("All Venues:");
		            	                 for (Venue venue :Venue.venueList ) {
		            	                     System.out.println(venue);
		            	                 }

		            	            }else if(choice== 4) {
		            	            	 System.out.println("Available Venues:");
		                             for (Venue venue : Venue.venueList) {
		                             	 if (venue.isAvailability()) {
		                                      System.out.println(venue);
		                             }

		                             }
		            	            }else if(choice==5) { System.out.println("Exiting the program...");
		            	            test=false;}
		            	             else {
		            	                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
		            	                
		            	            }
		            	        } while (choice !=5 );
		                    break;
		                case 3:
		                    System.out.println("feedbacks: ");
		                    for (int i = 0; i < usernames.size(); i++) {
		                        System.out.println("Username: " + usernames.get(i));
		                        System.out.println("Rating: " + ratings.get(i));
		                        System.out.println("Message: " + messages.get(i));
		                        System.out.println();
		                    }
		                    break;
		                case 4:
		                    System.out.println("Exiting the program...");
		                    test=false;
		                    break;
		                default:
		                    System.out.println("Invalid choice! Please choose again.");
		            }
		        } while (c != 4);
	
		 break;    }
		     test1=login.sauthenticate(username,pass);
		     if(test1){
		    	 Scanner scanner = new Scanner(System.in);
		    	 int choice;
		    	 do {
		             System.out.println("service provider page:");
		             System.out.println("1. Add a new item");
		             System.out.println("2. Edit an existing item");
		             System.out.println("3. Delete an item");
		             System.out.println("4. show items");
		             System.out.println("5. Exit");
		             System.out.print("Enter your choice: ");
		             choice = scanner.nextInt();


		            if(choice==1) {
		            	System.out.println("item name:");
		            	String iname = scanner.next();
		            	if(!(Item.getItemByName(iname)==null)) {
		            		System.out.println("item name is already exist please enter another name ");
		            		iname=scanner.next();
		            	}
		            	System.out.println("price:");
		            	Double pname = scanner.nextDouble();
		            	System.out.println("Item availability:");
		            	String aname = scanner.next();
		            	boolean value;
		            	if (aname.equalsIgnoreCase("true")) {
		            		   value = true;
		                }else if(aname.equalsIgnoreCase("false")) {
		                	value=false;
		                } else {
		                	value=false;
		                }

		            	System.out.println("item description:");
		            	String dname = scanner.next();

		            	System.out.println(" item  category");
		            	String cname = scanner.next();



		            	Item newitem= new Item(iname,pname,value,dname,cname);
		            	Item.itemList.add(newitem);
		            	if(cname.equals("food")) {Item.foodList.add(newitem);}else if(cname.equals("singer") ) {Item.singersList.add(newitem);}else if(cname.equals("decorations")) {Item.decorationsList.add(newitem);}else if(cname.equals("photography studios")) {Item.photographyStudiosList.add(newitem);}
		            	 System.out.println("the item added successfully");
		            }else if(choice==2) {
		            	System.out.print("Enter the name of the item you want to update: ");
		            	boolean x=true;
		                String itemName;
		                Item itemToUpdate ;
		                do {
		                	itemName = scanner.next();
		                	itemToUpdate=Item.getItemByName(itemName);
		                	if(itemToUpdate==null) {
		                	 System.out.println("This item does not exist, please rewrite the name");
		                	}else {
		                		x=false;
		                	}
		                }while(x);
		                System.out.println("item found: " +itemToUpdate);
		                // Prompt the user to enter the new details
		                System.out.println("Enter the new details for the item:");
		                System.out.print("new price: ");
		                double pricing = scanner.nextDouble();

		                System.out.print("Availability (true/false): ");
		                boolean availability = scanner.nextBoolean();

		                System.out.print("item description: ");
		                String d = scanner.next();


		                itemToUpdate.setPrice(pricing);
		                itemToUpdate.setAvailability(availability);
		                itemToUpdate.setDescription(d);
		                itemToUpdate.setAvailability(availability);

		                System.out.println("item updated successfully.");
		                     }else if(choice==3) {
		                    	 System.out.print("Enter the name of the item to delete: ");
		                    	    String itemName = scanner.next();

		                    	    Item itemToDelete = Item.getItemByName(itemName);
		                    	    if (itemToDelete != null) {
		                    	    String c=itemToDelete.getCategory();
		                    	        Item.itemList.remove(itemToDelete);
		                    	        if(c.equals("food")) {Item.foodList.remove(itemToDelete);}else if(c.equals("singer") ) {Item.singersList.remove(itemToDelete);}else if(c.equals("decorations")) {Item.decorationsList.remove(itemToDelete);}else if(c.equals("photography studios")) {Item.photographyStudiosList.remove(itemToDelete);}
		                    	        System.out.println("Item deleted successfully.");
		                    	    } else {
		                    	        System.out.println("Item not found with the name: " + itemName);
		                    	    }

		                     }else if(choice==4) {
		                    	 System.out.println("which category you want show\n");
		                    	 System.out.println("1-all categories\n");
		                    	 System.out.println("2-food\n");
		                    	 System.out.println("3-singers\n");
		                    	 System.out.println("4-decorations\n");
		                    	 System.out.println("5-photography Studios\n");
		                    	 int o=scanner.nextInt();
		                    	 if(o==1) {

		                    	 System.out.println("All item:");
		    	                 for (Item item :Item.itemList ) {
		    	                     System.out.println(item);
		    	                 }
		                    	 }else if(o==2) {
		                    		 System.out.println("food list:");
		    	                 for (Item item :Item.foodList ) {
		    	                     System.out.println(item);
		    	                 }
		    	                 }else if(o==3) {
		    	                	 System.out.println("singers list:");
		    	                 for (Item item :Item.singersList ) {
		    	                     System.out.println(item);
		    	                 }}else if(o==4) { System.out.println("decorations List:");
		    	                 for (Item item :Item.decorationsList ) {
		    	                     System.out.println(item);
		    	                 }}else if(o==5) {
		    	                	 System.out.println(" photography Studios list:");
		    		                 for (Item item :Item.photographyStudiosList) {
		    		                     System.out.println(item);
		    	                 }
		                     }}else if (choice==5) {
		                    	 System.out.println("Exiting the program...");
		                    	 test=false;
		                    	 break;
		                     }



		         } while (true);
		break;     }else {
		    	 System.out.println("Incorrect password or user name. Please try again.");
		     }
	








    }break;}


case 4:{loop=false;
        break;}

default :{
	loop=false;
    break;}


	}
	}
}
	 public static void sendEmail(String to, String subject, String body) {
	        final String username = "hazim88@outlook.sa"; // Your email address
	        final String password = "hhss217hhssh"; // Your email password

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.office365.com"); // Your SMTP server
	        props.put("mail.smtp.port", "587"); // Port for SMTP (typically 587 for TLS)

	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                return new javax.mail.PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject(subject);
	            message.setText(body);

	            Transport.send(message);

	            System.out.println("Email sent successfully.");
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }

}





