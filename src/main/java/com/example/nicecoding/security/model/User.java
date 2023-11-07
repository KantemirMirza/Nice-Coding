//package com.example.nicecoding.security.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "\"User\"")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer Id;
//    private String firstname;
//    private String lastname;
//    private String email;
//    private String phone;
//    private String password;
//
//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable( name = "USER_ROLE",
//                joinColumns = {@JoinColumn(name = "user_id")},
//                inverseJoinColumns = {@JoinColumn(name = "role_id")}
//    )
//    Set<Role> roles = new HashSet<>();
//}
