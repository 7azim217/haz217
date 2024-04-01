package eventplanner;

import eventplanner.SignUp;

public class Login {

    protected SignUp signUpInstance;
    protected boolean loggedIn;
    
    public Login(SignUp signUpInstance) {
        this.signUpInstance = signUpInstance;
    }
    

    public boolean aauthenticate(String username, String password) {
        // Retrieve admin username and password from a secure source, such as environment variables or a configuration file
        String adminUsername = System.getenv("ADMIN_USERNAME");
        String adminPassword = System.getenv("ADMIN_PASSWORD");

        // Check if the provided username and password match the admin credentials
        if (adminUsername != null && adminPassword != null && username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Welcome to admin page!");
            return true;
        } else {
            // Incorrect credentials
            return false;
        }
   
    	
    	
   
	
        }
    public boolean sauthenticate(String username, String password) {
        // Retrieve user username and password from a secure source, such as environment variables or a configuration file
        String userUsername = System.getenv("USER_USERNAME");
        String userPassword = System.getenv("USER_PASSWORD");

        // Check if the provided username and password match the user credentials
        if (userUsername != null && userPassword != null && username.equals(userUsername) && password.equals(userPassword)) {
            System.out.println("Welcome to service provider");
            return true;
        } else {
            // Incorrect credentials
            return false;
        }
    }

    
    public boolean COauthenticate(String username, String password) {
        if (signUpInstance.cousernameExists(username)) {
           CoUserData couserData = signUpInstance.getUserData(username);
            if (password.equals(couserData.getPassword())) {
                System.out.println("Login successful to Cousre page!");
                return false;
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } else {
            System.out.println("Username does not exist. Please sign up.");
        }
        return true;
    }
    
    
    public void logout() {
        loggedIn = false;
        System.out.println("Logged out successfully.");
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

   public boolean usera(String username, String password) {
	   if (signUpInstance.usernameExists(username)) {
           String storedPassword = signUpInstance.userData.get(username);
           if (password.equals(storedPassword)) {
               System.out.println("Login successful to user page!");
               return false;
           } else {
               System.out.println("Incorrect password. Please try again.");
           }
       } else {
           System.out.println("Username does not exist. Please sign up.");
       }
       return true;
   }
            
   	
	
}
