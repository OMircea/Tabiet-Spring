package com.tabiet.tabiet.controllers;


import com.tabiet.tabiet.models.User;
import com.tabiet.tabiet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

   @GetMapping("/this")
   public User getUser(String username){
        return userService.getUser(username);
   }

   @PostMapping("/add")
   public User addUser(@RequestBody User user){
        return userService.addUser(user);
   }



}
