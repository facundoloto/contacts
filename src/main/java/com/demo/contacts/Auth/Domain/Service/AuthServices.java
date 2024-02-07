package com.demo.contacts.Auth.Domain.Service;

import com.demo.contacts.Auth.Domain.Dto.AuthDto;
import com.demo.contacts.Auth.Domain.Dto.LoginDto;
import com.demo.contacts.Security.Jwt.IJWTUtilityServices;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthServices implements IAuthServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IJWTUtilityServices jwtUtilityService;

    @Override
    /**
     * Handles user login and generates a JWT (JSON Web Token) or returns an error message.
     *
     * @param loginRequest The login request containing user credentials.
     * @return A HashMap with either a JWT or an error message.
     * @throws Exception If an error occurs during the login process.
     */

    public HashMap<String, String> login(LoginDto loginRequest) throws Exception {
        try {
            // Initialize a HashMap to store the result (JWT or error message)
            HashMap<String, String> jwt = new HashMap<>();

            // Retrieve user information based on the provided email
            Optional<UserEntity> user = Optional.ofNullable(userRepository.findByEmail(loginRequest.getEmail()));

            // Check if the user is not registered
            if (user.isEmpty()) {
                jwt.put("error", "User not registered!");
                return jwt;
            }

            // Verify the password provided in the login request
            if (verifyPassword(loginRequest.getPassword(), user.get().getPassword())) {
                // If the password is correct, generate a JWT and add it to the HashMap


                jwt.put("id", String.valueOf(user.get().getId()));
                jwt.put("Name", user.get().getName());
                jwt.put("LastName", user.get().getLastName());
                jwt.put("jwt", jwtUtilityService.generateJWT(user.get().getId()));
            } else {
                // If authentication fails, add an error message to the HashMap
                jwt.put("error", "Authentication failed");
            }

            // Return the final result (JWT or error message)
            return jwt;
        } catch (IllegalArgumentException e) {
            // Catch and handle exceptions related to JWT generation
            System.err.println("Error generating JWT: " + e.getMessage());
            throw new Exception("Error generating JWT", e);
        } catch (Exception e) {
            // Catch and handle other unknown exceptions
            System.err.println("Unknown error: " + e.toString());
            throw new Exception("Unknown error", e);
        }
    }

    @Override
/**
 * Registers a new user and stores the user entity in the database.
 *
 * This method performs the following steps:
 * 1. Checks if the provided user already exists in the database.
 *    - If the user already exists, it returns an error message.
 * 2. Encodes the user's password using BCryptPasswordEncoder.
 * 3. Saves the user entity to the database.
 * 4. Returns a response HashMap indicating the success or failure of the registration process.
 *
 * @param user The UserEntity object representing the user to be registered.
 * @return A HashMap containing a registration message or an error message.
 * @throws Exception If an error occurs during the registration process.
 */
    public HashMap<String, String> register(UserEntity user) throws Exception {
        try {
            // Initialize a HashMap to store the registration response
            HashMap<String, String> response = new HashMap<>();

            // Retrieve all users from the database
            List<UserEntity> getAllUsers = userRepository.findAll();
            // Check if the provided user already exists in the database
            for (UserEntity repeatFields : getAllUsers) {
                if (Objects.equals(repeatFields.getEmail(), user.getEmail())) {
                    response.put("message", "User already exists!");
                    return response;
                }
            }

            // Encode the user's password using BCryptPasswordEncoder
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));

            // Save the user entity to the database
            userRepository.save(user);

            // Add a success message to the response HashMap
            response.put("message", "User created successfully!");

            // Return the final response
            return response;
        } catch (Exception e) {
            // Catch and propagate any exceptions that occur during the registration process
            throw new Exception(e.getMessage());
        }
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }
}
