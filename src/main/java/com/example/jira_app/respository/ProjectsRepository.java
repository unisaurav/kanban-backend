package com.example.jira_app.respository;
import com.example.jira_app.model.ProjectsEntity;
import com.example.jira_app.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProjectsRepository extends JpaRepository<ProjectsEntity,Long> {
    @Query(value = "select * from projects where owner_id=:id",nativeQuery = true)
    List<ProjectsEntity> findByOwner(@Param("id") Long id);

}
