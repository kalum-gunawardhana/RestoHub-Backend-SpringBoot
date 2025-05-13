package edu.RestaurantManagement.controller;

import edu.RestaurantManagement.model.SignupRequest;
import edu.RestaurantManagement.model.UserModel;
import edu.RestaurantManagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        UserModel userModel = authService.createUser(signupRequest);

        if (userModel == null){
            return new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }
}
