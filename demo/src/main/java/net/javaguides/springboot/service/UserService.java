package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserRegistrationDto;
import net.javaguides.springboot.model.User;

import java.util.List;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
    List<User> getAllUsers();
}
