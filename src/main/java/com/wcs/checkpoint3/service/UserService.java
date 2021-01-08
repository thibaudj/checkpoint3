package com.wcs.checkpoint3.service;

import com.wcs.checkpoint3.entity.User;
import com.wcs.checkpoint3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(@RequestBody User user) throws Exception {
        try {
            User newUser = new User();
            newUser.setFirstname(user.getFirstname());
            newUser.setLastname(user.getLastname());
            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(Long userId, User user) throws Exception {
        try {
            User userToUpdate = userRepository.findById(userId).get();
            userToUpdate.setFirstname(user.getFirstname());
            userToUpdate.setLastname(user.getLastname());
            userToUpdate.setImageUrl(user.getImageUrl());
            return userRepository.save(userToUpdate);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
