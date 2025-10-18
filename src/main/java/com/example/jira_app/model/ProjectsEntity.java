package com.example.jira_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Table(name="projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public ProjectsEntity(@NotNull(message = "Field name not found") String name, @NotNull(message = "Field description not found") String description, @NotNull(message = "Field owner not found ") UsersEntity owner) {
        this.name=name;
        this.description=description;
        this.owner=owner;

    }
}
