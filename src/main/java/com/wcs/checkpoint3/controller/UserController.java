package com.wcs.checkpoint3.controller;

import com.wcs.checkpoint3.entity.Post;
import com.wcs.checkpoint3.entity.User;
import com.wcs.checkpoint3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://javangular-checkpoint3.jsrover.wilders.dev", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping
//    public ResponseEntity<User> create(@RequestBody User user) throws Exception {
//        User newUser = userService.createUser(user);
//        return new ResponseEntity<User>(newUser, HttpStatus.OK);
//    }

    @GetMapping
    public List<User> readAll() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User read(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) throws Exception {
        User userToUpdate = userService.updateUser(id, user);
        return new ResponseEntity<User>(userToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
