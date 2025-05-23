package edu.RestaurantManagement.model;

import edu.RestaurantManagement.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}