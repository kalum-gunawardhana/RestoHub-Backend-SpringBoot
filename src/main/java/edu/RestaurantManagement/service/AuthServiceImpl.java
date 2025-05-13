package edu.RestaurantManagement.service;

import edu.RestaurantManagement.entity.UserEntity;
import edu.RestaurantManagement.enums.UserRole;
import edu.RestaurantManagement.model.SignupRequest;
import edu.RestaurantManagement.model.UserModel;
import edu.RestaurantManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserModel createUser(SignupRequest signupRequest) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(signupRequest.getName());
        userEntity.setEmail(signupRequest.getEmail());
        userEntity.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        userEntity.setUserRole(UserRole.CUSTOMER);

        UserEntity savedUser = userRepository.save(userEntity);

        UserModel userModel = new UserModel();

        userModel.setId(savedUser.getId());
        userModel.setName(savedUser.getName());
        userModel.setEmail(savedUser.getEmail());
        userModel.setUserRole(savedUser.getUserRole());

        return userModel;
    }
}