package com.wcs.checkpoint3.service;

import com.wcs.checkpoint3.entity.Comment;
import com.wcs.checkpoint3.entity.Post;
import com.wcs.checkpoint3.repository.CommentRepository;
import com.wcs.checkpoint3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id).get();
    }

    public Comment createComment(@RequestBody Comment comment) throws Exception {
        try {
            Comment newComment = new Comment();
            newComment.setMessage(comment.getMessage());
            return commentRepository.save(newComment);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }
}
