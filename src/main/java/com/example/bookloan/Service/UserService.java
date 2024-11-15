package com.example.bookloan.Service;

import com.example.bookloan.Enum.Role;
import com.example.bookloan.Models.User;
import com.example.bookloan.Repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

   @Autowired
    private PasswordEncoder passwordEncoder;

   public User registerUser(String username, String password, boolean isActive) {

       if (userRepo.findByUsername(username).isPresent()) {
           throw new RuntimeException("Username already exist");
       }

       User user = new User();
       user.setUsername(username);
       user.setPassword(passwordEncoder.encode(password));
       user.setRole(Role.USER);
       user.setActive(isActive);

       return userRepo.save(user);
   }

   public Optional<User> findByUsername(String username) {
       return userRepo.findByUsername(username);
   }

   public User getUserById(Long id) {
       return userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
   }



}
