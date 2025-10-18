package com.example.jira_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Table(name="projects")
@Data
@NoArgsConstructor
public class ProjectsEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @NonNull
    @ManyToOne
    @JoinColumn(name="owner_id",nullable = false)
    private UsersEntity owner;
}
