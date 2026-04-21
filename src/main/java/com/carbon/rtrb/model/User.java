package com.carbon.rtrb.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now(); }

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "status")
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;
}