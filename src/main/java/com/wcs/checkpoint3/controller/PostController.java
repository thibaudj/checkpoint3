package com.wcs.checkpoint3.controller;

import com.wcs.checkpoint3.entity.Post;
import com.wcs.checkpoint3.entity.User;
import com.wcs.checkpoint3.service.PostService;
import com.wcs.checkpoint3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://javangular-checkpoint3.jsrover.wilders.dev", maxAge = 3600)
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) throws Exception {
        Post newPost = postService.createPost(post);
        return new ResponseEntity<Post>(newPost, HttpStatus.OK);
    }

    @GetMapping
    public List<Post> readAll() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post read(@RequestParam(value = "id") Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> update(@RequestParam(value = "id") Long id, @RequestBody Post post) throws Exception {
        Post postToUpdate = postService.updatePost(id, post);
        return new ResponseEntity<Post>(postToUpdate, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public boolean delete(@RequestParam(value = "id") Long postId) {
//        return postService.deletePost(postId);
//    }
}
