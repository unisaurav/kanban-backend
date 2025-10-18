package com.example.jira_app.controller;

import com.example.jira_app.config.CustomException;
import com.example.jira_app.dto.UserResponseDTO;
import com.example.jira_app.service.UsersService;
import com.example.jira_app.model.UsersEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersServiceObj;
    @GetMapping("/allUsers")
    public List<UsersEntity> allUsers(){
        return usersServiceObj.getAllUser();
    }
    @PostMapping("/addUser")
        public ResponseEntity<UserResponseDTO> addUser(@Valid @RequestBody UsersEntity user) throws CustomException {
            if(usersServiceObj.UserExist(user)){
                throw new CustomException(22,"User Already in DB", HttpStatus.CONFLICT);
            }
      return   ResponseEntity.ok(usersServiceObj.addUser(user));
    }
    @DeleteMapping("/deleteUser/{id}")
    public Object deleteUser(@PathVariable Long id){
        System.out.println("Requested id to be deleted is " + id);
        return usersServiceObj.deleteUserWithId(id);
    }
    @GetMapping("/deleteAllUser")
    public String deleteAllUser(){
      return   usersServiceObj.deleteAllUser();
    }
}
