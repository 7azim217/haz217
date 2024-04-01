package eventplanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {

	public String username;
	public String Pass;
	public String rePass;
	public String Email;
	public String Name;
    private static final AtomicReference<Pattern> emailPattern = new AtomicReference<>();
	 public Map<String, String> userData;
	    protected Map<String, CoUserData> couserData;
 List<User> userList = new ArrayList<>();
 User u =new User();

	
	public SignUp() {
		 userData = new HashMap<String, String>();
	        couserData = new HashMap<String, CoUserData>();
		
	}
	public boolean signUp(String username, String password, String repass, String ee) {
	    if (!password.equals(repass)) {
	        System.out.println("Passwords are not the same. Please rewrite your password.");
	        return false;
	    }
	    if (!isStrongPassword(password)) {
	        System.out.println("Your entered password is weak. Please choose a stronger password.");
	        return false;
	    }
	    if (userData.containsKey(username) || couserData.containsKey(username) || username.equals("admin") || username.equals("user")) {
	        System.out.println("Username already exists. Please choose another username.");
	        return false;
	    }
	    userData.put(username, password);
	    System.out.println("Sign up successful!");
	    User e = new User(username, password, ee);
	    userList.add(e);
	    return true;
	}
		    
		    
		    
	public boolean signUp_couser(String username, String name, String email, String password, String repass) {
	    if (!password.equals(repass)) {
	        System.out.println("Passwords are not the same. Please rewrite your password.");
	        return true;
	    }

	    if (!isStrongPassword(password)) {
	        System.out.println("Your entered password is weak. Please choose a stronger password.");
	        return true;
	    }

	

	    if (couserData.containsKey(username) || userData.containsKey(username) || username.equals("admin") || username.equals("user1234")) {
	        System.out.println("CoUsername already exists. Please choose another username.");
	        return true;
	    }

	    couserData.put(username, new CoUserData(name, email, password));
	    System.out.println("Sign up successful!");
	    return false;
	}

		    
	public void coenterdata(String usernam,String pass,String repass,String name,String email) {
		username=usernam;
		Pass=pass;
		rePass=repass;
		Email=email;
		Name=name;
	}
	
	public void enterdata(String usernam,String pass,String repass) {
		username=usernam;
		Pass=pass;
		rePass=repass;
		
	}
	
	public static boolean isStrongPassword(String password) {
        
        if (password.length() < 8) {
            return false;
        }

       
        boolean containsUppercase = false;
        
        boolean containsLowercase = false;
       
        boolean containsDigit = false;
        
        boolean containsSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                containsLowercase = true;
            } else if (Character.isDigit(ch)) {
                containsDigit = true;
            } else {
                containsSpecial = true;
            }
        }

        return containsUppercase && containsLowercase && containsDigit && containsSpecial;
    }
    
	



	public boolean isValiadcouser() {
	    if (!Pass.equals(rePass)) {
	        System.out.println("Passwords are not the same. Please rewrite your password.");
	        return false;
	    }

	    if (!isStrongPassword(Pass)) {
	        System.out.println("Your entered password is weak. Please choose a stronger password.");
	        return false;
	    }

	

	    if (couserData.containsKey(username) || userData.containsKey(username) || username.equals("admin") || username.equals("user1234")) {
	        System.out.println("CoUsername already exists. Please choose another username.");
	        return false;
	    }

	    return true;
	}

	
	public boolean isVallieduser() {
	    if (Pass.equals(rePass)) {
	        if (!isStrongPassword(Pass)) {
	            System.out.println("Your entered password is weak. Please choose a stronger password");
	            return false;
	        }
	        
	        if (!userData.containsKey(username) && !couserData.containsKey(username) && !username.equals("admin") && !username.equals("user1234")) {
	            return true;
	        } else {
	            System.out.println("Username already exists. Please choose another username.");
	            return false;
	        }
	    } else {
	        System.out.println("Passwords are not the same. Please rewrite your password");
	        return false;
	    }
	}
	
	  public boolean signup_couser() {
			if (isValiadcouser()) {
				 
				 couserData.put(username, new CoUserData(Name, Email, Pass));
	 	           System.out.println("Sign up successful!");
		     return true;
		     }
		     else {
		    	 return false;
		      

			}
		}
	    public CoUserData getUserData(String username) {
        return couserData.get(username);
    }
    public User getserData(String username) {
        return u.getUserByUsername(userList, username);
    }

    public boolean cousernameExists(String cousername) {
        return couserData.containsKey(cousername);
    }
    public boolean usernameExists(String username) {
        return userData.containsKey(username);
    }


	  
	
	public boolean signup_user() {
		if (isVallieduser()) {
			  userData.put(username, Pass);
	            System.out.println("Sign up successful!");
	     return true;
	     }
	     else {
	    	 return false;
	      

		}
	}
}
