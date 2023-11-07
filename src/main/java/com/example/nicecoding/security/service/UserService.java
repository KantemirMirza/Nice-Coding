//package com.example.nicecoding.security.service;
//
//import com.example.nicecoding.security.model.User;
//import com.example.nicecoding.security.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder encoder;
//
//    @Bean
//    public BCryptPasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    //Get All Users
//    public List<User> listOfUser() {
//        return userRepository.findAll();
//    }
//
//    //Get User By Id
//    public User findById(int id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    //Delete User
//    public void delete(int id) {
//        userRepository.deleteById(id);
//    }
//
//    //Save User
//    public void saveUser(User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//}
