package eventplanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eventplanner.CoUserData;

public class SignUp {

	public String username;
	public String Pass;
	public String rePass;
	public String Email;
	public String Name;
	
	 protected Map<String, String> userData;
	    protected Map<String, CoUserData> couserData;
 ArrayList<User> userList = new ArrayList<User>();
 User u =new User();

	
	public SignUp() {
		 userData = new HashMap<String, String>();
	        couserData = new HashMap<String, CoUserData>();
		
	}
	public boolean signUp(String username, String password ,String repass,String ee) {
		   if(password.equals(repass)) {
			   
			   if (!isStrongPassword(password)) {
			    	System.out.println("your entered paas is week,please rewrite password");
			    	return true;
			    }
			   
			     if (!userData.containsKey(username)&&!couserData.containsKey(username)&&(username!="admin")&&(username!="user")) {
		            userData.put(username, password);
		            System.out.println("Sign up successful!");
		            User e=new User(username,password,ee);
		           
					userList.add(e);
		            return false;
		        } 
			 
		   else {
		            System.out.println("Username already exists. Please choose another username.");
		            return true;
		        }
		   }
		   else {
			   
			   System.out.println("password are not the same, Please rewrite your password");
			   return true;
		   }
		    }

		    
		    
		    public boolean signUp_couser(String username, String name, String email, String password,String repass) {

		    	   if(password.equals(repass)) {
		    		   if (!isStrongPassword(password)) {
					    	System.out.println("your entered paas is week,please rewrite password");
					    	return true;
					    }
				     
		    		   if (!isValidEmail(email)) {
		    	           
		    	            System.out.println("Email is not valid.");
		    	            return true;
		    	        }
		    		   if (!couserData.containsKey(username)&&!userData.containsKey(username)&&(username!="admin")&&(username!="user1234")) {
		    	            couserData.put(username, new CoUserData(name, email, password));
		    	            System.out.println("Sign up successful!");
		    	            return false;
		    		   }
		    		     
		    	   else {
		    	            System.out.println("coUsername already exists. Please choose another username.");
		    	            return true;
		    	        }
		    	   }
		    	   else {
		    		   
		    		   System.out.println("password are not the same, Please rewrite your password");
		    		   return true;
		    	   }
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
        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        boolean containsUppercase = false;
        // Check if password contains at least one lowercase letter
        boolean containsLowercase = false;
        // Check if password contains at least one digit
        boolean containsDigit = false;
        // Check if password contains at least one special character
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
    
	
	public static boolean isValidEmail(String email) {
        // Regular expression pattern for validating email addresses
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a Matcher object to match the pattern against the input email
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the regex pattern, false otherwise
        return matcher.matches();
    }
	
	public boolean isValiadcouser() {

 	   if(Pass.equals(rePass)) {
 		   if (!isStrongPassword(Pass)) {
			    	System.out.println("your entered paas is week,please rewrite password");
			    	return false;
			    }
		     
 		   if (!isValidEmail(Email)) {
 	           
 	            System.out.println("Email is not valid.");
 	            return false;
 	        }
 		   if (!couserData.containsKey(username)&&!userData.containsKey(username)&&(username!="admin")&&(username!="user1234")) {
 	           // couserData.put(username, new CoUserData(Name, Email, Pass));
 	           // System.out.println("Sign up successful!");
 	            return true;
 		   }
 		     
 	   else {
 	            System.out.println("coUsername already exists. Please choose another username.");
 	            return false;
 	        }
 	   }
 	   else {
 		   
 		   System.out.println("password are not the same, Please rewrite your password");
 		   return false;
 	   }
 	    }
 
	
	
	  public boolean isVallieduser() {
		   if(Pass.equals(rePass)) {
			   
			   if (!isStrongPassword(Pass)) {
			    	System.out.println("your entered paas is week,please rewrite password");
			    	return false;
			    }
			   
			     if (!userData.containsKey(username)&&!couserData.containsKey(username)&&(username!="admin")&&(username!="user1234")) {
		           // userData.put(username, password);
		           // System.out.println("Sign up successful!");
		            return true;
		        } 
			 
		   else {
		            System.out.println("Username already exists. Please choose another username.");
		            return false;
		        }
		   }
		   else {
			   
			   System.out.println("password are not the same, Please rewrite your password");
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
    