package com.example.jira_app.dto;

import com.example.jira_app.model.UsersEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProjectRequestDTO {
    @NotNull(message = "Field name not found")
    private String name;
    @NotNull(message = "Field description not found")
    private String description;
    @NotNull(message = "Field owner not found ")
    private UsersEntity owner;
}
