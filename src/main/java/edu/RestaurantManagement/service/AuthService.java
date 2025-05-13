package edu.RestaurantManagement.service;

import edu.RestaurantManagement.model.SignupRequest;
import edu.RestaurantManagement.model.UserModel;

public interface AuthService {
    UserModel createUser(SignupRequest signupRequest);
}
