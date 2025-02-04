package com.taskmsys.task_management.controller;

import com.taskmsys.task_management.dto.UserDTO;
import com.taskmsys.task_management.entity.userEntity;
import com.taskmsys.task_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tms-users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<userEntity> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public userEntity getUserById(@PathVariable long id){
        return userService.getUserbyId(id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        userEntity createUser = userService.createUser(userDTO);
        return new ResponseEntity<>("User with email of " +createUser.getEmail() + " has been created", HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        try {
            userEntity updatedUser = userService.updateUser(id, userDTO);
            return new ResponseEntity<>("User with ID#" + updatedUser.getId() + " has been updated!", HttpStatus.OK);
        } catch (Exception e) {
            // Handle the case when user is not found
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (!isDeleted) {

            return new ResponseEntity<>("User ID#" + id + "Not Found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("User ID#" + id + " has been deleted.", HttpStatus.OK);
        }
    }
}
