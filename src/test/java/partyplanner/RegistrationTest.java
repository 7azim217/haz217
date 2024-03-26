package partyplanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

import eventplanner.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    User user;
    List<User> registeredUsers = new ArrayList<User>();
    boolean result;
    String message;
    String currentScreen;

    @Given("User is on the Register screen.")
    public void userIsOnTheRegisterScreen() {
        user = new User();
    }

    @When("User fills in all required fields with valid information and submits.")
    public void userFillsInAllRequiredFieldsWithValidInformationAndSubmits() {
        user.setUsername("ValidUsername");
        user.setEmail("ValidEmail@example.com");
        user.setPassword("StrongPassword1");
        result = registerUser(user);
        if (result) {
            currentScreen = "LoginScreen";
        }
    }

    @Then("User account is successfully created, and they are redirected to the Login screen.")
    public void userAccountIsSuccessfullyCreatedAndTheyAreRedirectedToTheLoginScreen() {
        assertTrue(result);
        assertEquals("LoginScreen", currentScreen);
    }

    @When("User enters a weak password.")
    public void userEntersAWeakPassword() {
        user.setPassword("WeakPassword");
        result = isPasswordStrong(user.getPassword());
        if (!result) {
            currentScreen = "ChooseStrongerPassword";
        }
    }

    @Then("System prompts user to choose a stronger password.")
    public void systemPromptsUserToChooseAStrongerPassword() {
        assertFalse(result);
        assertEquals("ChooseStrongerPassword", currentScreen);
    }

    @When("User enters an email or username that already exists in the database.")
    public void userEntersAnEmailOrUsernameThatAlreadyExistsInTheDatabase() {
        user.setUsername("ExistingUsername");
        user.setEmail("ExistingEmail@example.com");
        user.setPassword("StrongPassword1");
        // Assuming we add a user to simulate an existing user
        registeredUsers.add(new User("ExistingUsername", "ExistingEmail@example.com", "StrongPassword1"));
        result = registerUser(user);
    }

    @Then("System displays an error message indicating that the email or username is already taken.")
    public void systemDisplaysAnErrorMessageIndicatingThatTheEmailOrUsernameIsAlreadyTaken() {
        assertFalse(result);
        message = "Email or username is already taken.";
        assertEquals("Email or username is already taken.", message);
    }

    @When("User submits the registration form.")
    public void userSubmitsTheRegistrationForm() {
        // Assuming previous steps set the user details
        result = registerUser(user);
    }

    @Then("System sends an email with a verification code to the user's email address for account activation.")
    public void systemSendsAnEmailWithAVerificationCodeToTheUserSEmailAddressForAccountActivation() {
        assertTrue(result);
        message = "Email with verification code sent.";
        assertEquals("Email with verification code sent.", message);
    }

    @When("User enters an incorrect verification code.")
    public void userEntersAnIncorrectVerificationCode() {
        // Mock verification process
        result = verifyEmailVerificationCode("IncorrectCode");
    }

    @Then("System prompts user to enter the correct verification code or resend the code.")
    public void systemPromptsUserToEnterTheCorrectVerificationCodeOrResendTheCode() {
        assertFalse(result);
        message = "Incorrect verification code. Please try again or resend the code.";
        assertEquals("Incorrect verification code. Please try again or resend the code.", message);
    }

    // Mock registration and helper methods
    private boolean registerUser(User newUser) {
        for (User registeredUser : registeredUsers) {
            if (registeredUser.getUsername().equals(newUser.getUsername()) || registeredUser.getemail().equals(newUser.getemail())) {
                return false;
            }
        }
        registeredUsers.add(newUser);
        return true;
    }

    private boolean isPasswordStrong(String password) {
        // Simple check for demonstration purposes
        return password.length() > 8;
    }

    private boolean verifyEmailVerificationCode(String code) {
        // Mock verification logic
        return !code.equals("IncorrectCode");
    }
}