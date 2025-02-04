package com.taskmsys.task_management.service;

import com.taskmsys.task_management.dto.UserDTO;
import com.taskmsys.task_management.entity.userEntity;
import com.taskmsys.task_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public userEntity createUser(UserDTO userDTO){
        userEntity newUser = new userEntity();
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());
        newUser.setCreatedAt(userDTO.getCreatedAt());
        newUser.setUpdatedAt(userDTO.getUpdatedAt());
        newUser.setRole(userDTO.getRole());

        return userRepository.save(newUser);
    }

    public List<userEntity>getAllUsers(){
        return userRepository.findAll();
    }

    public userEntity getUserbyId(long id){
        Optional<userEntity> user  = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User with ID#"+id+" Not Found!"));
    }

    public userEntity updateUser(long id, UserDTO userDTO){
        userEntity existingUser = getUserbyId(id);
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setCreatedAt(userDTO.getCreatedAt());
        existingUser.setUpdatedAt(userDTO.getUpdatedAt());
        existingUser.setRole(userDTO.getRole());

        return userRepository.save(existingUser);
    }

    public boolean deleteUser(long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
