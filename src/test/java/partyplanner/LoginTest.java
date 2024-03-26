package partyplanner;

import static org.junit.Assert.assertEquals;

import eventplanner.Login;
import eventplanner.SignUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	  Login user;
	    SignUp suser;
	    boolean result;
	    String username;
	    String pass;

	    public LoginTest() {
	    	
	    suser =new SignUp();
	    user=new Login(suser);
	    
	    }
	    
	   

	    @When("Admin enters credentials")
	    public void admin_enters_credentials() {
	       
	    assertEquals(false,!user.aauthenticate("admin", "admin"));
	    }

	    @Then("Admin gains access to the admin interface with the provided credentials")
	    public void admin_gains_access_to_the_admin_interface_with_the_provided_credentials() {
	   
	        assertEquals(false,!user.aauthenticate("admin", "admin"));

	    }
	    

	  

	    @When("User enters correct email and password.")
	    public void user_enters_correct_email_and_password() {
	    	suser.enterdata("ahmad", "Ah1@1234", "Ah1@1234");
	    	suser.signup_user();
	        assertEquals(false,!user.usera("ahmad", "Ah1@1234"));
	    }

	    @Then("User is logged into the application.")
	    public void user_is_logged_into_the_application() {
	    	suser.enterdata("ahmad", "Ah1@1234", "Ah1@1234");
	    	suser.signup_user();
	        assertEquals(false,!user.usera("ahmad", "Ah1@1234"));
	    	
	    }

	   

	 

	    @When("service provider enters credentials.")
	    public void service_provider_enters_credentials() {
	        assertEquals(false,!user.sauthenticate("user", "user"));
	    }

	    @Then("service provider gains access to the service provider interface with the provided credentials.")
	    public void service_provider_gains_access_to_the_service_provider_interface_with_the_provided_credentials() {
	        
	        assertEquals(false,!user.sauthenticate("user", "user"));

	    }

	   

	    @When("Adminenters incorrect email or incorrect password")
	    public void adminenters_incorrect_email_or_incorrect_password() {
	      
	    	 assertEquals(false,!user.aauthenticate("ahmad", "Ah1@134"));
	    }

	    @Then("System displays an error message")
	    public void system_displays_an_error_message() {
	    	 assertEquals(false,!user.aauthenticate("ahmad", "Ah1@134"));
	    }


	    @When("co_user  enters correct email and password.")
	    public void co_user_enters_correct_email_and_password() {
	    	suser.coenterdata("ahmadsa", "ahmad ", "ahmadsama@hotmail.com","Ah1@1234", "Ah1@1234");
          suser.signup_couser();
	   	 assertEquals(false,!user.COauthenticate("ahmadsa", "Ah1@1234"));

	    }

	    @Then("co_user  is logged into the co_user  page")
	    public void co_user_is_logged_into_the_co_user_page() {
	 
	    	suser.coenterdata("ahmadsa", "ahmad ", "ahmadsama@hotmail.com","Ah1@1234", "Ah1@1234");
          suser.signup_couser();
	      	 assertEquals(false,!user.COauthenticate("ahmadsa", "Ah1@1234"));

	    }

	    @When("co_user  tries to login with empty email or password field.")
	    public void co_user_tries_to_login_with_empty_email_or_password_field() {
	       
	      	 assertEquals(false,!user.COauthenticate("", ""));

	    }

	    @Then("System displays an error message prompting user to fill in all fields.")
	    public void system_displays_an_error_message_prompting_user_to_fill_in_all_fields() {
	      
	      	 assertEquals(false,!user.COauthenticate("", ""));

	    }


	
	
	
}