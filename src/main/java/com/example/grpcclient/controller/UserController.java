package com.example.grpcclient.controller;

import com.example.grpcclient.database.UserDao;
import com.example.grpcclient.database.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao database;

//    public UserController(UserDao userDao) {
//    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity entity){
        return database.insert(entity);
    }

    @GetMapping
    public List<UserEntity> getAll(){
        return database.getAll();
    }

}
