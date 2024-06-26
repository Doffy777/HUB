package main.Model;

import java.util.List;

public class UserAccountManagement {
    private List<User> users;

    public UserAccountManagement(List<User> users) {
        this.users = users;
    }

    public void registerUser(String username, String password, UserPreferences preferences) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }

        // Create and add new user with preferences
        User newUser = new User(username, password, preferences);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    public void loginUser(String username, String password) {
        // Check if the username and password match
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public void saveUserPreferences(User user, UserPreferences preferences) {
        // Save user preferences
        user.setPreferences(preferences);
        System.out.println("User preferences saved successfully!");
    }

    public void saveUsersToCSV(String fileName) {
        User.writeUserToCSV(fileName, users);
    }
}
