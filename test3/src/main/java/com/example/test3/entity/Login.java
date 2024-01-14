package com.example.test3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logins")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_account_name")
    private String appAccountName;

    @Column(name = "is_active")
    private boolean isActive;
}