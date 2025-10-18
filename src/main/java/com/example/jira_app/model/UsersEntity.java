package com.example.jira_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment by the database
    private Long id ;
    @NotNull(message = "Field email should not be empty ")
    @Column(nullable = false)
    @Email(message = "Email must be in correct format")
    private String email;
    @Column(nullable = false)
    @NotNull(message = "Field name should not be empty ")
    private String name;
}
