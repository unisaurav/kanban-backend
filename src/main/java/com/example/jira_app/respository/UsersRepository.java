package com.example.jira_app.respository;

import com.example.jira_app.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {
        UsersEntity findByEmail(String name);
}
