package com.example.jira_app.service;

import com.example.jira_app.dto.UserResponseDTO;
import com.example.jira_app.model.UsersEntity;
import com.example.jira_app.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
    @Autowired
    UsersRepository userRepo;

    public Boolean UserExist(UsersEntity user){
      return userRepo.findByEmail(user.getEmail())!=null;
    }
    public UserResponseDTO addUser(UsersEntity user) {
            UsersEntity savedUser= userRepo.save(user);
            return  new UserResponseDTO(savedUser.getName(),savedUser.getEmail());
    }
    public List<UsersEntity> getAllUser (){
        System.out.println(userRepo.count());
      return   userRepo.findAll();
    }
    public String deleteAllUser(){
        userRepo.deleteAll();
        return "all user deleted ";
    }

    public String deleteUserWithId(Long id){
        userRepo.deleteById(id);
        return "User "+id+" deleted";
    }
}
