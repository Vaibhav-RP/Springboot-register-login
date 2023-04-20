package com.example.loginregisterapp.entity;
import lombok.Data;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    

    @Column(unique = true)
    @NotBlank(message = "Username is required")
    private String username;


    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Password should contain only alphabets and numbers")
    @Size(min = 6, max = 20)
    @NotBlank(message = "Password is required")
    private String password;
    

    @NotBlank(message = "First Name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name should contain only alphabets")
    private String firstName;
    

    @NotBlank(message = "Last Name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name should contain only alphabets")
    private String lastName;
     

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;


    @NotBlank(message = "Address Line 1 is required")
    private String addressLine1;
    

    @NotBlank(message = "city and state is required")
    private String addressLine2;
        

    @NotBlank(message = "Postal Code is required")
    @Size(min = 6, max = 6, message = "Postal Code should be 6 digits")
    private String postalCode;
    

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "^[0-9]+$", message = "Phone Number should contain only numbers")
    private String phoneNumber;

}

