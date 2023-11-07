//package com.example.nicecoding.security.service;
//import com.example.nicecoding.security.model.User;
//import com.example.nicecoding.security.model.UserPrincipal;
//import com.example.nicecoding.security.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class MyUserDetailsService implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found!");
//        }
//        return new UserPrincipal(user);
//    }
//}
