package com.dio.livecoding.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.livecoding.springboot.dtos.UserDTO;
import com.dio.livecoding.springboot.model.UserModel;
import com.dio.livecoding.springboot.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserModel> getUsers() {
        log.error("getUsers");
        return userRepository.findAll();
    }

    public UserModel getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("msg {}", id);
            return new RuntimeException("User not found with id " + id);
        });
    };

    public UserModel create(UserDTO userDTO) {
        UserModel userModel = UserModel.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .build();
        return userRepository.save(userModel);
    }

    public UserModel update(Long id, UserDTO userDTO) {
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> {
            log.error("msg {}", id);
            return new RuntimeException("User not found with id " + id);
        });
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());

        return userRepository.save(userModel);
    }

    public UserModel delete(Long id) {
        UserModel userModel = userRepository.findById(id).orElseThrow(() -> {
            log.error("msg {}", id);
            return new RuntimeException("User not found with id " + id);
        });
        userRepository.delete(userModel);
        return userModel;
    }

}