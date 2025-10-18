package com.example.jira_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class UsersEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment by the database
    private Long id ;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
}
