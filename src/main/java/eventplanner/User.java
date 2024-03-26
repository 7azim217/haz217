package eventplanner;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private static String email;
    
    public User() {}

    // Constructor with both username and password
    public User(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email=email;
    }
    public static String getemail() {
        return email;
    }
    // Getters and setters for username
    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }

    // Getters and setters for password
    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }
    public static void displayHomePage() {
        System.out.println("Welcome to the User Home Page!");
        System.out.println("1. researve an event");
        System.out.println("2. view a ready pakges");
        System.out.println("3. Providing Feedback");
        System.out.println("4. Viewing Recommendations");
        System.out.println("5. Edit Profile");
        System.out.println("6. Search for an item");
        System.out.println("7. log out");

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
		// TODO Auto-generated method stub
		return true;
	}

	public String getCurrentPage() {
		displayHomePage();
		return "user page";
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return "error meesege";
	}

	public boolean isEmailFormDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getPasswordResetConfirmationMessage() {
		// TODO Auto-generated method stub
		return "this is a valid password";
	}

	public void setEmail(String string) {
		email=string;
		
	}

	public boolean setPreferencesAndBudget() {
		// TODO Auto-generated method stub
		return true;
	}

	public Object getSuccessMessage() {
		// TODO Auto-generated method stub
		return "Recommended services displayed successfully.";
	}

	public boolean searchForService(String string) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean applyFilters(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean provideFeedback() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
