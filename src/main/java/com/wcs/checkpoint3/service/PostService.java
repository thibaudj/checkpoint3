package com.wcs.checkpoint3.service;

import com.wcs.checkpoint3.entity.Post;
import com.wcs.checkpoint3.entity.User;
import com.wcs.checkpoint3.repository.PostRepository;
import com.wcs.checkpoint3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).get();
    }

    public Post createPost(@RequestBody Post post) throws Exception {
        try {
            Post newPost = new Post();
            newPost.setUser(post.getUser());
            newPost.setMessage(post.getMessage());
            newPost.setImageUrl(post.getImageUrl());
            newPost.setCreatedAt(Instant.now());
            return postRepository.save(newPost);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Post updatePost(Long postId, Post post) throws Exception {
        try {
            Post postToUpdate = postRepository.findById(postId).get();
            postToUpdate.setMessage(post.getMessage());
            postToUpdate.setImageUrl(post.getImageUrl());
            postToUpdate.setUser(post.getUser());
            postToUpdate.setUpdatedAt(Instant.now());
            return postRepository.save(postToUpdate);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public boolean deletePost(Long id) {
        postRepository.deleteById(id);
        return true;
    }
}
