package com.using.mapStruct.mapStruct.domain.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "user_name" , nullable = false, length = 50)
    private String user;
    @Column(name = "user_password", nullable = false, length = 100)
    private String password;
    @Column(name = "user_email", nullable = false, length = 100)
    private String email;
    @Column(name = "user_full_name", nullable = false, length = 100)
    private String fullName;
    @Column(name = "user_role", nullable = false, length = 20)
    private String role;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations = new HashSet<>();
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Loan> loan;
}