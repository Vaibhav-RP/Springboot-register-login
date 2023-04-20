package com.example.loginregisterapp.entity;
import lombok.Data;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false,unique = true)
    private String username;
    
    @Size(min = 6, max = 20)
    @Column(nullable = false)
    private String password;
    
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(nullable = false)
    private String firstName;
    
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(nullable = false)
    private String lastName;
     
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String addressLine1;
    
    private String addressLine2;
        
    @Column(nullable = false)
    private String postalCode;
    
    @Pattern(regexp = "^[0-9]+$")
    @Column(nullable = false)
    private String phoneNumber;

}

