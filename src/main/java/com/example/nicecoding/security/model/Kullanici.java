package com.example.nicecoding.security.model;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
@Table(name = "kullanici")//, uniqueConstraints = @UniqueConstraint( columnNames = "email")
public class Kullanici {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "email", unique = true)
        private String email;
        private String password;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "kullanici_status", joinColumns = @JoinColumn(name = "kullanici_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "status_id", referencedColumnName = "id"))
        private Collection<Status> status;

        public Kullanici() {
        }

        public Kullanici(String firstName, String lastName, String email, String password, Collection<Status> status) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.status = status;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Collection<Status> getStatus() {
            return status;
        }

        public void setStatus(Collection<Status> status) {
            this.status = status;
        }
}
