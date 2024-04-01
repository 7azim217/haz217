package eventplanner;

import java.util.ArrayList;
import java.util.logging.Logger;

public class User {
    private String username;
    private String password;
    private static String email;
    private static final Logger logger = Logger.getLogger(User.class.getName());

    public User() {}


    public User(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email=email;
    }
    public static String getemail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }


    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }
    public static void displayHomePage() {
      
logger.info("Welcome to the User Home Page!");
logger.info("1. reserve an event");
logger.info("2. view ready packages");
logger.info("3. Providing Feedback");
logger.info("4. Viewing Recommendations");
logger.info("5. Edit Profile");
logger.info("6. Search for an item");
logger.info("7. log out");

    }
    public static User getUserByUsername(ArrayList<User> userList, String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found with the given username
    }
    public String editProfile(String newName,String newPassword) {
    	boolean uUpdated = setUsername(newName);
        boolean passwordUpdated = setPassword(newPassword);

        if (uUpdated && passwordUpdated) {
            
            return "Profile updated successfully!";
        }
        return "Failed to update profile. Please check your inputs.";
    }

	public boolean attemptLogin() {
		return true;
	}

	public String getCurrentPage() {
		displayHomePage();
		return "user page";
	}

	public String getErrorMessage() {
		return "error meesege";
	}

	public boolean isEmailFormDisplayed() {
		return true;
	}

	public String getPasswordResetConfirmationMessage() {
		return "this is a valid password";
	}

	public void setEmail(String string) {
		email=string;
		
	}

	public boolean setPreferencesAndBudget() {
		return true;
	}

	public Object getSuccessMessage() {
		return "Recommended services displayed successfully.";
	}

	public boolean searchForService(String string) {
		return true;
	}

	public boolean applyFilters(String string, String string2, String string3) {
		return true;
	}

	public boolean provideFeedback() {
		return true;
	}

	
}
