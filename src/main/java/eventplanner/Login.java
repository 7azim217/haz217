package eventplanner;

import eventplanner.CoUserData;
import eventplanner.SignUp;

public class Login {

    protected SignUp signUpInstance;
    protected boolean loggedIn;
    
    public Login(SignUp signUpInstance) {
        this.signUpInstance = signUpInstance;
    }
    

    public boolean aauthenticate(String username, String password) {
    	if (username.equals("admin")&&password.equals("admin")) {
    		System.out.println("Welcom to admin page !");
    		return true;
    	}
    	
    	
    	
   
		return false;
        }
    public boolean sauthenticate(String username, String password) {
    	if (username.equals("user")&&password.equals("user")) {
    		System.out.println("welcome to service provider");
    		return true;
    	}
    	
    	
    	
   
		return false;
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